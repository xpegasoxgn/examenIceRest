package com.example.examenicei.service.implAdopcion;

import com.example.examenicei.model.adopcion.Adopcion;
import com.example.examenicei.repository.adopcion.AdopcionRepository;
import com.example.examenicei.service.adopcion.AdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.examenicei.service.adopcion.AdopcionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdopcionServiceImpl implements AdopcionService {

    @Autowired
    private AdopcionRepository adopcionRepository;

    @Override
    public List<Adopcion> getAllAdopciones() {
        return adopcionRepository.findAll();
    }

    @Override
    public Adopcion getAdopcionById(Long id) {
        return adopcionRepository.findById(id).orElse(null);
    }

    @Override
    public Adopcion storeAdopcion(Adopcion adopcion) {
        adopcion.setEstado("PENDIENTE");
        adopcion.setFechaSolicitud(LocalDateTime.now());
        return adopcionRepository.save(adopcion);
    }

    @Override
    public Adopcion updateAdopcion(Long id, Adopcion adopcion) {
        Optional<Adopcion> existente = adopcionRepository.findById(id);

        if (existente.isPresent()) {
            Adopcion adopcionExistente = existente.get();

            // Solo permitimos cambiar el estado y la fecha de resolución
            adopcionExistente.setEstado(adopcion.getEstado());

            if (adopcion.getEstado().equalsIgnoreCase("APROBADA") ||
                    adopcion.getEstado().equalsIgnoreCase("RECHAZADA")) {
                adopcionExistente.setFechaResolucion(LocalDateTime.now());
            }

            return adopcionRepository.save(adopcionExistente);
        }

        return null;
    }

    @Override
    public void eliminarAdopcion(Long id) {
        adopcionRepository.deleteById(id);
    }
}
