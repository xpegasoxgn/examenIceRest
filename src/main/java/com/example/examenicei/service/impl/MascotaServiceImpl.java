package com.example.examenicei.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.examenicei.model.Mascota;
import com.example.examenicei.repository.MascotaRepository;
import com.example.examenicei.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotas() throws Exception{
        return mascotaRepository.findAll();
    }

    @Override
    public List<Mascota> getMascotasDisponibles() throws Exception {
        return mascotaRepository.findMascotasDisponibles();
    }

    @Override
    public Mascota addMascota(Mascota mascota) throws Exception{
        return mascotaRepository.save(mascota);
    }

    @Override
    public String editMascota(Long id, Mascota mascota) throws Exception{
        Optional<Mascota> mascotaExistente = mascotaRepository.findById(id);
        if (mascotaExistente.isEmpty()) {
            throw new Exception("Mascota no encontrada con id: " + id);
        }
        Mascota mascotaToUpdate = mascotaExistente.get();

        mascotaToUpdate.setNombre(mascota.getNombre());

        mascotaRepository.save(mascotaToUpdate);
        return "Mascota actualizada correctamente";
    }

    @Override
    public String deleteMascota(Long id) throws Exception{
        Optional<Mascota> mascotaExistente = mascotaRepository.findById(id);
        if (mascotaExistente.isEmpty()) {
            throw new Exception("Mascota no encontrado con id: " + id);
        }
        mascotaRepository.deleteById(id);
        return "Mascota eliminado correctamente";
    }
        
    @Override
    public String subirFotoMascota(Long mascotaId, MultipartFile file) throws Exception {
        return null;
    }
    
}
