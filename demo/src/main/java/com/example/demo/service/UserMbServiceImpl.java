package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserMb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMbServiceImpl implements UserMbService {

    private final UserMapper userMapper;

    @Autowired
    public UserMbServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserMb> getAllUsers() {
        return userMapper.findAll();
    }
}
