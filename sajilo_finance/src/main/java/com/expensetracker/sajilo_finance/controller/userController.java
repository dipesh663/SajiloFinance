package com.expensetracker.sajilo_finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.sajilo_finance.model.dto.UserDto;
import com.expensetracker.sajilo_finance.model.entity.User;
import com.expensetracker.sajilo_finance.service.UserService;



@RestController
@RequestMapping("api/auth")

public class userController {
    
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDto userDto){
        return  userService.register(userDto);
    }
   
    
    
}
