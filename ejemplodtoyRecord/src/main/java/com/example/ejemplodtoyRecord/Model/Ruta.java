package com.example.ejemplodtoyRecord.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ruta {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    @OneToMany
    private List<Moumento> moumentos;
    private int tiempo;
    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;
}
