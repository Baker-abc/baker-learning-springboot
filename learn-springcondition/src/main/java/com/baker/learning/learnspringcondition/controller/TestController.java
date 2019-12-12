package com.baker.learning.learnspringcondition.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description
 * @date 2019/12/12 19:22
 */
@RestController
@Log4j2
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/test")
    public Object test() {
        return restTemplate.getForObject("http://localhost:8080/test", String.class);
    }
}
