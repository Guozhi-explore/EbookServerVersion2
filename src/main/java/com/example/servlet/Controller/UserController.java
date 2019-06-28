package com.example.servlet.Controller;


import com.example.servlet.dao.UserDao;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.User;
import com.example.servlet.entity.staUser;
import com.example.servlet.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/allUser")
    public List<User> allUser()
    {
        return userService.findAllUser();
    }

    /**
     *
     * @param user_id
     * @param status
     */
    @GetMapping(value = "/changeUserStatus")
    public void saveOrUpdateUser(Integer user_id,String status){
            userService.saveOrUpdateUser(user_id,status);
            System.out.println(status);
    }

    /**
     *
     * @param user_id
     * @return
     */
    @GetMapping(value = "/userOrder")
    public List<Order> findUserOrder(Integer user_id)
    {
        return userService.findUserById(user_id).getOrderList();
    }


    /**
     *  request for login
     * @param account
     * @param password
     * @return
     */
    @GetMapping(value = "/judgeLogin")
    public User judgeLogin(String account,String password)
    {
        return userService.JudgeLogin(account,password);
    }

    /**
     *
     * @param account
     * @param password
     * @param mailbox
     * @param status
     * @param ismanager
     * @return
     */
    @GetMapping(value = "/judgeRegister")
    public Integer judgeRegister(String account,String password,String mailbox,String status, Boolean ismanager)
    {
        User user=new User(0,account,password,mailbox,status,ismanager);
        return userService.JudgeRegister(user);
    }

    /**
     *
     * @param time1
     * @param time2
     * @return
     */
    @GetMapping(value="/statisticUserData")
    public List<staUser> statisticUserData(String time1,String time2)
    {
        return userService.StatisticUserData(time1,time2);
    }


}
