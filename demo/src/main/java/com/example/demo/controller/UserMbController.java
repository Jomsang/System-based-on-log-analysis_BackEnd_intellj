package com.example.demo.controller;

import com.example.demo.model.UserMb;
import com.example.demo.service.UserMbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserMbController {

    private final UserMbService userMbService;

    @Autowired
    public UserMbController(UserMbService userMbService) {
        this.userMbService = userMbService;
    }

    @GetMapping
    public List<UserMb> getAllUsers() {
        return userMbService.getAllUsers();
    }
}
