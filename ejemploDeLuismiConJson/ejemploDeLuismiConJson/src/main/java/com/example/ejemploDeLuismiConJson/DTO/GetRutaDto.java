package com.example.ejemploDeLuismiConJson.DTO;

import com.example.ejemploDeLuismiConJson.Model.Dificultad;
import com.example.ejemploDeLuismiConJson.Model.Monumento;
import com.example.ejemploDeLuismiConJson.Model.Ruta;

import java.util.List;

public record GetRutaDto(Long id, String nombre, String tiempo, String dificultad, List<GetMonumentoDto> monumentos) {

    public static GetRutaDto of(Ruta r){
        return new GetRutaDto(
                r.getId(),
                r.getNombre(),

                r.getTiempo(),
                r.getDificultad().name(),
                r.getMonumentos()
                        .stream()
                        .map(GetMonumentoDto::of)
                        .toList()
        );
    }

}
