package com.baker.learning.learnspringredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2020/3/26 9:40
 */
@RestController
public class TestController {

    @Autowired
    Publisher publisher;

    @PostMapping("/test")
    public Object test() {
        publisher.publish(new UserInfo(1L, "bk", 28));
        return 0;
    }
}
