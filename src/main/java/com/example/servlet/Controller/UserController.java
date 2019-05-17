package com.example.servlet.Controller;


import com.example.servlet.entity.BookItem;
import com.example.servlet.entity.Order;
import com.example.servlet.entity.User;
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

    @GetMapping(value = "/saveOrUpdateUser")
    public void saveOrUpdateUser(){

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
     *
     * @param user_id
     * @return
     */
    @GetMapping(value = "/userCart")
    public List<BookItem> findUserCart(Integer user_id)
    {
        return userService.getCartList(userService.findUserById(user_id));
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
     * @param user_id
     * @param book_id
     * @param number
     */
    @GetMapping(value = "saveUserCart")
    public void saveUserCart(Integer user_id,Integer book_id,Integer number)
    {
        userService.saveUserCart(user_id,book_id,number);
    }


}
