package com.baker.learning.learnmultipledb.service;

import com.baker.learning.learnmultipledb.model.User;

import java.util.List;


public interface IUserService {

    List<User> findAll1();

    List<User> findAll2();

    Long add1(String password, String username);

    Long add2(String password, String username);
}
