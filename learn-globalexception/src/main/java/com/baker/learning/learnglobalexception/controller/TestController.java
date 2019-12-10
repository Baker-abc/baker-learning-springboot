package com.baker.learning.learnglobalexception.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/12/10 9:21
 */
@RestController
@Log4j2
public class TestController {

    @GetMapping(value = "/test")
    public String user() throws Exception {
        throw new Exception("跑个异常");
    }
}
