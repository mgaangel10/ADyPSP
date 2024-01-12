package com.example.test2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepo extends JpaRepository<Producto,Long> {

    List<Producto> findByPrecioLessThan(double precio);
}
