package com.example.repasoExamen.Dto;

import com.example.repasoExamen.Model.Categoria;

public record GetCategoriaDto (Long id, String nombre){

    public static GetCategoriaDto of(Categoria c){
        return new GetCategoriaDto(
                c.getId(),
                c.getNombre()
        );
    }
}
