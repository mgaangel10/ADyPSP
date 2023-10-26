package com.example.repasoAsociaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    private Long id;
    private String nombreCurso;

    @OneToMany(mappedBy = "curso")
    List<Alumno> alumnos;

}
