package cn.itcast_05_proxy.service.impl;

import cn.itcast_05_proxy.service.Person;

/**
 * PersonImpl
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/11/14</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class PersonImpl implements Person {
    /**
     * 说话的函数
     */
    @Override
    public void say() {
        System.out.println("说话--代理之前");
    }

    /**
     * 吃饭的函数
     */
    @Override
    public void eat() {
        System.out.println("吃饭--代理之前");

    }

    /**
     * 唱歌的函数
     */
    @Override
    public void sing() {
        System.out.println("唱歌--代理之前");

    }
}
