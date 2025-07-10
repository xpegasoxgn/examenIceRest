package com.example.examenicei.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.examenicei.model.Mascota;

public interface MascotaService {

    public List<Mascota> getMascotas() throws Exception;

    public Mascota addMascota(Mascota paciente) throws Exception;

    public String editMascota(Long id, Mascota paciente) throws Exception;

    public String deleteMascota(Long id) throws Exception;

    public String subirFotoMascota(Long pacienteId, MultipartFile file) throws Exception;
    
}
