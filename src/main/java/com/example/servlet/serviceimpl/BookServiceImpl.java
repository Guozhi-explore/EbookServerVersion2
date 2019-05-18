package com.example.servlet.serviceimpl;

import com.example.servlet.dao.BookDao;
import com.example.servlet.entity.Book;
import com.example.servlet.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAllBook()
    {
        return bookDao.findall();
    }
    @Override
    public void updateBook(Integer book_id,String name,String author,String  isbn,String abstrac,String img_src,Integer price,Integer amount,Integer sales)
    {
        Book book=new Book(book_id,name,price,amount,sales,author,isbn,abstrac,img_src);
        bookDao.save(book);
    }
    @Override
    public Book selectBookById(Integer ID)
    {
        return bookDao.selectBookById(ID);
    }

    @Override
    public void addBook(String name,String author,String isbn,String abstrac,String img_src,Integer price,Integer amount)
    {
        Book book=new Book(0,name,price,amount,0,author,isbn,abstrac,img_src);
        bookDao.save(book);
    }

    @Override
    public void deleteBook(Integer ID)
    {
        bookDao.deleteBook(ID);
    }
}
