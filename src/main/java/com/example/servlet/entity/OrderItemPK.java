package com.example.servlet.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/17
 * @description:   联合主键
 **/
@Embeddable
public class OrderItemPK implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public OrderItemPK(){}

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItemPK(Order order, Book book)
    {
        this.order=order;
        this.book=book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //联合主键必须复写equal and hashCode 方法
    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;
        result=prime*result+((order==null)?0:order.hashCode());
        result=prime*result+((book==null)?0:book.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object)
    {
        if(this==object)
            return true;
        if(object==null)
            return  false;
        if(getClass()!=object.getClass())
            return false;
        final OrderItemPK other=(OrderItemPK) object;
        if(order==null){
            if(other.order!=null)
                return false;
        }else if(!order.equals(other.order))
            return false;
        if(book==null){
            if(other.book!=null)
                return false;
        }
        else if(!book.equals(other.book))
            return false;
        return true;
    }

}
