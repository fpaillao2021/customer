package com.example.demoApi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "CUSTOMER") // Asegúrate que coincida con el nombre de tu tabla en Oracle
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El RUT es obligatorio")
    @Size(max = 20)
    private String rut;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 100)
    private String direccion;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    @Size(max = 100)
    private String email;

    @NotBlank(message = "La comuna es obligatoria")
    @Size(max = 100)
    private String comuna;

    @NotBlank(message = "La región es obligatoria")
    @Size(max = 100)
    private String region;

    @NotBlank(message = "La fecha de cumpleaños es obligatoria")
    @Size(max = 50)
    private String fechacumpleanos;

    @NotBlank(message = "El Sexo es obligatorio")
    @Size(max = 20)
    private String sexo;
}