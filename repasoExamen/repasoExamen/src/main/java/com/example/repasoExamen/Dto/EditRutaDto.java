package com.example.repasoExamen.Dto;

import java.util.List;

public record EditRutaDto(String nombre, String dificultad, List<Long> monumento,String tiempo) {

}
