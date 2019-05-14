package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Entity
@Table(name="book",schema = "ebook",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "book_id"
)
public class Book {
    private int book_id;
    private String name;

    @Id
    @Column(name="book_id")
    public int getBook_id(){
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    @Basic
    @Column(name="name")
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
