package com.example.EjercicioClaseAsociaciones.Repositorio;

import com.example.EjercicioClaseAsociaciones.Model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentoRepo extends JpaRepository<Instrumento,Long> {
}
