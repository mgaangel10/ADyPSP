package com.example.repasoExamen.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String tiempo;
    @ManyToMany
    private List<Monumento> monumentos;
    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

}
