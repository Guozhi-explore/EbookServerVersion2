package com.example.servlet.service;

import com.example.servlet.entity.Book;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookService {
    List<Book> findAllBook();
    void saveOrUpdateBook(Book book);
    Book selectBookById(Integer ID);
}
