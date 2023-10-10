package com.example.repasoCasa.Controller;

import com.example.repasoCasa.Model.Monumento;
import com.example.repasoCasa.Repo.MonumentoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoController {

    private final MonumentoRepo monumento;

    @GetMapping("/")
    public ResponseEntity<List<Monumento> listar(){
        List<Monumento> resultados = monumento.findAll();
        if (resultados.isEmpty()){
             return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> findById(@PathVariable Long id){
        return  ResponseEntity.of(monumento.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento m){
        if (m.getId()!=0){
           return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(monumento.save(m));
    }
     @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id,@RequestBody Monumento m){
        return ResponseEntity.of(monumento.findById(id).map(antiguo ->{
            antiguo.setNombreCiudad(m.getNombreCiudad());
            antiguo.setCodigo(m.getCodigo());
            antiguo.setNombrePais(m.getNombrePais());
            antiguo.setDescripcion(m.getDescripcion());
            antiguo.setUrl(m.getUrl());
            return monumento.save(antiguo);
        }));
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<Monumento> delete(@PathVariable Long id){
        if (monumento.existsById(id)){
             monumento.deleteById(id);
        }
        return ResponseEntity.noContent().build();
     }
}
