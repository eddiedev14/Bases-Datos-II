package com.practica.Negocio;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Revista extends Catalogo implements IPublicable {
    private String issn;
    private String nombre;
    private int numero;

    public Revista(String tituloCatalogo, Date fechaPublicacion, String issn, String nombre, int numero){
        super(tituloCatalogo, fechaPublicacion);
        this.issn = issn;
        this.nombre = nombre;
        this.numero = numero;
    }

    //* Métodos heredados */
    @Override
    public String etiquetaCatalogo() {
        return "Revista: " + this.nombre + ", pertenece al: " + super.etiquetaCatalogo();
    }

    @Override
    public String generarCitaBibText() {
        return "Cita en formato BibText de la revista " + this.nombre;
    }

    @Override
    public String generarCitaRIS() {
        return "Cita en formato BibText de la revista " + this.nombre;
    }

    @Override
    public String generarCitaRefWorks() {
        return "Cita en formato BibText de la revista " + this.nombre;
    }
}
