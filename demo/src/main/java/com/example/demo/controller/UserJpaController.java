package com.example.demo.controller;

import com.example.demo.model.UserJpa;
import com.example.demo.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usersJpa")
public class UserJpaController {

    private final UserJpaService userJpaService;

    @Autowired
    public UserJpaController(UserJpaService userJpaService) {
        this.userJpaService = userJpaService;
    }

    @GetMapping
    public List<UserJpa> getAllUsers() {
        return userJpaService.getAllUsers();
    }
}
