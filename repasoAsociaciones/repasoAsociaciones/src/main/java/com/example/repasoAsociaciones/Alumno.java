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

    public void addToCurso(Curso curso){
        this.curso= curso;
        curso.getAlumnos().add(this);
    }

    public  void removeToCurso(Curso curso){
        this.curso=null;
        curso.getAlumnos().remove(this);
    }
}
