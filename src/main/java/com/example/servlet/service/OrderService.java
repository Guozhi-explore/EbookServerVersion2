package com.example.servlet.service;

import com.example.servlet.entity.Order;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/16
 * @description:
 **/

public interface OrderService {
    List<Order> allOrder();
    List<Order> selectUserOrder(Integer user_id,String time1,String time2);
    void saveOrder(Integer user_id,List<Integer> books,List<Integer> bookNum);
}
