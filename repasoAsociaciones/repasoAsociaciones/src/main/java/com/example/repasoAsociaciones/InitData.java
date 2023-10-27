package com.example.repasoAsociaciones;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {
private final Alumnorepo alumnorepo;
private final CursoRepo cursoRepo;

    @PostConstruct
    public void init(){

        Curso curso = Curso.builder()
                .id(1L)
                .nombreCurso("base de datos")
                .build();
        cursoRepo.save(curso);


        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("angel")
                .edad(20)
                .build();
        alumno.addToCurso(curso);
        alumnorepo.save(alumno);

        Alumno alumno1 = Alumno.builder()
                .id(2L)
                .nombre("angel2")
                .edad(20)
                .build();
        alumnorepo.save(alumno1);
         curso.setAlumnos(List.of(alumno,alumno1));
         cursoRepo.save(curso);
         alumno.setCurso(curso);
         alumnorepo.save(alumno);
         alumno1.setCurso(curso);
         alumnorepo.save(alumno1);


    }



}
