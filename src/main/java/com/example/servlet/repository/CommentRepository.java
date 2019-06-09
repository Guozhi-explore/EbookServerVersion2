package com.example.servlet.repository;

import com.example.servlet.entity.Comment;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/6/7
 * @description:
 **/
public interface CommentRepository extends MongoRepository<Comment, String>{
    @Query("{ 'book_id' : ?0 }")
    public List<Comment> findByBookId(Integer book_id);
}
