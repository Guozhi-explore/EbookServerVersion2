package com.example.servlet.dao;

import com.example.servlet.entity.User;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface UserDao {
    List<User> findAll();
    void saveOrUpdateUser(User user);
}
