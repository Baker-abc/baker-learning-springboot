package com.baker.learning.learncustomannotation.controller;

import com.baker.learning.learncustomannotation.aspect.CheckPermission;
import com.baker.learning.learncustomannotation.aspect.CustomCache;
import com.baker.learning.learncustomannotation.model.UserReqVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/12/11 11:54
 */

@RestController
@Log4j2
public class TestController {

    @PostMapping("/test")
    public Object testCheckParam(@Validated @RequestBody UserReqVO userReqVO) {
        return userReqVO;
    }

    @GetMapping("/test")
    @CheckPermission(resourceKey = "testKey")
    public Object testCheckPermission() {
        return "hello";
    }

    @GetMapping("/test2")
    @CustomCache(key = "testKey")
    public Object testCustomCache() {
        return "hello";
    }
}
