package com.example.ejercicioRepasoCasaLDtoROR.Model;

import com.example.ejercicioRepasoCasaLDtoROR.Dto.GetPersona;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Agenda {

    @Id
    @GeneratedValue
    private Long id;
    private String fechaCreacion;

    @OneToMany
    private List<Persona> personas;
}
