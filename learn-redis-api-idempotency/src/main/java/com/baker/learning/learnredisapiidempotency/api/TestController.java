package com.baker.learning.learnredisapiidempotency.api;

import com.baker.learning.learnredisapiidempotency.annotation.ApiIdempotent;
import com.baker.learning.learnredisapiidempotency.common.ServerResponse;
import com.baker.learning.learnredisapiidempotency.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @ApiIdempotent
    @PostMapping("testIdempotence")
    public ServerResponse testIdempotence() {
        return testService.testIdempotence();
    }

}
