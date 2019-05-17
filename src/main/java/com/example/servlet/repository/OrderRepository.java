package com.example.servlet.repository;

import com.example.servlet.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/16
 * @description:
 **/
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
