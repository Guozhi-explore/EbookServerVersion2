package com.example.servlet.Controller;

import com.example.servlet.entity.Book;
import com.example.servlet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/findBook/{id}")
    public Book findBook(@PathVariable("id") Integer id)
    {
        return bookService.findBookById(id);
    }
}
