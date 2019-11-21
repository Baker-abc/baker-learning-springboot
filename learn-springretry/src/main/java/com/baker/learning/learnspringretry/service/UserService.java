package com.baker.learning.learnspringretry.service;

import com.baker.learning.learnspringretry.exception.NeedRetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @description
 * @date 2019/11/21 9:01
 */
public interface UserService {

    @Retryable(value = { NeedRetryException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String getUser(String userId);

    @Recover
    public String getUserFallback(RuntimeException e);
}
