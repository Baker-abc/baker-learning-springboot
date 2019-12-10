package com.baker.learning.springaop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @description
 * @date 2019/12/9 21:12
 */
@Component
@Aspect
@Log4j2
@Order(2)
public class LogAspect {

    ThreadLocal<Long> requestTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.baker.learning.springaop.controller..*.*(..))")
    public void webLog() {
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        requestTime.set(System.currentTimeMillis());
        log.info("【doBefore】URL : " + request.getRequestURL().toString());
        log.info("【doBefore】HTTP_METHOD : " + request.getMethod());
        log.info("【doBefore】IP : " + request.getRemoteAddr());
        log.info("【doBefore】CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("【doBefore】ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        log.info("【doAfter】CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("【doAfter】ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("【doAfterReturning】RESPONSE : " + ret);
        log.info("【doAfterReturning】SPEND TIME: " + (System.currentTimeMillis() - requestTime.get()));
    }

    @AfterThrowing(pointcut = "webLog()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        log.error(joinPoint.getSignature().getName() + "****error**** ：" + throwable.getMessage());
    }
}
