package com.expensetracker.sajilo_finance.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private String accessToken;

    private String refreshToken;

    private String role;
    
    private Long userId;

    @java.lang.SuppressWarnings(value = "all")
    @lombok.Generated
    public static class AuthResponseBuilder {

        public Object id(Long id) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
