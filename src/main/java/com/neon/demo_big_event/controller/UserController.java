package com.neon.demo_big_event.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.neon.demo_big_event.common.JwtUtil;
import com.neon.demo_big_event.common.Md5Util;
import com.neon.demo_big_event.common.Response;
import com.neon.demo_big_event.entity.User;
import com.neon.demo_big_event.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Valid
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response<User> register(@RequestBody User u) {
        // 查询用户
        if (userService.findByUserName(u.getUsername()) == null) {  // 用户名已存在
            // 用户名没有占用，注册
            User createdUser = userService.createUser(u);
            return Response.success(createdUser);
        }

        return Response.error("用户名已存在");
    }

    @PostMapping("/login")
    public Response<String> login(@RequestBody User u) {
        User loginUser = userService.findByUserName(u.getUsername());
        if (loginUser == null) {
            return Response.error("找不到该用户");
        }

        if (Md5Util.getMD5String(u.getPassword()).equals(loginUser.getPassword())) {
            // 登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Response.success(token);
        }

        return Response.error("密码错误！");
    }

    @GetMapping("/userInfo")
    public Response<User> getUserInfo(@RequestHeader("Authorization") String token) {
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        return Response.success(userService.findByUserName(username));
    }
}
