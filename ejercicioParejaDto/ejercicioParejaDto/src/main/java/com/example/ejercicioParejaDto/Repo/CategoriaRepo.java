package com.example.ejercicioParejaDto.Repo;


import com.example.ejercicioParejaDto.Modal.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria,Long> {
}
