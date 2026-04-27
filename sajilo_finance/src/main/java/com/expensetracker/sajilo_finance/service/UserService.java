package com.expensetracker.sajilo_finance.service;

import com.expensetracker.sajilo_finance.model.dto.AuthResponse;
import com.expensetracker.sajilo_finance.model.dto.LoginRequest;
import com.expensetracker.sajilo_finance.model.dto.UserDto;
import com.expensetracker.sajilo_finance.model.entity.User;

public interface UserService {
  User register(UserDto user_dto);

  AuthResponse login(LoginRequest request);
}
