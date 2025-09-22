package com.neon.demo_big_event.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neon.demo_big_event.common.Md5Util;
import com.neon.demo_big_event.entity.User;
import com.neon.demo_big_event.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUserName(User u) {
        return userRepository.findByUsername(u.getUsername());
    }

    public User createUser(User u) {
        u.setPassword(Md5Util.getMD5String(u.getPassword()));
        return userRepository.save(u);
    }
}
