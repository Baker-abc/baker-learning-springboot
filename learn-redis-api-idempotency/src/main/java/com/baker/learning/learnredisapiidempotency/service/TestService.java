package com.baker.learning.learnredisapiidempotency.service;

import com.baker.learning.learnredisapiidempotency.common.ServerResponse;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success");
    }


}
