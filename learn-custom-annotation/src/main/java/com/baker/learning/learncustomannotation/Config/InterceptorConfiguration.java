package com.baker.learning.learncustomannotation.Config;

import com.baker.learning.learncustomannotation.aspect.CheckPermissionInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @date 2019/12/11 13:22
 */

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckPermissionInterceptor());
    }
}
