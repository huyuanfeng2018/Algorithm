package com.hyf.classloader;

/**
 * NotInitialization
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/10/31</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class NotInitialization
{
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> subClass = Class.forName("com.hyf.classloader.SubClass");


    }
}