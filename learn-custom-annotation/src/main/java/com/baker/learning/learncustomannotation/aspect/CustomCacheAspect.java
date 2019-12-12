package com.baker.learning.learncustomannotation.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/12/11 19:11
 */
@Aspect
@Component
@Log4j2
public class CustomCacheAspect {
    /**
     * 在方法执行之前对注解进行处理
     *
     * @param pjd
     * @param customCache 注解
     * @return 返回中的值
     */
    @Around("@annotation(com.baker.learning.learncustomannotation.aspect.CustomCache) && @annotation(customCache)")
    public Object dealProcess(ProceedingJoinPoint pjd, CustomCache customCache) throws Throwable {
        Object result = null;

        if (customCache.key() == null) {
            throw new RuntimeException("key为空");
        }

        //TODO 业务场景会比这个复杂的多，会涉及参数的解析如key可能是#{id}这些，数据查询
        //TODO 这里做简单演示，如果key为testKey则返回hello world
        if ("testKey".equals(customCache.key())) {
            return "hello word";
        }

        //执行目标方法
        try {
            result = pjd.proceed();
        } catch (Throwable throwable) {
            log.error(pjd.getSignature().getName() + " Exception...方法发生异常： " + throwable.getMessage());
            throw throwable;
        }

        return result;
    }
}
