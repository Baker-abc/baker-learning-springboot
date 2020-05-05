package com.baker.learning.learntransaction.service;


import com.baker.learning.learntransaction.mapper.UserMapper;
import com.baker.learning.learntransaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OtherService otherService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save1(boolean haveException) {
        User user = new User();
        user.setName("a");
        userMapper.insertSelective(user);

        otherService.method1(haveException);
    }

}