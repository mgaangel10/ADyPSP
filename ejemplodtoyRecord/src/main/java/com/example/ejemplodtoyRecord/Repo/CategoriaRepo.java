package com.example.ejemplodtoyRecord.Repo;

import com.example.ejemplodtoyRecord.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria,Long> {
}
