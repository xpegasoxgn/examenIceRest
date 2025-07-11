package com.example.examenicei.service;

import java.util.List;

import com.example.examenicei.model.auth.Usuarios;

public interface UsuariosService {
    public List<Usuarios> getUsuarios() throws Exception;
}
