package com.example.servlet.dao;

import com.example.servlet.entity.Order;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/16
 * @description:
 **/
public interface OrderDao {
    void saveOrder(Order order);
    List<Order> allOrder();
    List<Order> selectUserOrder(Integer user_id,String time1,String time2);
    Order selectOrderById(Integer order_id);
}
