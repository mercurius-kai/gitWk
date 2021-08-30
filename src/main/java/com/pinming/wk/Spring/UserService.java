package com.pinming.wk.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author： wangkai
 * @date： 2021-07-13 14:10:42
 */
@Component
public class UserService {

    @Autowired
    private OrderService orderService;

    public void test() {
        System.out.println("1111");
    }
}
