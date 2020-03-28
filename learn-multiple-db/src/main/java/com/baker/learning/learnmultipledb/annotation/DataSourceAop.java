package com.baker.learning.learnmultipledb.annotation;

import com.baker.learning.learnmultipledb.configuration.DBContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class DataSourceAop {

    @Pointcut("@annotation(com.baker.learning.learnmultipledb.annotation.Slave)")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.baker.learning.learnmultipledb.annotation.Master)")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read(JoinPoint point) {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(JoinPoint point) {
        DBContextHolder.master();
    }

//    /**
//     * 在每次切换数据源之后再次清除ThreadLocal中的数据源定义，防止线程重复使用时获取旧的数据源定义。
//     * @param point
//     */
//    @After(value = "writePointcut()")
//    public void afterSwitchDS(JoinPoint point) {
//        DBContextHolder.clearDatabaseSource();
//    }

}


