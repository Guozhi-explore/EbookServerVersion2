package com.example.servlet.entity;

import javax.persistence.Id;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/6/7
 * @description: mongodb
 **/
public class Comment {
    @Id
    private String id;
    private Integer book_id;
    private String user_id;
    private String time;
    private String content;

    public Comment( Integer book_id, String user_id, String time, String content) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.time = time;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
