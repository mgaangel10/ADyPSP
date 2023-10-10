package com.example.ejemploDTO.repo;

import com.example.ejemploDTO.Model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepo extends JpaRepository<Monumento,Long> {
}
