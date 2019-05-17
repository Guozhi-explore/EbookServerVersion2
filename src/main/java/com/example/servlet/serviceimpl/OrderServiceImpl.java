package com.example.servlet.serviceimpl;

import com.example.servlet.dao.OrderDao;
import com.example.servlet.entity.Book;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.OrderItem;
import com.example.servlet.service.BookService;
import com.example.servlet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/16
 * @description:
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BookService bookService;


    @Override
    public List<Order> allOrder()
    {
        return orderDao.allOrder();
    }

    @Override
    public List<Order> selectUserOrder(Integer user_id,String time1,String time2)
    {
        return orderDao.selectUserOrder(user_id,time1,time2);
    }

    @Override
    public void saveOrder(Integer user_id,List<Integer> books,List<Integer> bookNum)
    {
        Integer orderMoney=0;
        List<Book> bookList=new ArrayList<>();
        List<Integer> bookNumList;
        List<OrderItem> orderItemList=new ArrayList<>();
        OrderItem orderItem;
        bookNumList=bookNum;
        for(int i=0;i<books.size();++i)
        {
            bookList.add(bookService.selectBookById(books.get(i)));
        }
        for(int i=0;i<bookList.size();++i)
        {
            orderMoney+=(bookList.get(i).getPrice()*bookNum.get(i));
        }
        Order order=new Order(user_id,orderMoney,orderItemList);
        orderDao.saveOrder(order);             //save后order主键得到更新，数据库自增
        order.setOrderItems(orderItemList);
        for(int i=0;i<books.size();++i)
        {
            orderItem=new OrderItem(order,bookService.selectBookById(books.get(i)),bookNumList.get(i));
            orderItemList.add(orderItem);
        }
        order.setOrderItems(orderItemList);
        orderDao.saveOrder(order);              //增加order订单项属性,save again

        for(int i=0;i<books.size();++i)
        {
            Book book=bookService.selectBookById(books.get(i));
            book.setSales(book.getSales()+bookNum.get(i));
            book.setAmount(book.getAmount()-bookNum.get(i));
            bookService.saveOrUpdateBook(book);
        }
    }
}
