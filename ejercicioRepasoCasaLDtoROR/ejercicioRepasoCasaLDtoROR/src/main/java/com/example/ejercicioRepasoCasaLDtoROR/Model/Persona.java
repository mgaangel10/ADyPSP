package com.example.ejercicioRepasoCasaLDtoROR.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Persona {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre,apellidos,email,numTel;

}
