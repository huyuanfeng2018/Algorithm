package com.hyf.classloader;

/**
 * SuperClass
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/10/31</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class SuperClass extends SSClass
{
    static
    {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass()
    {
        System.out.println("init SuperClass");
    }
}