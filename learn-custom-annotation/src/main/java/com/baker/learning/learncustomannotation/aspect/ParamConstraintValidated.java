package com.baker.learning.learncustomannotation.aspect;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @date 2019/12/11 9:26
 */
public class ParamConstraintValidated implements ConstraintValidator<CheckParam, Object> {

    /**
     * 合法的参数值，从注解中获取
     */
    private List<String> paramValues;

    @Override
    public void initialize(CheckParam constraintAnnotation) {
        paramValues = new ArrayList<>(Arrays.asList(constraintAnnotation.paramValues()));
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (paramValues.contains(o)) {
            return true;
        }
        return false;
    }
}
