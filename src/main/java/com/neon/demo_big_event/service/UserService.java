package com.neon.demo_big_event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neon.demo_big_event.common.Md5Util;
import com.neon.demo_big_event.entity.User;
import com.neon.demo_big_event.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User u) {
        int passwordLength = u.getPassword().length();
        if (passwordLength > 16 || passwordLength < 5) {
            throw new IllegalArgumentException("密码必须在5-16位之间");
        }
        u.setPassword(Md5Util.getMD5String(u.getPassword()));
        // save方法会根据实体类的主键(通常是@Id注解标记的字段)来决定是执行插入还是更新操作
        // 如果主键为null则插入新记录,如果主键已存在则更新该记录
        return userRepository.save(u);
    }
}
