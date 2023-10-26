package com.example.repasoExamen.Model;

import com.example.repasoExamen.Json.RutaView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonIgnore
    private Long id;
    @JsonView({RutaView.RutaList.class, RutaView.Rutaedit.class})
    private String nombre;
    private String tiempo;
    @ManyToMany
    private List<Monumento> monumentos;
    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

}
