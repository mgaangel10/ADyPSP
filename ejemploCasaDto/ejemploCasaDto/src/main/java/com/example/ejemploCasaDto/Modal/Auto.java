package com.example.ejemploCasaDto.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
    @Id
    @GeneratedValue
    private Long id;
    private Persona persona;
    private String matricula;
    private String marca;
    private String modelo;
}
