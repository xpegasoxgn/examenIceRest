package com.example.examenicei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenicei.model.Mascota;
import com.example.examenicei.service.MascotaService;

@RestController
@RequestMapping("/api_mascota")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;
    
    @GetMapping("/mascota")
    public ResponseEntity<List<Mascota>> getMascotas() {
        try {
            return ResponseEntity.ok(mascotaService.getMascotas());
        } 
        catch (Exception e) {
            return null;
        }
    }
    
    @GetMapping("/mascota_disponible")
    public ResponseEntity<List<Mascota>> getMascotasDisponibles() {
        try {
            return ResponseEntity.ok(mascotaService.getMascotasDisponibles());
        } 
        catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/mascota")
    public ResponseEntity<Mascota> addMascota(@RequestBody Mascota mascota) {
        try {
            return ResponseEntity.ok(mascotaService.addMascota(mascota));
        } 
        catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/mascota/{id}")
    public ResponseEntity<String> editMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        try {
            return ResponseEntity.ok(mascotaService.editMascota( id, mascota));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/mascota/{id}")
    public ResponseEntity<String> deleteMascota(@PathVariable Long id) {
        try {
            mascotaService.deleteMascota(id);
            return ResponseEntity.ok("Mascota eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }        
}
