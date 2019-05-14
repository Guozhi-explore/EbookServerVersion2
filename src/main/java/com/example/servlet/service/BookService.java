package com.example.servlet.service;

import com.example.servlet.entity.Book;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookService {
    Book findBookById(Integer id);
}
