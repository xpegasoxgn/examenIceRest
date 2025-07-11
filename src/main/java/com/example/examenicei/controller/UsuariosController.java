package com.example.examenicei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenicei.model.auth.Usuarios;
import com.example.examenicei.service.UsuariosService;

@RestController
@RequestMapping("/api_usuario")
public class UsuariosController {

    @Autowired
    private UsuariosService mascotaService;
    
    @GetMapping("/usuario")
    public ResponseEntity<List<Usuarios>> getUsuarios() {
        try {
            return ResponseEntity.ok(mascotaService.getUsuarios());
        } 
        catch (Exception e) {
            return null;
        }
    }
    
}
