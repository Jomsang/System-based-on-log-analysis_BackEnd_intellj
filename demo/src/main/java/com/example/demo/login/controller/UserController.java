package com.example.demo.login.controller;

import com.example.demo.login.model.User;
import com.example.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public int login(@RequestBody Map<String, String> userInfo) {
        String id = userInfo.get("userId");
        String pw = userInfo.get("passWord");
        System.out.println("login user: " + id);
        System.out.println("login pw: " + pw);

        System.out.println("result login: " + userService.login(id,pw));

        return userService.login(id,pw);
    }

    @PostMapping("/newUser")
    public int newUser(@RequestBody Map<String, String> newUserInfo) {
        String newId = newUserInfo.get("userId");
        String newPw = newUserInfo.get("passWord");
        String newName = newUserInfo.get("userName");
        System.out.println("newUserInfo user: " + newId);
        System.out.println("newUserInfo pw: " + newPw);
        System.out.println("newUserInfo name: " + newName);

        User newUser = new User();
        newUser.setUserid(newId);
        newUser.setPassword(newPw);
        newUser.setUsername(newName);

        //중복된 계정이 있는지 확인 후 생성
        int checkDuplicate = userService.duplicateCheckUser(newId);
        if(checkDuplicate == 1){
            System.out.println("중복 들어옴");
            return 0;
        }

        return userService.newUser(newUser);
    }


}
