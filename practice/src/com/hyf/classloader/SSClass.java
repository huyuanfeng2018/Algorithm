package com.hyf.classloader;

/**
 * SSClass
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/10/31</BR>
 *
 * @author ��Դ��
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
