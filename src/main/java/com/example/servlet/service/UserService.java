package com.example.servlet.service;

import com.example.servlet.entity.BookItem;
import com.example.servlet.entity.Order;
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
    List<BookItem> getCartList(User user);
    void saveUserCart(Integer user_id,Integer book_id,Integer number);
}
