package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Entity
@Table(name="users",schema = "ebook",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "user_id"
)
public class User {
    private Integer uesr_id;
    private String account;
    private String password;
    private String mailbox;
    private String status;
    private Boolean ismanager;


    @Id
    @Column(name="user_id")
    public Integer getUesr_id() {
        return uesr_id;
    }

    @Basic
    @Column(name="user_id")
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

    public void setUesr_id(Integer uesr_id) {
        this.uesr_id = uesr_id;
    }
}
