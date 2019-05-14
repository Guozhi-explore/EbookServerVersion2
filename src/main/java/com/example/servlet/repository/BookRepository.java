package com.example.servlet.repository;

import com.example.servlet.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookRepository extends JpaRepository<Book,Integer> {

}
