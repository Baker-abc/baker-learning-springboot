package com.baker.learning.learnmultipledb.controller;

import com.baker.learning.learnmultipledb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all1")
    public Object all1() {
        return userService.findAll1();
    }

    @GetMapping("/all2")
    public Object all2() {
        return userService.findAll2();
    }

    @GetMapping("/add1")
    public Object add1() {
        return userService.add1("111", "111");
    }

    @GetMapping("/add2")
    public Object add2() {
        return userService.add2("222", "222");
    }
}
