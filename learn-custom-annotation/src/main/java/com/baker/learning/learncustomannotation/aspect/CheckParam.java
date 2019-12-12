package com.baker.learning.learncustomannotation.aspect;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 使用该注解的字段会校验
 * @date 2019/12/11 9:21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ParamConstraintValidated.class)
public @interface CheckParam {

    /**
     * 合法的参数值
     */
    String[] paramValues();

    /**
     * 提示信息
     */
    String message() default "参数不为指定值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
