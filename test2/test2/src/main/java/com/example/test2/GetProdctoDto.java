package com.example.test2;

import lombok.Builder;

@Builder
public record GetProdctoDto(Long id,
                            String nombre,
                            double precio,
                            boolean dispo) {

    public static GetProdctoDto of(Producto producto){

        return new GetProdctoDto(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.isDisponible()
        );
    }

}
