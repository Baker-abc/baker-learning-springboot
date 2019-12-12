package com.baker.learning.learnspringcondition.service;

import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2019/12/12 20:03
 */

@Service
public class TestDependsOn {

    public int getTimeout() {
        return 50000;
    }
}
