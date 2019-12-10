package com.baker.learning.springaop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
@Order(3)
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.baker.learning.springaop.service.EmployeeService.*(..)) && args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
        log.info("Before method:" + joinPoint.getSignature());

        log.info("Creating Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(* com.baker.learning.springaop.service.EmployeeService.*(..)) && args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        log.info("After method:" + joinPoint.getSignature());

        log.info("Successfully created Employee with name - " + name + " and id - " + empId);
    }
}
