package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/15
 * @description:
 **/
@Entity
@Table(name="orders",schema = "ebook",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "order_id"
)
public class Order {


    private int order_id;
    private List<Book> bookList;
    private List<Integer> bookNum=new ArrayList<Integer>();
    private String orderTime;
    private Integer orderMoney;

    @Id
    @Column(name = "order_id")
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Basic
    @Column(name = "order_time")
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "total_money")
    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="order_item",joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn(name="book_id"))
    public List<Book> getBookList()
    {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="order_item",joinColumns = {@JoinColumn(name = "order_id",referencedColumnName = "order_id")})
    @Column(name = "number")
    public List<Integer> getBookNum(){
        return bookNum;
    }

    public void setBookNum(List<Integer> bookNum) {
        this.bookNum = bookNum;
    }
}
