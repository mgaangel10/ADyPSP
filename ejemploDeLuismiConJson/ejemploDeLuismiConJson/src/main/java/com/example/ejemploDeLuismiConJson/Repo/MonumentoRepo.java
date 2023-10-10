package com.example.ejemploDeLuismiConJson.Repo;

import com.example.ejemploDeLuismiConJson.Model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepo extends JpaRepository<Monumento,Long> {
}
