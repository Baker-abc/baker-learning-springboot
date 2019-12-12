package com.baker.learning.learncustomannotation.aspect;

import java.lang.annotation.*;

/**
 * @description
 * @date 2019/12/11 19:08
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomCache {

    String key();
}
