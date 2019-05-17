package com.example.servlet.entity;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/15
 * @description:     将书籍和它的数量放在一起
 **/
public class BookItem {
    private Book book;
    private Integer bookNumber;

    public BookItem(Book book, Integer bookNumber)
    {
        this.book=book;
        this.bookNumber=bookNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }
}
