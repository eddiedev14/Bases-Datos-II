package com.practica.Negocio;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//* Añadir proyecto lombok para generar constructores, getters y setters -> Anotaciones
@Data
@AllArgsConstructor //Constructor con todos los argumentos
@NoArgsConstructor //Constructor sin argumentos
public class Autor {
    private int id;
    private String nombre;
    private String nacionalidad;
    private String biografia;
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public void escribirLibro(Libro libro){
        this.libros.add(libro);
    }

    public ArrayList<Libro> listarLibros(){
        return this.libros;
    }
}
