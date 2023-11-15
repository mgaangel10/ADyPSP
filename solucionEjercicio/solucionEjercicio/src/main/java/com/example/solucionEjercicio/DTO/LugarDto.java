package com.example.solucionEjercicio.DTO;

import com.example.solucionEjercicio.Modal.Lugar;

public record LugarDto (String nombre,
                        String url,
                        String localizacion,
                        String descripcion,
                        String tag){
    public static LugarDto of(Lugar l){
        return new LugarDto(l.getNombre(),
                l.getUrl(),
                l.getLocalizacion(),
                l.getDescripcion(),
                l.getTags()
        );
    }

}
