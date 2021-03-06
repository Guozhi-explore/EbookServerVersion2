package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Entity
@Table(name="users",schema = "ebook",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class User {
    private Integer user_id;
    private String account;
    private String password;
    private String mailbox;
    private String status;
    private Boolean ismanager;
    private List<Order> orderList;

    public User(Integer user_id,String account,String password,String mailbox,String status,Boolean ismanager)
    {
        this.user_id=user_id;
        this.account=account;
        this.password=password;
        this.mailbox=mailbox;
        this.ismanager=ismanager;
        this.status=status;
        this.orderList=null;
    }

    public User()
    {

    }

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public Integer getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name="account")
    public String getAccount(){
        return account;
    }

    @Basic
    @Column(name = "password" )
    public String getPassword() {
        return password;
    }

    @Basic
    @Column(name="ismanager")
    public Boolean getIsmanager() {
        return ismanager;
    }

    @Basic
    @Column(name = "mailbox")
    public String getMailbox() {
        return mailbox;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="orders",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name="order_id"))
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setIsmanager(Boolean ismanager) {
        this.ismanager = ismanager;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
