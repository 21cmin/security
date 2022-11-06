package com.example.security.jwt;


import lombok.Data;

@Data
public class UsernameAndPasswordAuthenticationRequest {
    private final String username;
    private final String password;
}
