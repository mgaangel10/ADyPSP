package com.example.EjercicioClaseAsociaciones.Repositorio;

import com.example.EjercicioClaseAsociaciones.Model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepo extends JpaRepository<Asignatura,Long> {
}
