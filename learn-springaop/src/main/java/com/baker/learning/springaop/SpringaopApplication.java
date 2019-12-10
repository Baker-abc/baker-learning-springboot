package com.baker.learning.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * EnableAspectJAutoProxy 默认开启
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringaopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringaopApplication.class, args);
    }

}
