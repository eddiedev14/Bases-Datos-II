package com.apirest.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionEmpleado {
    private String ubicacion;
    private String barrio;
    private Integer codPostal; // Se define con la clase Integer
}
