package com.example.ejemploDeLuismiConJson.DTO;

import com.example.ejemploDeLuismiConJson.Model.Categoria;
import com.example.ejemploDeLuismiConJson.Model.Monumento;

public record GetMonumentoDto(Long id, String nombre, String  Localizacion, String pais, String ciudad, String codigoDelPais,
                              Categoria categoria) {
    public static GetMonumentoDto of(Monumento m){
        return new GetMonumentoDto(
                m.getId(),
                m.getNombreMon(),
                m.getLocalizacion(),
                m.getPais(),
                m.getCodigoDelPais(),
                m.getCiudad(),
                m.getCategoria()
        );
    }
}
