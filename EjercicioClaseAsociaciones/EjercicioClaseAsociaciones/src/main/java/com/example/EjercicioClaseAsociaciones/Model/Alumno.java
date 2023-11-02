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
public class Alumno {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private int numTelefono;
    private LocalDateTime fechaNacimiento;
    @ManyToOne
    Matricula matricula;
    @OneToMany(mappedBy = "alumno")
    List<Calificacion> calificacions = new ArrayList<>();


}
