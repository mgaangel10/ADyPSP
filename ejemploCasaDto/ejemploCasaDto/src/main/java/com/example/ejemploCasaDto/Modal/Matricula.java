package com.example.ejemploCasaDto.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matricula implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nomrebPropietario;
    private String placa;
    private String marca;
    private String modelo;



}
