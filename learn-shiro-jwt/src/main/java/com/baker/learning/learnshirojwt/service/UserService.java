package com.baker.learning.learnshirojwt.service;

import com.baker.learning.learnshirojwt.mapper.UserMapper;
import com.baker.learning.learnshirojwt.model.User;
import com.baker.learning.learnshirojwt.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @desc
 * @date 2020/2/6 0006 - 10:49
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)) {
            throw new RuntimeException("用户不存在");
        }
        return userList.get(0);
    }
}
