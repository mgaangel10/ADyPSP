package com.example.ejercicioParejaDto.Controller;

import com.example.ejercicioParejaDto.Modal.Producto;
import com.example.ejercicioParejaDto.Repo.ProductoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepo productoRepo;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> listarTodos(){
        List<Producto> resultado = productoRepo.findAll();
        return ResponseEntity.ok(resultado);
    }







}
