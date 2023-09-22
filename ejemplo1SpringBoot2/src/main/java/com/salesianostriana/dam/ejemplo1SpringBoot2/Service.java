package com.salesianostriana.dam.ejemplo1SpringBoot2;

import lombok.RequiredArgsConstructor;
@org.springframework.stereotype.Service

@RequiredArgsConstructor
public class Service {
    private final Componente componente;
    private final Componente2 componente2;

    public void escribir(){
    componente.print();
    componente2.print();

    }


}
