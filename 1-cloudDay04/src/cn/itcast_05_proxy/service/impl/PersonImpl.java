package cn.itcast_05_proxy.service.impl;

import cn.itcast_05_proxy.service.Person;

/**
 * PersonImpl
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/14</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class PersonImpl implements Person {
    /**
     * ˵���ĺ���
     */
    @Override
    public void say() {
        System.out.println("˵��--����֮ǰ");
    }

    /**
     * �Է��ĺ���
     */
    @Override
    public void eat() {
        System.out.println("�Է�--����֮ǰ");

    }

    /**
     * ����ĺ���
     */
    @Override
    public void sing() {
        System.out.println("����--����֮ǰ");

    }
}
