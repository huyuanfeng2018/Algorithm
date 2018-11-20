package com.spring.ioc.test;

import com.spring.ioc.config.configbease;
import com.spring.ioc.service.IndexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/9/26</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(configbease.class);
        IndexService bean = ac.getBean(IndexService.class);
        bean.index();

    }
}
