package com.baker.learning.learnspringretry.api;

import com.baker.learning.learnspringretry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/11/21 9:09
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }
}
