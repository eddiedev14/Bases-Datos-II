package com.apirest.backend.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponseDTO {
    private String id;
    private String nombre;
    private Integer edad;
    private DireccionDTO direccion;
    private List<String> lenguajes;
}
