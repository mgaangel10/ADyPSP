package com.example.ejercicioParejaDto.DTO;

import com.example.ejercicioParejaDto.Modal.Producto;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetProductoDTO {

    private Long id;

    private String nombre,imagen,categoria;

    private double pvp;

    public static GetProductoDTO of (Producto producto){
        return GetProductoDTO.builder()
                .nombre(producto.getNombre())
                .pvp(producto.getPvp())
                .imagen(producto.getImagenes().stream().findFirst().get())
                .categoria(producto.getCategoria().getNombre())
                .build();

    }

}
