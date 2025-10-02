package com.apirest.backend.Model;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionesEmpleados {
    private ObjectId empleadoId;
    private String nombreEmpleado;
    private LocalDate fecha;
    private EstadoEquipo estado;   
}