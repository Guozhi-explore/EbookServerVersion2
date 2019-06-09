package com.example.servlet.entity;

import javax.persistence.Id;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/6/7
 * @description:
 **/
public class Comment {
    @Id
    private String id;
    private Integer book_id;
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public String getComment() {
        return comment;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
