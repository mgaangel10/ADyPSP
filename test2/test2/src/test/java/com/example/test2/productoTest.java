package com.example.test2;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class productoTest {
    @Mock
    ProductoRepo productoRepo;
    @InjectMocks
    ProductoService productoService;

    @Test
    void precioMenorQue10YDisponible(){
List<Producto> data = List.of(new Producto(1L,"producto1",3,true),
        new Producto(2L,"producto2",21,true),
        new Producto(3L,"product3",20,false),
        new Producto(4L,"producto4",3,false));

        Mockito.when(productoRepo.findAll()).thenReturn(data);
        List<GetProdctoDto> getProdctoDtos=productoService.precioMenorQue10Disponible();

        List<GetProdctoDto> expecResultado = List.of(GetProdctoDto.builder()
                        .id(2l)
                        .nombre("producto2")

                .build());
        List<GetProdctoDto> resultado = productoService.precioMenorQue10Disponible();

        assertEquals(1,resultado.size());

    }



}
