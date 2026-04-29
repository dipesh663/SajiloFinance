package com.expensetracker.sajilo_finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.sajilo_finance.apiResponse.ApiResponse;
import com.expensetracker.sajilo_finance.model.dto.AuthResponse;
import com.expensetracker.sajilo_finance.model.dto.LoginRequest;
import com.expensetracker.sajilo_finance.model.dto.UserDto;
import com.expensetracker.sajilo_finance.service.UserService;



@RestController
@RequestMapping("api/auth")

public class userController {
    
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDto userDto){
          userService.register(userDto);
          try {
              ApiResponse apiResponse = ApiResponse.builder().message("Successfully Created")
                                        .statusCode(HttpStatus.OK.value()).build();

              return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

          } catch (Exception e) {
            ApiResponse apiResponse = ApiResponse.builder().message("Failed")
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
          }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
           AuthResponse auth = userService.login(request);
        try {
          
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Login successful")
                    .statusCode(HttpStatus.OK.value())
                    .date(auth)
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception e) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Login failed: " + e.getMessage())
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
        }
    }
   
    
    
}
