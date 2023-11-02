package com.example.EjercicioClaseAsociaciones;

import com.example.EjercicioClaseAsociaciones.Model.*;
import com.example.EjercicioClaseAsociaciones.Repositorio.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final AlumnoRepo alumnoRepo;
    private final AsignaturaRepo asignaturaRepo;
    private final InstrumentoRepo instrumentoRepo;
    private final CalificacionRepo calificacionRepo;
    private final ReferenteEvaluacionRepo referenteEvaluacionRepo;
    private final ExamenRepo examenRepo;

    @PostConstruct
    public void Init(){
        Asignatura asignatura = Asignatura.builder()
                .id(1L)
                .nombre("base de datos")
                .horas(10)
                .descripcion("como aprender hacer consultas")
                .build();
        asignaturaRepo.save(asignatura);
        Alumno alumno = Alumno.builder()
                .id(1L)
                .nombre("angel")
                .apellidos("perez alvarez")
                .email("angel@gmail.com")
                .numTelefono(1234)
                .fechaNacimiento(LocalDateTime.now())
                .build();

        alumnoRepo.save(alumno);

        Matricula matricula = Matricula.builder()
                .id(1L)
                .alumnos(List.of(alumno))
                .asignaturas(List.of(asignatura))
                .build();

        Instrumento instrumento = Instrumento.builder()
                .id(1L)
                .fecha(LocalDateTime.now())
                .nombre("nombre")
                .contenidos("muchos contenidos")
                .asignatura(asignatura)

                .build();
        instrumentoRepo.save(instrumento);
        ReferenteEvaluacion referenteEvaluacion = ReferenteEvaluacion.builder()
                .id(1L)
                .descripcion("integra correctamente el codigo de implementacion")
                .asignatura(asignatura)
                //falta
                .build();
        referenteEvaluacionRepo.save(referenteEvaluacion);
        Examen examen = Examen.builder()
                .id(2L)
                .instrumentos(List.of(instrumento))
                .referenteEvaluacions(List.of(referenteEvaluacion))
                .build();
        examenRepo.save(examen);
        Calificacion calificacion = Calificacion.builder()
                .id(1L)
                .instrumento(instrumento)
                .alumno(alumno)
                .referenteEvaluacion(referenteEvaluacion)
                .build();
        calificacionRepo.save(calificacion);
        instrumento.setExamen(examen);
        instrumento.setCalificacions(List.of(calificacion));
        instrumentoRepo.save(instrumento);
        referenteEvaluacion.setCalificacions(List.of(calificacion));
        referenteEvaluacion.setExamen(examen);
        referenteEvaluacionRepo.save(referenteEvaluacion);


    }
}
