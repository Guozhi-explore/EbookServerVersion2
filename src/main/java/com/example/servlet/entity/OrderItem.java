package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/17
 * @description:
 **/
@Entity
@Table(name="order_item",schema = "ebook",catalog = "")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK PK=new OrderItemPK();

    private Integer number;

    public OrderItem(Order order,Book book,Integer number)
    {
        this.PK=new OrderItemPK(order,book);
        this.number=number;
    }
    public  OrderItem()
    {

    }
    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Transient
    public Order getOrder(){
        return this.PK.getOrder();
    }

    public void setOrder(Order order)
    {
        this.PK.setOrder(order);
    }

    @Transient
    public Book getBook(){
        return PK.getBook();
    }

    public void setBook(Book book){
        this.PK.setBook(book);
    }
}
