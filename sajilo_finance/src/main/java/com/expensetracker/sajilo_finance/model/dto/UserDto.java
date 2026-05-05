package com.expensetracker.sajilo_finance.model.dto;


import com.expensetracker.sajilo_finance.model.entity.Role;

import lombok.Data;

@Data
public class UserDto {
  private Long id;
  private String name;
    private String email;
    private Role role;
    private String phoneNumber;
    private String password;
}
