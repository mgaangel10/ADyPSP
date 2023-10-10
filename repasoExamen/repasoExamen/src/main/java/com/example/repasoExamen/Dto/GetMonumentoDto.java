package com.example.repasoExamen.Dto;

import com.example.repasoExamen.Model.Monumento;

import java.util.List;

public record GetMonumentoDto(Long id,
                              String nombre,
                              String codigoPais,
                              String direccion,
                              String localidad,
                              String localizacion,
                              List<String>imagenes,
                              String categoria) {

    public static GetMonumentoDto of (Monumento m){
        return new GetMonumentoDto(
                m.getId(),
                m.getNombre(),
                m.getCodigoPais(),
                m.getDireccion(),
                m.getLocalidad(),
                m.getLocalizacion(),
                m.getImagenes(),
                m.getCategoria().getNombre()


        );
    }
}
