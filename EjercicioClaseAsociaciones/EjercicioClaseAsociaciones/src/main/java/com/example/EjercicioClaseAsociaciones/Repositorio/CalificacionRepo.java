package com.example.EjercicioClaseAsociaciones.Repositorio;

import com.example.EjercicioClaseAsociaciones.Model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepo extends JpaRepository<Calificacion,Long> {
}
