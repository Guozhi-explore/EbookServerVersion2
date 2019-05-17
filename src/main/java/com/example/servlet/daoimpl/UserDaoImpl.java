package com.example.servlet.daoimpl;

import com.example.servlet.dao.UserDao;
import com.example.servlet.entity.BookItem;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.User;
import com.example.servlet.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }
    @Override
    public void saveOrUpdateUser(User user)
    {
        userRepository.saveAndFlush(user);
    }
    @Override
    public User findUserById(Integer ID)
    {
        return userRepository.getOne(ID);
    }
    @Override
    public List<BookItem> getCartList(User user) {
        List<BookItem> cartList=new ArrayList<>();
        for(int i=0;i<user.getCartBookList().size();++i)
        {
            BookItem bookItem=new BookItem(user.getCartBookList().get(i),user.getCartBookNumberList().get(i));
            cartList.add(bookItem);
        }
        return cartList;
    }

}
