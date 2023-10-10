package com.example.ejemploDeLuismiConJson.Model;

import com.example.ejemploDeLuismiConJson.Json.MonumentoJson;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {
    @Id
    @GeneratedValue
    @JsonView({MonumentoJson.MonumentoList.class})
    private Long id;
    @JsonView({MonumentoJson.MonumentoList.class, MonumentoJson.MonumentoEdit.class, MonumentoJson.MonumentoDetail.class})
    private String nombreMon;
    @JsonView({MonumentoJson.MonumentoList.class, MonumentoJson.MonumentoEdit.class, MonumentoJson.MonumentoDetail.class})
    private String  Localizacion;
    @JsonView({MonumentoJson.MonumentoList.class, MonumentoJson.MonumentoEdit.class, MonumentoJson.MonumentoDetail.class})
    private String pais;
    @JsonView({MonumentoJson.MonumentoList.class, MonumentoJson.MonumentoEdit.class, MonumentoJson.MonumentoDetail.class})
    private String ciudad;
    @JsonView({MonumentoJson.MonumentoList.class, MonumentoJson.MonumentoEdit.class, MonumentoJson.MonumentoDetail.class})
    private String codigoDelPais;


    @OneToMany
    @JsonView({MonumentoJson.MonumentoList.class})
    private Categoria categoria;


}
