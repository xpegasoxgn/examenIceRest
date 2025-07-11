package com.example.examenicei.service;

import com.example.examenicei.controller.dto.LoginRequest;
import com.example.examenicei.controller.dto.RegisterRequest;
import com.example.examenicei.dto.jwt.JwtLoginResponse;

public interface  AuthService {
    public JwtLoginResponse login(LoginRequest request);
    public void  register(RegisterRequest request) throws  Exception;
}
