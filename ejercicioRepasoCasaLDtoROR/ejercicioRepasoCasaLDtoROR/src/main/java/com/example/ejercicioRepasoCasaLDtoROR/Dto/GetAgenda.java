package com.example.ejercicioRepasoCasaLDtoROR.Dto;

import com.example.ejercicioRepasoCasaLDtoROR.Model.Agenda;
import com.example.ejercicioRepasoCasaLDtoROR.Model.Persona;

import java.util.List;

public record GetAgenda(Long id, String fechaCreacion, List<GetPersona> personas) {

    public  static GetAgenda of(Agenda agenda){
        return  new GetAgenda(
                agenda.getId(),
                agenda.getFechaCreacion(),
                agenda.getPersonas()
                        .stream()
                        .map(GetPersona::of)
                        .toList()
        );
    }




}
