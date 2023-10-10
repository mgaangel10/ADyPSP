package com.example.ejemploDeLuismiConJson.Controller;

import com.example.ejemploDeLuismiConJson.DTO.GetRutaDto;
import com.example.ejemploDeLuismiConJson.Model.Ruta;
import com.example.ejemploDeLuismiConJson.Repo.RutaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RutaController {

    private  final RutaRepo rutaRepo;

    @GetMapping("/")
    public ResponseEntity<List<GetRutaDto>> findAll(){
        List<Ruta> results = rutaRepo.findAll();
        if (results.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results.stream()
                .map(GetRutaDto::of)
                .toList());
    }
    @GetMapping("/create/{id}")
    public ResponseEntity<GetRutaDto> cretae(@PathVariable Long id, @RequestBody GetRutaDto nuevo){
        Ruta r = new Ruta();
        return  ResponseEntity.status(HttpStatus.CREATED).body(GetRutaDto.of(r));
    }




}
