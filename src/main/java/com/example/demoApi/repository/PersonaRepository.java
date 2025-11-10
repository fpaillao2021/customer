package com.example.demoApi.repository;

import com.example.demoApi.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Puedes añadir métodos personalizados aquí si los necesitas
    boolean existsByRut(String rut);
    boolean existsByEmail(String email);
}