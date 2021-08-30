package com.pinming.wk.Spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author： wangkai
 * @date： 2021-07-13 14:10:21
 */
public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = annotationConfigApplicationContext.getBean("userService", UserService.class);
        userService.test();
    }
}
