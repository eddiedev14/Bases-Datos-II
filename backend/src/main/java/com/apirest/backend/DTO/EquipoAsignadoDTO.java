package com.apirest.backend.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// * Un DTO para mostrar solo los datos necesarios y no exponer todo el Model
// * Los DTO's NO TIENEN REPOSITORIOS NI LÓGICA DE NEGOCIO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoAsignadoDTO {
    private String equipo;
    private String serial;
    private Date fecha;
    private String estado;
}