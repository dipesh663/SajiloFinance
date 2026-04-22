package com.expensetracker.sajilo_finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.sajilo_finance.model.dto.UserDto;
import com.expensetracker.sajilo_finance.model.entity.User;
import com.expensetracker.sajilo_finance.repository.UserRepository;
import com.expensetracker.sajilo_finance.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserDto user_dto) {
        User user = User.builder().email(user_dto.getEmail()).name(user_dto.getName()).password(user_dto.getPassword()).build();
        userRepository.save(user);
        return user;
    }

   

}
