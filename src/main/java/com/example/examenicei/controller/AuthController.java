package com.example.examenicei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenicei.controller.dto.LoginRequest;
import com.example.examenicei.controller.dto.RegisterRequest;
import com.example.examenicei.dto.jwt.JwtLoginResponse;
import com.example.examenicei.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req,HttpServletRequest request) {
        String ip= request.getRemoteAddr();
        JwtLoginResponse response=authService.login(req);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/hello")
    public String getMethodName() {
        return "hola funciona el jwt";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        //TODO: process POST request
            
        try {
            authService.register(request);
            return  ResponseEntity.ok("Usuario registreado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("ERROR: "+ e.getMessage());

        }
    }

   
    
}
