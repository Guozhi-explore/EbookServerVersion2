package com.example.servlet.repository;

import com.example.servlet.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
public interface BookRepository extends JpaRepository<Book,Integer> {
        //关于修改 jparepository会自动根据id是否存在来判断增加还是修改 save方法

}
