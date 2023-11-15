package com.example.solucionEjercicio.Controller;

import com.example.solucionEjercicio.DTO.LugarDto;
import com.example.solucionEjercicio.Modal.Lugar;
import com.example.solucionEjercicio.Repo.LugraRepo;
import com.example.solucionEjercicio.service.Lugarservice;
import error.RutaNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class LugarController {

    private final LugraRepo lugar;
    private final Lugarservice lugarService;

    @GetMapping("/")
    public ResponseEntity<List<Lugar>>todos(){
        List<Lugar> result = lugar.findAll();
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public LugarDto findById(@PathVariable Long id){
        return lugarService.findByIdddd(id);
    }

    @PostMapping("/")
    public ResponseEntity<Lugar> create(@Valid @RequestBody Lugar l){
        Lugar lugar1 = lugarService.create(l);
        URI createUri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lugar1.getId()).toUri();
        return ResponseEntity.created(createUri).body(lugar1);
    }
    @PutMapping("/{íd}")
    public ResponseEntity<Lugar> edit(@PathVariable Long id,@RequestBody Lugar l){
    return ResponseEntity.of(lugar.findById(id).map(antiguo ->{
        antiguo.setNombre(l.getNombre());
        antiguo.setLocalizacion(l.getLocalizacion());
        antiguo.setDescripcion(l.getDescripcion());
        antiguo.setUrl(l.getUrl());
        return lugar.save(l);
    }));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Lugar> delete(@PathVariable Long id){
        if (lugar.existsById(id)){
            lugar.findById(id);

        }
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/tag/add/{nuevo}")
    public ResponseEntity<Lugar> addTag(@PathVariable Long id, @PathVariable String nuevo) {
        return ResponseEntity.of(lugar.findById(id).map(place -> {
             if (place.getTags().contains(nuevo)){

                 place.setTags(
                         place.getTags()+", "+nuevo);


                 return lugar.save(place);

            }
             return place;
        }));
    }
    @PutMapping("/{id}/tag/del/{eliminar}")
    public ResponseEntity<Lugar> delTag(
            @PathVariable Long id,
            @PathVariable String eliminar
    ) {
        return ResponseEntity.of(
                lugar.findById(id)

                        .map(place -> {
                            if (place.getTags().contains(eliminar)) {
                                String tags = place.getTags();
                                tags = tags.replace(eliminar,"");
                                tags = tags.replace(",,", ",");
                                if (tags.endsWith(","))
                                    tags = tags.substring(0, tags.length()-1);

                                place.setTags(tags);
                                return lugar.save(place);
                            }

                            return place;
                        })
        );


    }

}




