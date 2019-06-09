package com.example.servlet.dao;


import com.example.servlet.entity.Book;
import com.example.servlet.entity.BookCombination;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookDao {
    List<BookCombination> findall();
    void save(Book book);
    Book selectBookById(Integer ID);
    void deleteBook(Integer ID);
}
