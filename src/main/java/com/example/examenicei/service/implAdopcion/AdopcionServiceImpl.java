package com.example.examenicei.service.implAdopcion;

import com.example.examenicei.model.Mascota;
import com.example.examenicei.model.adopcion.Adopcion;
import com.example.examenicei.repository.MascotaRepository;
import com.example.examenicei.repository.adopcion.AdopcionRepository;
import com.example.examenicei.service.adopcion.AdopcionService;
import jakarta.transaction.Transactional;
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
    @Autowired
    private MascotaRepository mascotaRepository;

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

    @Override
    @Transactional
    public void actualizarEstadoSolicitud(Long solicitudId, String nuevoEstado) throws Exception {
        Adopcion solicitud = adopcionRepository.findById(solicitudId)
                .orElseThrow(() -> new Exception("Solicitud no encontrada"));

        solicitud.setEstado(nuevoEstado);

        if ("APROBADA".equalsIgnoreCase(nuevoEstado)) {
            Mascota mascota = solicitud.getMascota();
            mascota.setEstado("ADOPTADO");
            mascotaRepository.save(mascota);
        }

        adopcionRepository.save(solicitud);
    }
}
