package com.example.demoApi.controllers;

import com.example.demoApi.model.Customer;
import com.example.demoApi.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllPersonas() {
        List<Customer> customer = customerService.findAll();
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getPersonaById(@PathVariable Long id) {
        Optional<Customer> persona = customerService.findById(id);
        return persona.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping

    public ResponseEntity<?> createPersona(@Valid @RequestBody Customer persona) {
        if (customerService.existsByRut(persona.getRut())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El RUT ya está registrado");
        }
        if (customerService.existsByEmail(persona.getEmail())) {
        }
        return ResponseEntity.ok(persona);
    }
}