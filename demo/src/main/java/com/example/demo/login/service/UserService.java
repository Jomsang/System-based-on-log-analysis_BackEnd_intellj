package com.example.demo.login.service;

import com.example.demo.login.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int login(String userid, String password);
    int newUser(User newUser);
    int duplicateCheckUser(String userid);
}
