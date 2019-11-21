package com.baker.learning.learnspringretry.exception;

/**
 * @description 自定义异常，抛出该异常的方法将会触发重试
 * @date 2019/11/21 8:58
 */
public class NeedRetryException extends RuntimeException {

    public NeedRetryException(String message) {
        super(message);
    }

    public NeedRetryException(String message, Throwable cause) {
        super(message, cause);
    }

}
