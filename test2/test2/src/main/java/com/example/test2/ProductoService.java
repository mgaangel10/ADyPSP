package com.example.test2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepo productoRepo;

    public Producto save (Producto producto){
        return productoRepo.save(producto);
    }


    public List<Producto> saveAll(List<Producto> producto){
        return productoRepo.saveAll(producto);
    }

    public List<Producto> findAll(){
        return productoRepo.findAll();
    }

    public List<Producto> preciomenorque(double precio){
        return productoRepo.findByPrecioLessThan(precio);
    }

    public List<GetProdctoDto> precioMenorQue10Disponible(){
        List<Producto> productos = productoRepo.findAll();
        List<GetProdctoDto> getProdctoDtos = new ArrayList<>();

        for(Producto producto: productos){
            if (producto.getPrecio()<10){
                if (producto.isDisponible()){
                    getProdctoDtos.add(GetProdctoDto.of(producto));
                }
            }
        }
        return productoRepo.saveAll(getProdctoDtos);
    }

}
