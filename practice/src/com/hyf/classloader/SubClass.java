package com.hyf.classloader;

/**
 * SubClass
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/10/31</BR>
 *
 * @author ��Դ��
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