package com.baker.learning.learncustomannotation.aspect;

import java.lang.annotation.*;

/**
 * @description 有该注解标记的类或者方法会走校验逻辑（通过aop或者HandlerInterceptorAdapter ）
 * @date 2019/12/11 12:37
 */

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermission {

    String resourceKey();
}
