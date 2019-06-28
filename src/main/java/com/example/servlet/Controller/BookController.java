package com.example.servlet.Controller;

import com.example.servlet.entity.Book;
import com.example.servlet.entity.BookCombination;
import com.example.servlet.entity.staBook;
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
    public List<BookCombination> findBook()
    {
        return bookService.findAllBook();
    }

    /**
     *
     * @param book_id
     * @param name
     * @param author
     * @param isbn
     * @param abstrac
     * @param img_src
     * @param price
     * @param amount
     * @param sales
     */
    @GetMapping(value="/UpdateBook")
    public void saveOrUpdateBook(Integer book_id,String name,String author,String  isbn,String abstrac,String img_src,Integer price,Integer amount,Integer sales)
    {
        bookService.updateBook(book_id, name, author, isbn, abstrac, img_src, price, amount, sales);
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

    /**
     *
     * @param name
     * @param author
     * @param isbn
     * @param abstrac
     * @param img_src
     * @param price
     * @param amount
     */
    @GetMapping(value = "/addBook")
    public void addBook(String name,String author,String isbn,String abstrac,String img_src,Integer price,Integer amount){
        bookService.addBook(name, author, isbn, abstrac, img_src, price, amount);
    }

    /**
     *
     * @param book_id
     */
    @GetMapping(value = "/deleteBook")
    public void deleteBook(Integer book_id)
    {
        bookService.deleteBook(book_id);
    }

    /**
     *
     * @param time1
     * @param time2
     * @return
     */
    @GetMapping(value = "/statisticBookData")
    public List<staBook> statisticBookData(String time1,String time2)
    {
        return bookService.statisticBookData(time1,time2);
    }
}
