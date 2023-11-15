package com.example.solucionEjercicio.service;

import com.example.solucionEjercicio.DTO.LugarDto;
import com.example.solucionEjercicio.Modal.Lugar;
import com.example.solucionEjercicio.Repo.LugraRepo;
import error.RutaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Lugarservice {
    private final LugraRepo lugraRepo;

    public LugarDto findByIdddd(Long id){

       return lugraRepo.findById(id).map(LugarDto::of).orElseThrow(()-> new RutaNotFoundException(id));
    }
    public Lugar create(Lugar l){
        Lugar lugar = new Lugar();
        lugar.setNombre(l.getNombre());
        lugar.setUrl(l.getUrl());
        lugar.setLocalizacion(l.getLocalizacion());
        lugar.setDescripcion(l.getDescripcion());
        lugar.setTags(l.getTags());
        return lugraRepo.save(lugar);
    }

}
