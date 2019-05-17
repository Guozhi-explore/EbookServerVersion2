package com.example.servlet.serviceimpl;

import com.example.servlet.dao.BookDao;
import com.example.servlet.dao.UserDao;
import com.example.servlet.entity.BookItem;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.User;
import com.example.servlet.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import javax.validation.constraints.Null;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private BookDao bookDao;

    @Override
    public List<User> findAllUser(){
        return userDao.findAll();
    }

    @Override
    public void saveOrUpdateUser(User user)
    {
        userDao.saveOrUpdateUser(user);
    }

    @Override
    public User JudgeLogin(String account,String password)
    {
        List<User> allUser=userDao.findAll();
        for(int i=0;i<allUser.size();++i)
        {
            if(allUser.get(i).getAccount().equals(account)&&allUser.get(i).getPassword().equals(password))
            {
                return allUser.get(i);
            }
        }
        return null;
    }

    @Override
    public Integer JudgeRegister(User user)
    {
        List<User> allUser=userDao.findAll();
        for(int i=0;i<allUser.size();++i)
        {
            if(allUser.get(i).getAccount().equals(user.getAccount()))
                return 0;
        }
        this.saveOrUpdateUser(user);                   //hibernate 会将user更新
        return user.getUser_id();
    }

    @Override
    public User findUserById(Integer ID)
    {
        return userDao.findUserById(ID);
    }
    @Override
    public List<BookItem> getCartList(User user)
    {
        return userDao.getCartList(user);
    }

    @Override
    public void saveUserCart(Integer user_id,Integer book_id,Integer number)
    {
        User user=userDao.findUserById(user_id);
        List<BookItem> cartList=userDao.getCartList(user);
        BookItem bookItem=new BookItem(bookDao.selectBookById(book_id),number);
        cartList.add(bookItem);
       // user.set
    }
}
