package com.example.examenicei.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenicei.model.auth.Rol;

@Repository
public interface  RolRepository extends JpaRepository<Rol, Long>{
    Optional <Rol>  findByNombre (String nombre);
} 

