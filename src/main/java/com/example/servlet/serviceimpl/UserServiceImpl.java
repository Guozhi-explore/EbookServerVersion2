package com.example.servlet.serviceimpl;

import com.example.servlet.dao.BookDao;
import com.example.servlet.dao.UserDao;
import com.example.servlet.entity.User;
import com.example.servlet.entity.staUser;
import com.example.servlet.service.UserService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveOrUpdateUser(Integer user_id,String status)
    {
        User user=userDao.findUserById(user_id);
        user.setStatus(status);
        userDao.saveOrUpdateUser(user);
        System.out.println(status);
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
        userDao.saveOrUpdateUser(user);                   //hibernate 会将user更新
        allUser=userDao.findAll();
        return allUser.get(allUser.size()-1).getUser_id(); //由于hibernate没有把user更新，使用这个蠢方法
    }

    @Override
    public User findUserById(Integer ID)
    {
        return userDao.findUserById(ID);
    }

    @Override
    public List<staUser> StatisticUserData(String time1, String time2)
    {
        List<User> userList=userDao.findAll();
        List<staUser> staUserList=new ArrayList<staUser>();
        for(int i=0;i<userList.size();++i)
        {
            int orderTimes=0;
            int orderMoney=0;
            int orderBookNumber=0;
            for(int j=0;j<userList.get(i).getOrderList().size();++j)
            {
                if(userList.get(i).getOrderList().get(j).getOrderTime().compareTo(time2)>0||userList.get(i).getOrderList().get(j).getOrderTime().compareTo(time1)<0)
                    continue;
                orderTimes++;
                orderMoney+=userList.get(i).getOrderList().get(j).getOrderMoney();
                for(int k=0;k<userList.get(i).getOrderList().get(j).getOrderItems().size();++k)
                {
                    orderBookNumber+=userList.get(i).getOrderList().get(j).getOrderItems().get(k).getNumber();
                }
            }
            staUser stauser=new staUser(userList.get(i).getUser_id(),userList.get(i).getAccount(),userList.get(i).getMailbox(),orderTimes,orderMoney,orderBookNumber);
            staUserList.add(stauser);
        }
        return staUserList;
    }
}
