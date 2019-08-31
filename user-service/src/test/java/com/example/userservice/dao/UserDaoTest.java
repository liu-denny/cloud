package com.example.userservice.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void delete() {
        Integer i = userDao.delete("user_2");
        System.out.println(i);

    }
}