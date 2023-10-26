package com.example.repasoAsociaciones;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Alumno {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private int edad;
    @ManyToOne
    Curso curso;
}
