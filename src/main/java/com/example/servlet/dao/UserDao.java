package com.example.servlet.dao;

import com.example.servlet.entity.BookItem;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface UserDao {
    List<User> findAll();
    void saveOrUpdateUser(User user);
    User findUserById(Integer ID);
    List<BookItem> getCartList(User user);
}
