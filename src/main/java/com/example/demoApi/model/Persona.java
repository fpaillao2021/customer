package com.example.demoApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "PERSONA") // Asegúrate que coincida con el nombre de tu tabla en Oracle
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "PERSONA_SEQ", allocationSize = 1)
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
    private String fechaCumpleanos;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El sexo es obligatorio")
    private Sexo sexo;
}