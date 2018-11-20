package com.hyf.classloader;

/**
 * NotInitialization
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/10/31</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class NotInitialization
{
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> subClass = Class.forName("com.hyf.classloader.SubClass");


    }
}