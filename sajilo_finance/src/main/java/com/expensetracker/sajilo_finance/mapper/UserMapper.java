package com.expensetracker.sajilo_finance.mapper;

import org.springframework.stereotype.Component;

import com.expensetracker.sajilo_finance.model.dto.CreateUserRequest;
import com.expensetracker.sajilo_finance.model.dto.UserDto;
import com.expensetracker.sajilo_finance.model.entity.User;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User toEntity(CreateUserRequest request){
        User user = new User();
         user.setName(request.getName());
        user.setEmail(request.getEmail());
        return user;
    }

}
