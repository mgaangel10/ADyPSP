package com.example.repasoExamen.Service;

import com.example.repasoExamen.Dto.EditRutaDto;
import com.example.repasoExamen.Model.Dificultad;
import com.example.repasoExamen.Model.Monumento;
import com.example.repasoExamen.Model.Ruta;
import com.example.repasoExamen.Repo.MonumentoRepo;
import com.example.repasoExamen.Repo.RutaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RutaService {

    private final RutaRepo rutaRepo;
    private final MonumentoRepo monumentoRepo;

    public Ruta save (EditRutaDto n){
        Ruta ruta = new Ruta();
        ruta.setNombre(n.nombre());
        ruta.setTiempo(n.tiempo());
        ruta.setDificultad(Dificultad.valueOf(n.dificultad()));
        List<Monumento> monumentos = n.monumento()
                .stream().map(monumentoRepo::getReferenceById)
                .toList();
        ruta.setMonumentos(monumentos);
       return rutaRepo.save(ruta);
    }
}
