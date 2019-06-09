package com.example.servlet.entity;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/6/9
 * @description:
 **/
public class BookCombination {
    private Integer book_id;
    private String name;
    private Integer price;
    private Integer amount;
    private String isbn;
    private String author;
    private Integer sales;
    private String abstrac;
    private String img_src;
    private List<OrderItem> orderItems;
    private List<Comment> comments;

    public BookCombination()
    {}
    public BookCombination(Book book,List<Comment> comments)
    {
        this.book_id=book.getBook_id();
        this.abstrac=book.getAbstrac();
        this.name=book.getName();
        this.price=book.getPrice();
        this.amount=book.getAmount();
        this.isbn=book.getIsbn();
        this.author=book.getAuthor();
        this.sales=book.getSales();
        this.img_src=book.getImg_src();
        this.orderItems=book.getOrderItems();
        this.comments=comments;
    }
    public Integer getBook_id() {
        return book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getAbstrac() {
        return abstrac;
    }

    public void setAbstrac(String abstrac) {
        this.abstrac = abstrac;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
