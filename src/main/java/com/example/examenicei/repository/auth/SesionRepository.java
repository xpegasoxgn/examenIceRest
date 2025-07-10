package com.example.examenicei.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenicei.model.auth.Sesion;

@Repository
public interface  SesionRepository extends JpaRepository<Sesion, Long>{
    Optional <Sesion> findByUsuarioUsername(String Username);
} 


