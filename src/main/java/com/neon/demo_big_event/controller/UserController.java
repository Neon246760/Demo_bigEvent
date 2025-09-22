package com.neon.demo_big_event.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.neon.demo_big_event.common.Response;
import com.neon.demo_big_event.entity.User;
import com.neon.demo_big_event.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response<User> register(@RequestBody User u) {
        // 查询用户
        if (userService.findByUserName(u).isPresent()) {  // 用户名已存在
            return new Response<User>().error("用户名已存在");
        }
    
        // 用户名没有占用，注册
        User createdUser = userService.createUser(u);
        return new Response<User>().success(createdUser);
    }
}
