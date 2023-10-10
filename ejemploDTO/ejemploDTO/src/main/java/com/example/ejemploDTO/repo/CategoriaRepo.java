package com.example.ejemploDTO.repo;

import com.example.ejemploDTO.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria,Long> {
}
