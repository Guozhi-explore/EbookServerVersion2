package com.example.servlet.entity;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/6/28
 * @description:
 **/
public class staUser {
    private Integer userID;
    private String userName;
    private String mailbox;
    private Integer orderTime;
    private Integer orderMoney;
    private Integer orderBookNumber;

    public staUser(Integer userID, String userName, String mailbox, Integer orderTime, Integer orderMoney, Integer orderBookNumber) {
        this.userID = userID;
        this.userName = userName;
        this.mailbox = mailbox;
        this.orderTime = orderTime;
        this.orderMoney = orderMoney;
        this.orderBookNumber = orderBookNumber;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderBookNumber() {
        return orderBookNumber;
    }

    public void setOrderBookNumber(Integer orderBookNumber) {
        this.orderBookNumber = orderBookNumber;
    }
}
