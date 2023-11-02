package com.example.EjercicioClaseAsociaciones.Repositorio;

import com.example.EjercicioClaseAsociaciones.Model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepo extends JpaRepository<Examen,Long> {
}
