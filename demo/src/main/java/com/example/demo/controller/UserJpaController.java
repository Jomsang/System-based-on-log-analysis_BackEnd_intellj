package com.example.demo.controller;

import com.example.demo.model.UserJpa;
import com.example.demo.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
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
        String id = userInfo.get("userId");
        String pw = userInfo.get("passWord");
        System.out.println("login user: " + id);
        System.out.println("login pw: " + pw);

        System.out.println("result login: " + userJpaService.login(id,pw));

        return userJpaService.login(id,pw);
    }

    @PostMapping("/newUser")
    public int newUser(@RequestBody Map<String, String> newUserInfo) {
        String newId = newUserInfo.get("userId");
        String newPw = newUserInfo.get("passWord");
        String newName = newUserInfo.get("userName");
        System.out.println("newUserInfo user: " + newId);
        System.out.println("newUserInfo pw: " + newPw);
        System.out.println("newUserInfo name: " + newName);

        UserJpa newUser = new UserJpa();
        newUser.setUserid(newId);
        newUser.setPassword(newPw);
        newUser.setUsername(newName);

        //중복된 계정이 있는지 확인 후 생성
        int checkDuplicate = userJpaService.duplicateCheckUser(newId);
        if(checkDuplicate == 1){
            System.out.println("중복 들어옴");
            return 0;
        }

        return userJpaService.newUser(newUser);
    }


}
