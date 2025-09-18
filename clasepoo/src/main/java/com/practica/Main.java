package com.practica;

import java.util.ArrayList;
import java.util.Date;

import com.practica.Negocio.Autor;
import com.practica.Negocio.GeneroLiterario;
import com.practica.Negocio.Libro;
import com.practica.Negocio.Revista;

public class Main { 
    public static void main(String[] args) {
        ArrayList<Libro> librosBD = new ArrayList<Libro>();

        //* Crear objetos de tipo Autor, Libro, Revista */
        Autor johnAutor = new Autor(1, "John Katzenbach", "Estados Unidos", "John Katzenbach is an American author of popular fiction");
        Autor camusAutor = new Autor(2, "Albert Camus", "Algeria", "Albert Camus was an Algerian-born French philosopher, novelist, author, dramatist, journalist, world federalist, and political activist.");

        Libro psicoanalistaLibro = new Libro("Suspenso Psicológico", new Date(), "9780345426260", "El Psicoanalista", GeneroLiterario.Novela);
        Libro psicoanalista2Libro = new Libro("Suspenso Psicológico", new Date(), "9781355426160", "El Psicoanalista en la Mira", GeneroLiterario.Novela);
        Libro pesteNegraLibro = new Libro("Novela en tiempos díficiles", new Date(), "9780345426260", "La Peste Negra", GeneroLiterario.Fantasia);
        
        //* Agregar al array list */
        librosBD.add(psicoanalistaLibro);
        librosBD.add(psicoanalista2Libro);
        librosBD.add(pesteNegraLibro);

        Revista nationalGeographic = new Revista("Revistas academicas", new Date(), "9701155426160", "National Geographhic", 201293123);
        Revista wigetta = new Revista("Revistas de caricaturas", new Date(), "9021155426160", "Wigetta", 201200123);

        //* Establecer relaciones entre autores y libros (escribirLibro() ↔ agregarAutor()) */
        johnAutor.escribirLibro(psicoanalistaLibro);
        johnAutor.escribirLibro(psicoanalista2Libro);
        camusAutor.escribirLibro(pesteNegraLibro);

        johnAutor.escribirLibro(psicoanalistaLibro);
        johnAutor.escribirLibro(psicoanalista2Libro);
        pesteNegraLibro.agregarAutor(camusAutor);

        //* Listar todos los libros con su etiqueta de catalogo */
        System.err.println("==================== INFORMACION DE LIBROS Y ETIQUETA CATALOGO ====================");

        for (int i = 0; i < librosBD.size(); i++) {
            Libro libro = librosBD.get(i);
            System.out.println(libro.toString() + " - " + libro.etiquetaCatalogo());
        }
    }
}