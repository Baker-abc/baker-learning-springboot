package com.baker.learning.learncustomannotation.aspect;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * https://juejin.im/post/5cf376e16fb9a07eee5eb6eb
 *
 * @description
 * @date 2019/12/11 12:44
 */
@Component
public class CheckPermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CheckPermission checkPermission = findCheckPermission(handlerMethod);

        //如果没有添加权限注解则直接跳过允许访问
        if (checkPermission == null) {
            return true;
        }

        //获取注解中的值
        String resourceKey = checkPermission.resourceKey();

        // 一般在这里获取session中的用户信息做校验
        if ("testKey".equals(resourceKey)) {
            return true;
        }

        response.setStatus(401);
        return false;
    }

    /**
     * @param handlerMethod
     * @return
     */
    private CheckPermission findCheckPermission(HandlerMethod handlerMethod) {
        //在方法上寻找注解
        CheckPermission checkPermission = handlerMethod.getMethodAnnotation(CheckPermission.class);

        if (checkPermission == null) {
            //在类上寻找注解
            checkPermission = handlerMethod.getBeanType().getAnnotation(CheckPermission.class);
        }

        return checkPermission;
    }

}
