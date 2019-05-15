package com.example.servlet.daoimpl;

import com.example.servlet.dao.UserDao;
import com.example.servlet.entity.User;
import com.example.servlet.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        userRepository.save(user);
    }
}
