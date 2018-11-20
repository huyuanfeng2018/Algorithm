package com.hyf.test;

/**
 * PathClassLoader
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/10/31</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TestClassLoad {
    @Override
    public String toString() {
        return "类加载成功。";
    }
}
public class PathClassLoader extends ClassLoader {
    private String classPath;

    public PathClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0, num);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void main(String args[]) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassLoader pcl = new PathClassLoader("E:\\project\\Web-Spider\\target\\classes");
        Class c = pcl.loadClass("com.WebSpider.Jsoup.Util.JsoupHtml");//注意要包括包名
         Object o = c.newInstance();
        Method m1 = c.getMethod("get");
        m1.invoke(o);

    }
}