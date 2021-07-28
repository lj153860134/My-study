package com.lingjian.controller;

import com.lingjian.entity.User;
import com.lingjian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @description: 用户的表现层
 * @author: Ling Jian
 * @date: 2020-03-23 10:28
 **/
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user=userRepository.getOne(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        User saved=userRepository.save(user);
        return saved;
    }
}
