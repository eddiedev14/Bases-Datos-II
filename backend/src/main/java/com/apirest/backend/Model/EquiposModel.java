package com.apirest.backend.Model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document ("equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquiposModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String serial;
    private List<AsignacionesEmpleado> asignaciones = new ArrayList<>();

    public void crearAsignacion(AsignacionesEmpleado asignacion){
        this.asignaciones.add(asignacion);
    }
}
