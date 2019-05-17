package com.example.servlet.service;

import com.example.servlet.entity.User;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface UserService {
    List<User> findAllUser();
    void saveOrUpdateUser(User user);
    User JudgeLogin(String account,String password);
    Integer JudgeRegister(User user);
    User findUserById(Integer ID);
}
