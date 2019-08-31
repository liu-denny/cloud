package com.example.userservice.service.impl;

import com.example.userservice.dao.UserDao;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.untils.ResponseCode;
import com.example.userservice.untils.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author yudong
 * @create 2019-08-28 20:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(String id) {
        return userDao.findOne(id);
    }

    @Override
    public User delete(String id,String username) {
        User user = userDao.findOne(id);
        if(user == null || username.equals(user.getUsername())){
            throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
        }
        try{
            Integer i = userDao.delete(username);
            if(!i.equals(1)){
                throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
            }
        }catch (Exception e){
            throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
        }
        return user;
    }

    @Override
    public User save(String username, String password) {
        String id = UUID.randomUUID().toString();
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        try{
            Integer i = userDao.save(id,username,password);
            if(!i.equals(1)){
                throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
            }
        }catch (Exception e){
            throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
        }
        return user;
    }

    @Override
    public User updade(String id,String userName, String password) {
        User user = userDao.findOne(id);
        if(user == null){
            throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
        }
        try{
            Integer i = userDao.update(id,userName,password);
            if(!i.equals(1)){
                throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
            }
        }catch (Exception e){
            throw new ServiceException(ResponseCode.BUSINESS,"操作失败");
        }
        return user;
    }
}
