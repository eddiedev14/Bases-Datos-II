package com.apirest.backend.Model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private List<AsignacionesEmpleados> asignaciones = new ArrayList<>();

    // Metodo para crear asignacion en el array
    public void crearAsignacion(AsignacionesEmpleados asignacion){
        this.asignaciones.add(asignacion);
    }

    @JsonProperty("id")
    public String getId(){
        return this.id != null ? id.toHexString() : null;
    }
}