package com.example.ejercicioRepasoCasaLDtoROR.Dto;

import com.example.ejercicioRepasoCasaLDtoROR.Model.Persona;

public record GetPersona(Long id, String nombre, String apellido, String email, String numTel) {

    public static GetPersona of(Persona persona){
        return new GetPersona(
                persona.getId(),
                persona.getNombre(),
                persona.getApellidos(),
                persona.getEmail(),
                persona.getNumTel()
        );
    }

}
