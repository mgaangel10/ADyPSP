package com.example.EjercicioClaseAsociaciones.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Examen {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "examen")
    List<ReferenteEvaluacion> referenteEvaluacions = new ArrayList<>();
    @OneToMany(mappedBy = "examen")
    List<Instrumento> instrumentos = new ArrayList<>();
}
