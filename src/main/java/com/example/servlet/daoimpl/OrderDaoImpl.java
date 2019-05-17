package com.example.servlet.daoimpl;

import com.example.servlet.dao.OrderDao;
import com.example.servlet.entity.Order;
import com.example.servlet.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/16
 * @description:
 **/
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order)
    {
        orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> allOrder()
    {
        return orderRepository.findAll();
    }
    @Override
    public List<Order> selectUserOrder(Integer user_id, String time1, String time2)
    {
        //@Query(value = "select order_id from orders where user_id=:user_id and order_time>=:time1 and order_time<=:time2")
        //public List<Integer> selectUserOrderId(user_id,time1,time2);
        return null;
    }
    @Override
    public Order selectOrderById(Integer order_id)
    {
        return orderRepository.getOne(order_id);
    }
    @Override
    public List<Integer> selectOrder(String time1,String time2)
    {
        return null;
    }
}
