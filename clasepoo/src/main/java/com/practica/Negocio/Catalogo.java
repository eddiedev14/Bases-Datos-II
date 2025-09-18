package com.practica.Negocio;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Catalogo {
    protected String titulo;
    protected Date fechaPublicacion;

    //Métodos
    public String etiquetaCatalogo(){
        return "Catalogo es: " + this.titulo + ", fecha de publicación: " + this.fechaPublicacion;        
    }
}
