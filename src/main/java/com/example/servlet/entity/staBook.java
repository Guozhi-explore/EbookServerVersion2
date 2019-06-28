package com.example.servlet.entity;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/6/28
 * @description:
 **/
public class staBook {
    private Integer BookId;
    private String name;
    private Integer orderTimes;
    private Integer orderMoney;

    public staBook(Integer bookId, String name, Integer orderTimes, Integer orderMoney) {
        BookId = bookId;
        this.name = name;
        this.orderTimes = orderTimes;
        this.orderMoney = orderMoney;
    }

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer bookId) {
        BookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderTimes() {
        return orderTimes;
    }

    public void setOrderTimes(Integer orderTimes) {
        this.orderTimes = orderTimes;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }
}
