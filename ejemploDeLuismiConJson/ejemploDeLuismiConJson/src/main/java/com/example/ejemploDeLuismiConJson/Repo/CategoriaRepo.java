package com.example.ejemploDeLuismiConJson.Repo;

import com.example.ejemploDeLuismiConJson.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria,Long> {
}
