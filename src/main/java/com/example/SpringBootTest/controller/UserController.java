package com.example.SpringBootTest.controller;

import com.example.SpringBootTest.model.User;
import com.example.SpringBootTest.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDAO userDAO;
    @GetMapping("/user/get")
    public List<User> getAllTheUser()
    {
        return userDAO.getAllUser();
    }
    @PostMapping("/user/post")
    public User save(@RequestBody User user)
    {
        return userDAO.saveUser(user);
    }

}
