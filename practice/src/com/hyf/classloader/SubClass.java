package com.hyf.classloader;

/**
 * SubClass
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/10/31</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class SubClass extends SuperClass
{
    static
    {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass()
    {
        System.out.println("init SubClass");
    }
}