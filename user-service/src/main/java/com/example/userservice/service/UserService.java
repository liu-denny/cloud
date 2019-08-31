package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.List;

/**
 * @author yudong
 * @create 2019-08-28 20:54
 */
public interface UserService {
    List<User> findAll();

    User findOne(String id);

    User delete(String id,String username);

    User save(String username,String password);

    User updade(String id,String userName,String password);
}
