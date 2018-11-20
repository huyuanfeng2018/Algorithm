package cn.itcast_05_proxy.service;

import cn.itcast_05_proxy.service.impl.PersonImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * PersonTest
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/11/14</BR>
 *
 * @author ��Դ��
 * @version 1.0
 * @since JDK1.7
 */
public class PersonTest {

    public static void main(String[] args) {
        PersonTest main = new PersonTest();
        main.dailiTest();

    }

    class PersonHandler implements InvocationHandler {

        public Person target;


        public PersonHandler(Person target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // System.out.println("ʵ�ִ�����Ŷ");
            String name = method.getName();
            if ("eat".equals(name)) {
                method.invoke(target);
                System.out.println("ʵ�ִ��������Ŷ");
            } else {
                method.invoke(target);
            }
            return null;
        }


        public Object getInstance(Person target) {
            Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{Person.class}, this);
            return o;
        }
    }



    /**
     * ������Է���
     */
    private   void dailiTest() {
        Person target = new PersonImpl();
        PersonHandler PersonHandler = new PersonHandler(new PersonImpl());
        Person instance = (Person) PersonHandler.getInstance(target);
        instance.eat();
        instance.say();

    }

}
