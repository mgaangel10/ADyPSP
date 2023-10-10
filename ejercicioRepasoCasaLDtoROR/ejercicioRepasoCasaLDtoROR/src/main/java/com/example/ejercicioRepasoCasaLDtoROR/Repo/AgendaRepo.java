package com.example.ejercicioRepasoCasaLDtoROR.Repo;

import com.example.ejercicioRepasoCasaLDtoROR.Model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepo extends JpaRepository<Agenda,Long>{
}
