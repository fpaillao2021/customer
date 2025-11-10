package com.example.demoApi.repository;

import com.example.demoApi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Puedes añadir métodos personalizados aquí si los necesitas
    boolean existsByRut(String rut);
    boolean existsByEmail(String email);
}