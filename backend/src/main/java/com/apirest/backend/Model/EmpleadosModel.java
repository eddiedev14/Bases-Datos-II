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

@Document ("empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadosModel {
    @Id
    private ObjectId id;
    private String nombre;
    private Integer edad;
    private DireccionEmpleado direccion; // simula el documento embebido
    private List<String> lenguajes = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString(){
        return id != null ? id.toHexString():null;
    }

}
