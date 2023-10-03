package com.example.ejemploDTO.Controller;

import com.example.ejemploDTO.DTO.GetMonumentoDto;
import com.example.ejemploDTO.Model.Monumento;
import com.example.ejemploDTO.repo.MonumentoRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoController {
    private final MonumentoRepo monumentoRepo;

    @GetMapping("/")
    public ResponseEntity<List<GetMonumentoDto>> todos(){
        List<Monumento> resultados = monumentoRepo.findAll();
        if (resultados.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        //hacemos la transformacion de monumento -> GetMonumentoDto
        List<GetMonumentoDto> r = resultados.stream().map(GetMonumentoDto::of).toList();
        return ResponseEntity.ok(r);
    }
}
