package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.untils.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yudong
 * @create 2019-08-28 21:00
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/find")
    public ResultMessage findAllUser() {
        return new ResultMessage().putParam("resource",userService.findAll());
    }

    @GetMapping(value = "/findOne")
    public ResultMessage findOneUser(@RequestParam("id") String id) {
        return new ResultMessage().putParam("resource",userService.findOne(id));

    }

    @PostMapping(value = "/save")
    public ResultMessage save(
            @RequestParam("userName") String userName,
            @RequestParam("passWord") String passWord) {
        return new ResultMessage().putParam("resource",userService.save(userName,passWord));

    }

    @GetMapping(value = "/delete")
    public ResultMessage delete(@RequestParam("id") String id,
                                @RequestParam("userName") String userName ){
        return new ResultMessage().putParam("resource",userService.delete(id,userName));
    }

    @PostMapping(value = "/update")
    public ResultMessage delete(
            @RequestParam("id") String id,
            @RequestParam("userName") String userName,
            @RequestParam("passWord") String passWord
    ){
        return new ResultMessage().putParam("resource",userService.updade(id,userName,passWord));
    }
}
