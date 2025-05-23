//package com.example.studentmarkingsystem.controller;
//
//import com.example.studentmarkingsystem.entity.Users;
//import com.example.studentmarkingsystem.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService service;
//
//    @PostMapping("/register")
//    public Users register(@RequestBody Users user){
//        return service.register(user);
//        //return user;
//    }
//
//    @PostMapping("/login")
//    public String login (@RequestBody Users user){
//        return service.verify(user);
//    }
//}
