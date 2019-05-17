package com.example.servlet.Controller;

import com.example.servlet.entity.Book;
import com.example.servlet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/allBook")
    public List<Book> findBook()
    {
        return bookService.findAllBook();
    }

    @GetMapping(value="/saveOrUpdateBook/")
    public void saveOrUpdateBook()
    {
        Book book=new Book(14,"testtest",1,1,1,"test","#test","test","test");
        bookService.saveOrUpdateBook(book);
    }

    /**
     *
     * @param book_id
     * @return
     */
    @GetMapping(value = "/selectBookById")
    public Book selectBookById(Integer book_id)
    {
        return bookService.selectBookById(book_id);
    }
}
