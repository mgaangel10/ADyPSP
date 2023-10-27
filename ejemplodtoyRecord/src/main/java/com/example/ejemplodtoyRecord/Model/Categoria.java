package com.example.ejemplodtoyRecord.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categoria {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @OneToMany
    private Moumento moumento;
}
