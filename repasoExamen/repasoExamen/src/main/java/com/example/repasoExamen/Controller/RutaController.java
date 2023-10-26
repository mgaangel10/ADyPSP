package com.example.repasoExamen.Controller;

import com.example.repasoExamen.Dto.EditRutaDto;
import com.example.repasoExamen.Dto.GetRutaDto;
import com.example.repasoExamen.Model.Ruta;
import com.example.repasoExamen.Repo.RutaRepo;
import com.example.repasoExamen.Service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/ruta")
@RequiredArgsConstructor
public class RutaController {

    private final RutaRepo rutaRepo;
    private final RutaService rutaService;

    @GetMapping("/")
    public ResponseEntity<List<GetRutaDto>> findall(){
        List<Ruta> r = rutaRepo.findAll();
        if (r.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(r.stream()
                .map(GetRutaDto::of)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRutaDto> findById(@PathVariable Long id){

        if (rutaRepo.existsById(id)){
           return ResponseEntity.of(rutaRepo.findById(id)
                    .map(GetRutaDto::of));
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/")
    public ResponseEntity<GetRutaDto> create(@RequestBody EditRutaDto nuevo){

        Ruta ruta = rutaService.save(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(GetRutaDto.of(ruta));

    }



}
