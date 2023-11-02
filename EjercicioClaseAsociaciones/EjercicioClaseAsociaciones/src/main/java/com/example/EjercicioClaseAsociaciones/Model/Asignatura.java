package com.example.EjercicioClaseAsociaciones.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Asignatura {
    @Id
    @GeneratedValue
    private Long id;
    private int horas;
    private String nombre;
    private String descripcion;
    @ManyToOne
    Matricula matricula;
    @OneToMany(mappedBy = "asignatura")
    List<Instrumento> instrumentos = new ArrayList<>();
    @OneToMany(mappedBy = "asignatura")
    List<ReferenteEvaluacion> referenteEvaluacions = new ArrayList<>();
}
