package com.example.demoApi.controllers;

import com.example.demoApi.model.Persona;
import com.example.demoApi.services.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping

    public ResponseEntity<?> createPersona(@Valid @RequestBody Persona persona) {
        if (personaService.existsByRut(persona.getRut())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El RUT ya está registrado");
        }
        if (personaService.existsByEmail(persona.getEmail())) {
        }
        return ResponseEntity.ok(persona);
    }
}