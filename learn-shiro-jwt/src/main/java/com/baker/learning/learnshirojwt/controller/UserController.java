package com.baker.learning.learnshirojwt.controller;

import com.baker.learning.learnshirojwt.model.User;
import com.baker.learning.learnshirojwt.model.req.RespVO;
import com.baker.learning.learnshirojwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc
 * @date 2020/2/6 0006 - 11:17
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestParam String name, @RequestParam String password) throws Throwable {
        User user = userService.getByName(name);
        if (password.equals(user.getPassword())) {
            return new RespVO(200, "", "success");
        }
        return new RespVO(500, "", "fail");
    }

}
