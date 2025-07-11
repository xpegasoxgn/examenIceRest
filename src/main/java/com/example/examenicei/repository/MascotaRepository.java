package com.example.examenicei.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.examenicei.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    Optional <Mascota> findById(Long id);
    
    @Query("SELECT m FROM Mascota m WHERE m.estado = 'DISPONIBLE'")
    List<Mascota> findMascotasDisponibles();
}
