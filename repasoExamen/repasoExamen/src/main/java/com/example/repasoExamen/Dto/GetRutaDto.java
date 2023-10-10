package com.example.repasoExamen.Dto;

import com.example.repasoExamen.Model.Dificultad;
import com.example.repasoExamen.Model.Monumento;
import com.example.repasoExamen.Model.Ruta;

import java.util.List;

public record GetRutaDto(Long id, String nombre, List<GetMonumentoDto> monumentos, String dificultad) {
    public static GetRutaDto of(Ruta r){
        return new GetRutaDto(
                r.getId(),
                r.getNombre(),
        r.getMonumentos().stream()
                        .map(GetMonumentoDto::of)
                                .toList(),
        r.getDificultad().name()
                );
    }

}
