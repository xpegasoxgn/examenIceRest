package com.example.examenicei.repository.adopcion;
import com.example.examenicei.model.adopcion.Adopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {
    List<Adopcion> findByEstado(String estado);
    Optional<Adopcion> findByUsuarioIdAndEstado(Long usuarioId, String estado);
    boolean existsByUsuarioIdAndEstado(String estado, Long usuarioId);
}
