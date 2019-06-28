package com.example.servlet.daoimpl;

import com.example.servlet.dao.BookDao;
import com.example.servlet.entity.Book;
import com.example.servlet.entity.BookCombination;
import com.example.servlet.entity.Comment;
import com.example.servlet.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.servlet.repository.CommentRepository;
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

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<BookCombination> findall(){
        List<Book> books=bookRepository.findAll();
        List<BookCombination> bookCombinations=new ArrayList<>();
        for(int i=0;i<books.size();++i)
        {
            BookCombination bookCombination=new BookCombination(books.get(i),commentRepository.findByBookId(books.get(i).getBook_id()));
            bookCombinations.add(bookCombination);
        }
        return bookCombinations;
    }

    @Override
    public void save(Book book)
    {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public Book selectBookById(Integer ID)
    {
        Book book= bookRepository.getOne(ID);
        return book;
    }


    @Override
    public void deleteBook(Integer ID)
    {
        bookRepository.deleteById(ID);
    }

    @Override
    public void addComment(Comment comment)
    {
        commentRepository.save(comment);
    }

}
