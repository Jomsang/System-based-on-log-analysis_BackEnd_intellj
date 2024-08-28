package com.example.demo.service;

import com.example.demo.model.UserJpa;

import java.util.List;

public interface UserJpaService {
    List<UserJpa> getAllUsers();
    int login(String userid, String password);
    int newUser(UserJpa newUser);
    int duplicateCheckUser(String userid);
}
