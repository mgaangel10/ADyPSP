package com.example.ejemploDeLuismiConJson.DTO;

import com.example.ejemploDeLuismiConJson.Model.Categoria;

public record GetCategoriaDto(Long id, String nombre) {
    public static GetCategoriaDto of (Categoria c){
        return new GetCategoriaDto(
                c.getId(),
                c.getNombre()
        );
    }
}
