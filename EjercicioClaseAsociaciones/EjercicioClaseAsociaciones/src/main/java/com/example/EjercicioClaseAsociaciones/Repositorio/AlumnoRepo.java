package com.example.EjercicioClaseAsociaciones.Repositorio;

import com.example.EjercicioClaseAsociaciones.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepo extends JpaRepository<Alumno, Long> {
}
