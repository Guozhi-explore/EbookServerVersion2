package com.example.servlet.repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/17
 * @description:
 **/
public class BalanceTargetInfoRepository {
    @PersistenceContext
    EntityManager entityManager;


}
