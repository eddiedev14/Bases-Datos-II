package com.practica.Negocio;

import java.util.Date;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//* Extiende de la clase Catalogo e implementa la interface
public class Libro extends Catalogo implements IPublicable {
    private String isbn;
    private String nombre;
    private GeneroLiterario genero; //* Crear enumeration, el tipo es el nombre de la Enum */
    private ArrayList<Autor> autores = new ArrayList<Autor>();

    //* Constructor propio */
    public Libro(String tituloCatalogo, Date fechaPublicacion, String isbn, String nombre, GeneroLiterario genero) {
        super(tituloCatalogo, fechaPublicacion);
        this.isbn = isbn;
        this.nombre = nombre;
        this.genero = genero;
    }
    
    //* Métodos propios */
    public void agregarAutor(Autor autor){
        this.autores.add(autor);
    }
    
    public ArrayList<Autor> listarAutores(){
        return this.autores;
    }

    //* Métodos heredados */
    //* Implementar los metodos de la clase abstracta para hacerle override
    @Override
    public String etiquetaCatalogo() {
        return "Libro: " + this.nombre + ", pertenece al: " + super.etiquetaCatalogo();
    }

    //* Implementar los metodos de la interface */
    @Override
    public String generarCitaBibText() {
        return "Cita en formato BibText del libro " + this.nombre;
    }

    @Override
    public String generarCitaRIS() {
        return "Cita en formato RIS del libro " + this.nombre;
    }

    @Override
    public String generarCitaRefWorks() {
        return "Cita en formato RefWorks del libro " + this.nombre;
    }
}
