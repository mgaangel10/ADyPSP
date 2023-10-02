package com.example.solucionEjercicio.Controller;

import com.example.solucionEjercicio.Modal.Lugar;
import com.example.solucionEjercicio.Repo.LugraRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class LugarController {

    private final LugraRepo lugar;

    @GetMapping("/")
    public ResponseEntity<List<Lugar>>todos(){
        List<Lugar> result = lugar.findAll();
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lugar> findById(@PathVariable Long id){
        return ResponseEntity.of(lugar.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Lugar> create(@RequestBody Lugar l){
        return ResponseEntity.status(HttpStatus.CREATED).body(lugar.save(l));
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




