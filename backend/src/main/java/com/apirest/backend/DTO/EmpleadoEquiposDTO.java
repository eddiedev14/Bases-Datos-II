package com.apirest.backend.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEquiposDTO {
    private String nombreEmpleado;
    private List<EquipoAsignadoDTO> equiposAsignados;
}