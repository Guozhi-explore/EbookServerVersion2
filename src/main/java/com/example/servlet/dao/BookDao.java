package com.example.servlet.dao;


import com.example.servlet.entity.Book;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookDao {
    Book findOne(Integer id);
}
