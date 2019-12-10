package com.baker.learning.springaop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description
 * @date 2019/12/9 21:12
 */
@Component
@Aspect
@Log4j2
@Order(4)
public class LogAroundAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.baker.learning.springaop.controller..*.*(..))")
    public void webLog() {
    }


    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        log.info("**********before:调用了" + jp.getTarget() + " 的" + jp.getSignature().getName()
                + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
        try {
            Object result = jp.proceed();
            log.info("调用了 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
                    + " 方法。");
            return result;
        } catch (Throwable e) {
            log.error(jp.getSignature().getName() + " Exception...方法发生异常： " + e);
            throw e;
        } finally {
            log.info(jp.getSignature().getName() + " ENDING.....方法执行结束");
        }

    }
}
