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
    public void saveOrUpdateBook(Book book)
    {
        bookDao.save(book);
    }
    @Override
    public Book selectBookById(Integer ID)
    {
        return bookDao.selectBookById(ID);
    }
}
