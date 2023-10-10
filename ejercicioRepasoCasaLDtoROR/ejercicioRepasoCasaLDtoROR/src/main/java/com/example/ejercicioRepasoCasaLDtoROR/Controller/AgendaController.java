package com.example.ejercicioRepasoCasaLDtoROR.Controller;

import com.example.ejercicioRepasoCasaLDtoROR.Dto.GetAgenda;
import com.example.ejercicioRepasoCasaLDtoROR.Model.Agenda;
import com.example.ejercicioRepasoCasaLDtoROR.Repo.AgendaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaRepo agendaRepo;

    @GetMapping("/")
    public ResponseEntity<List<GetAgenda>> findAll(){
        List<Agenda> resultados = agendaRepo.findAll();
        if (resultados.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                resultados.stream()
                .map(GetAgenda::of)
                .toList()
        );

    }
}
