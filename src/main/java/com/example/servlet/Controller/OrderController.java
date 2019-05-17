package com.example.servlet.Controller;

import com.example.servlet.entity.Book;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.OrderItem;
import com.example.servlet.service.BookService;
import com.example.servlet.service.OrderService;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/16
 * @description:
 **/

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    //url 形式?user_id=1&books=1,2,3&bookNum=1,1,1    前端试了axios不能直接生成这样的url，所以打算到时候拼接出url
    @GetMapping(value = "/saveOrder")
    public void saveOrder(@RequestParam(value = "user_id") Integer user_id, @RequestParam(value = "books") List<Integer> books,@RequestParam(value = "bookNum") List<Integer> bookNum)
    {
        orderService.saveOrder(user_id,books,bookNum);
    }

    @GetMapping(value = "/allOrder")
    public List<Order> allOrder()
    {
        return orderService.allOrder();
    }

}
