package com.example.demo.login.service;

import com.example.demo.login.model.UserJpa;

import java.util.List;

public interface UserJpaService {
    List<UserJpa> getAllUsers();
    int login(String userid, String password);
}