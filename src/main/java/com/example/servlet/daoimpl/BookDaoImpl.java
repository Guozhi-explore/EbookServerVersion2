package com.example.servlet.daoimpl;

import com.example.servlet.dao.BookDao;
import com.example.servlet.entity.Book;
import com.example.servlet.repository.BookRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findall(){
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book)
    {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public Book selectBookById(Integer ID)
    {
        return bookRepository.getOne(ID);
    }

    @Override
    public void deleteBook(Integer ID)
    {
        bookRepository.deleteById(ID);
    }
}
