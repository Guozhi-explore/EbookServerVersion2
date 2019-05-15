package com.example.servlet.serviceimpl;

import com.example.servlet.dao.UserDao;
import com.example.servlet.entity.User;
import com.example.servlet.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
