package com.example.EjercicioClaseAsociaciones.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Instrumento {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime fecha;
    private String nombre;
    private String contenidos;
    @ManyToOne
    Asignatura asignatura;
    @OneToMany(mappedBy = "instrumento")
    List<Calificacion> calificacions = new ArrayList<>();
    @ManyToOne
    Examen examen;
}
