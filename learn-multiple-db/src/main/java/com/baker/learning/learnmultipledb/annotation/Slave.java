package com.baker.learning.learnmultipledb.annotation;

import java.lang.annotation.*;

//适用于类
@Target({ElementType.TYPE, ElementType.METHOD})
//只在运行时保留
@Retention(RetentionPolicy.RUNTIME)
//被javadoc记录
@Documented
public @interface Slave {
}
