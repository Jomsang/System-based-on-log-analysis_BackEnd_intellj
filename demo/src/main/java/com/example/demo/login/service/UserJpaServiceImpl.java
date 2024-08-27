package com.example.demo.login.service;

import com.example.demo.login.model.UserJpa;
import com.example.demo.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJpaServiceImpl implements UserJpaService {

    private final UserRepository userRepository;

    @Autowired
    public UserJpaServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserJpa> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public int login(String id, String password) {
        return userRepository.login(id, password);
    }

}
