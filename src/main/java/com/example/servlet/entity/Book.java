package com.example.servlet.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Entity
@Table(name="book",schema = "ebook",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "book_id"
)
public class Book {

    private Integer book_id;
    private String name;
    private Integer price;
    private Integer amount;
    private String isbn;
    private String author;
    private Integer sales;
    private String abstrac;
    private String img_src;

    public Book()
    {

    }
    //java is not support default parameter
    public Book(Integer book_id,String name,Integer price,Integer amount,Integer sales,String author,String isbn,String abstrac,String img_src)
    {
        this.book_id=book_id;
        this.sales=sales;
        this.abstrac=abstrac;
        this.name=name;
        this.amount=amount;
        this.price=price;
        this.author=author;
        this.img_src=img_src;
        this.sales=sales;
        this.isbn=isbn;
    }

    @Id
    @Column(name="book_id")
    public int getBook_id(){
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Basic
    @Column(name="name")
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice(){
        return price;
    }

    @Basic
    @Column(name="amount")
    public Integer getAmount()
    {
        return amount;
    }

    @Basic
    @Column(name="isbn")
    public String getIsbn(){
        return isbn;
    }

    @Basic
    @Column(name="author")
    public String getAuthor()
    {
        return author;
    }

    @Basic
    @Column(name = "sales")
    public Integer getSales()
    {
        return sales;
    }

    @Basic
    @Column(name = "abstract")
    public String getAbstrac(){
        return abstrac;
    }

    @Basic
    @Column(name = "img_src")
    public String getImg_src(){
        return img_src;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAbstrac(String abstrac) {
        this.abstrac = abstrac;
    }
}
