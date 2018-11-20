package com.hyf.classloader;

/**
 * SSClass
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/10/31</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class SSClass
{
    static
    {
        System.out.println("SSClass");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static int value = 123;
    static
    {
        System.out.println(value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
