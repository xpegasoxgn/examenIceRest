package com.example.examenicei.controller.Adopcion;

import com.example.examenicei.model.adopcion.Adopcion;
import com.example.examenicei.service.adopcion.AdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopcion")
public class AdopcionController {

    @Autowired
    private AdopcionService adopcionService;

    @GetMapping
    public List<Adopcion> getAll() {
        return adopcionService.getAllAdopciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adopcion> getById(@PathVariable Long id) {
        Adopcion adopcion = adopcionService.getAdopcionById(id);
        if (adopcion != null) {
            return ResponseEntity.ok(adopcion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Adopcion> store(@RequestBody Adopcion adopcion) {
        Adopcion nuevaAdopcion = adopcionService.storeAdopcion(adopcion);
        return ResponseEntity.status(201).body(nuevaAdopcion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Adopcion> update(@PathVariable Long id, @RequestBody Adopcion adopcion) {
        Adopcion actualizada = adopcionService.updateAdopcion(id, adopcion);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        adopcionService.eliminarAdopcion(id);
        return ResponseEntity.noContent().build();
    }

}
