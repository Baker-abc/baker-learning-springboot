package com.baker.learning.learnredisapiidempotency;

import com.baker.learning.learnredisapiidempotency.annotation.ApiIdempotentInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LearnRedisApiIdempotencyApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(LearnRedisApiIdempotencyApplication.class, args);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 接口幂等性拦截器
        registry.addInterceptor(apiIdempotentInterceptor());
    }

    @Bean
    public ApiIdempotentInterceptor apiIdempotentInterceptor() {
        return new ApiIdempotentInterceptor();
    }
}
