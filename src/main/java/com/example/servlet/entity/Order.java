package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private List<OrderItem> orderItems;
    private String orderTime;
    private Integer orderMoney;
    private Integer user_id;

    public Order(Integer user_id,Integer orderMoney,List<OrderItem> orderItemList)
    {
        this.user_id=user_id;
        this.order_id=0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
        Date date = new Date();
        this.orderItems=null;
        this.orderTime=sdf.format(date);
        this.orderMoney=orderMoney;
        this.orderItems=null;
        return;
    }
    public Order(){}

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinTable(name="order_item",joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "order_id"))
    @OneToMany(mappedBy = "PK.order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "book")
    public List<OrderItem> getOrderItems(){
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
