package com.baker.learning.learnmultipledb.service.impl;

import com.baker.learning.learnmultipledb.annotation.Master;
import com.baker.learning.learnmultipledb.annotation.Slave;
import com.baker.learning.learnmultipledb.mapper.UserMapper;
import com.baker.learning.learnmultipledb.model.User;
import com.baker.learning.learnmultipledb.model.UserExample;
import com.baker.learning.learnmultipledb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeErrorException;
import java.util.List;


@Service
public class UseServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Slave
    @Transactional
    @Override
    public List<User> findAll2() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Master
    @Transactional
    @Override
    public List<User> findAll1() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Slave
    @SuppressWarnings("unused")
    @Transactional
    @Override
    public Long add2(String password, String username) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        int id = userMapper.insert(user);
        throw new RuntimeErrorException(new Error("error!!!!!"));
    }

    @Master
    @SuppressWarnings("unused")
    @Override
    public Long add1(String password, String username) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        int id = userMapper.insert(user);
        throw new RuntimeErrorException(new Error("error!!!!!"));
    }
}
