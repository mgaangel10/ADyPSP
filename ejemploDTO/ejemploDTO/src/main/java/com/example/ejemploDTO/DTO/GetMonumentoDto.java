package com.example.ejemploDTO.DTO;

import com.example.ejemploDTO.Model.Monumento;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetMonumentoDto {

    private Long id;

    private String nombre,localizacion,urlfoto,nombreCategoria;

    public static GetMonumentoDto of(Monumento monumento){
        return GetMonumentoDto.builder()
                .id(monumento.getId())
                .nombre(monumento.getNombre())
                .localizacion(monumento.getLocaclizacion())
                .urlfoto(monumento.getUrl())
                .nombreCategoria(monumento.getCategoria()!=null?monumento.getNombre():"sin categoria")
                .build();
    }
}
