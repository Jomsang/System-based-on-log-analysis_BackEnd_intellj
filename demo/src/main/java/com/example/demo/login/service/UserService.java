package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int login(String userid, String password);
    int newUser(User newUser);
    int duplicateCheckUser(String userid);
}
