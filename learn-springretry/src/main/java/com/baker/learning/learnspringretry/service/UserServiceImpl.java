package com.baker.learning.learnspringretry.service;

import com.baker.learning.learnspringretry.exception.NeedRetryException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2019/11/21 9:04
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Override
    public String getUser(String userId) {
        if ("123".equals(userId)) {
            log.error("重试中");
            throw new NeedRetryException("制造个异常！");
        }

        return "success";
    }

    @Override
    public String getUserFallback(RuntimeException e) {
        return "查询用户异常了！" + e.getMessage();
    }
}
