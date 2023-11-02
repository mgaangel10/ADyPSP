package com.example.EjercicioClaseAsociaciones.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReferenteEvaluacion {
    @Id
    @GeneratedValue
    private Long id;
    private String descripcion;
    @OneToMany(mappedBy = "referenteEvaluacion")
    List<Calificacion> calificacions = new ArrayList<>();
    @ManyToOne
    Examen examen;
    @ManyToOne
    Asignatura asignatura;
}
