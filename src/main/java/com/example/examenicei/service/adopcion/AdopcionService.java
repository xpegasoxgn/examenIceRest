package com.example.examenicei.service.adopcion;
import com.example.examenicei.model.adopcion.Adopcion;

import java.util.List;

public interface AdopcionService {
    List<Adopcion> getAllAdopciones();
    Adopcion getAdopcionById(Long id);
    Adopcion storeAdopcion(Adopcion adopcion);
    Adopcion updateAdopcion(Long id, Adopcion adopcion);
    void eliminarAdopcion(Long id);
    void actualizarEstadoSolicitud(Long solicitudId, String nuevoEstado) throws Exception;
}