package com.expensetracker.sajilo_finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensetracker.sajilo_finance.model.dto.AuthResponse;
import com.expensetracker.sajilo_finance.model.dto.LoginRequest;
import com.expensetracker.sajilo_finance.model.dto.UserDto;
import com.expensetracker.sajilo_finance.model.entity.User;
import com.expensetracker.sajilo_finance.repository.UserRepository;
import com.expensetracker.sajilo_finance.security.JwtService;
import com.expensetracker.sajilo_finance.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService  jwtService;

    @Override
    public User register(UserDto user_dto) {
        User user = User.builder().email(user_dto.getEmail()).name(user_dto.getName()).role(user_dto.getRole()).phoneNumber(user_dto.getPhoneNumber()).password(passwordEncoder.encode(user_dto.getPassword())).build();
        userRepository.save(user);
        return user;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .role(user.getRole().name())
                .userId(user.getId())
                .build();
    }

}
