package com.example.repasoAsociaciones;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Curso {
    @Id
    @GeneratedValue
    private Long id;
    private String nombreCurso;


    @OneToMany(mappedBy = "curso")
    List<Alumno> alumnos;

}
