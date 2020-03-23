package com.baker.learning.learntransaction.service;

import com.baker.learning.learntransaction.mapper.UserMapper;
import com.baker.learning.learntransaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OtherService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method1(boolean haveException) {
        User user = new User();
        user.setName("b");
        userMapper.insertSelective(user);
        if (haveException) {
            throw new RuntimeException("OtherService method1 save 抛异常了");
        }
    }
}
