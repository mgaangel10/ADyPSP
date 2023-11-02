package com.example.EjercicioClaseAsociaciones.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Calificacion {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    Instrumento instrumento;

    @ManyToOne
    ReferenteEvaluacion referenteEvaluacion;

    @ManyToOne
    Alumno alumno;


}
