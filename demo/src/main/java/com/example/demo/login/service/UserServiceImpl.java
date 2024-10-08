package com.example.demo.login.service;

import com.example.demo.login.model.User;
import com.example.demo.login.repository.UserRepository;
import com.example.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public int login(String id, String password) {
        return userRepository.login(id, password);
    }

    @Override
    public int duplicateCheckUser(String id) {
        return userRepository.duplicateCheckUser(id);
    }

    @Override
    public int newUser(User user) {
        try {
            userRepository.save(user);
            return 1;  // 저장된 유저가 null이 아니면 성공(1), 아니면 실패(0)
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // 예외 발생 시 실패(0) 반환
        }
    }
}
