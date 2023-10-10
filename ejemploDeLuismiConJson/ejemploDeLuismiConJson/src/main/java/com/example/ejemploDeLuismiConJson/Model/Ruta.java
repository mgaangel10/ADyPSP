package com.example.ejemploDeLuismiConJson.Model;

import com.example.ejemploDeLuismiConJson.Json.RutaJson;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
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
public class Ruta {
    @Id
    @GeneratedValue
    @JsonView(RutaJson.RutaList.class)
    private Long id;
    @JsonView({RutaJson.RutaList.class, RutaJson.RutaDetails.class, RutaJson.RutaEdit.class})
    private String nombre;
    @JsonView({RutaJson.RutaList.class, RutaJson.RutaDetails.class, RutaJson.RutaEdit.class})
    private String tiempo;
    @Enumerated(EnumType.STRING)
    @JsonView({RutaJson.RutaList.class, RutaJson.RutaDetails.class, RutaJson.RutaEdit.class})
    private Dificultad dificultad;

    @ManyToMany
    @JsonView({RutaJson.RutaList.class })
    private List<Monumento> monumentos;

}
