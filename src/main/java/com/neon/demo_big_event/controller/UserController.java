package com.neon.demo_big_event.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<Response<User>> register(@RequestBody User u) {
        // 查询用户
        if (userService.findByUserName(u).isPresent()) {  // 用户名已存在
            Response<User> err = new Response<User>(LocalDateTime.now(), -1, "用户名已被占用", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err);  // 409 Conflict : 资源冲突
        }
    
        // 用户名没有占用，注册
        User createdUser = userService.createUser(u);
        Response<User> ok = new Response<User>(LocalDateTime.now(), 1, "用户创建成功！", createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(ok);  // 201 Created : 创建成功
    }
}
