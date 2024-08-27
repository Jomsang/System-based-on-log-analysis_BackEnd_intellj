package com.example.demo.login.controller;

import com.example.demo.login.model.UserJpa;
import com.example.demo.login.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


class LoginRequest {
    private String username;
    private String password;
    // getters and setters
}

@RestController
@RequestMapping("/usersJpa")
@CrossOrigin(origins = "http://localhost:3000")
public class UserJpaController {

    private final UserJpaService userJpaService;

    @Autowired
    public UserJpaController(UserJpaService userJpaService) {
        this.userJpaService = userJpaService;
    }

    @GetMapping("/test")
    public List<UserJpa> getAllUsers() {
        return userJpaService.getAllUsers();
    }

    @PostMapping("/login")
    public int login(@RequestBody Map<String, String> userInfo) {
        String id = userInfo.get("username");
        String pw = userInfo.get("password");
        System.out.println("LoginRequest user: " + id);
        System.out.println("LoginRequest pw: " + pw);

        System.out.println("result login: " + userJpaService.login(id,pw));

        return userJpaService.login(id,pw);
    }

}
