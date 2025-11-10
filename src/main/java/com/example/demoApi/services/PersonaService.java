package com.example.demoApi.services;

import com.example.demoApi.model.Persona;
import com.example.demoApi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Transactional
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsByRut(String rut) {
        return personaRepository.existsByRut(rut);
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return personaRepository.existsByEmail(email);
    }
}