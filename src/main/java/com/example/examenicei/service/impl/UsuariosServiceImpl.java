package com.example.examenicei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenicei.model.auth.Usuarios;
import com.example.examenicei.repository.UsuariosRepository;
import com.example.examenicei.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getUsuarios() throws Exception{
        return usuariosRepository.findAll();
    }
}
