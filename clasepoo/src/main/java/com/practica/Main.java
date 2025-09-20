package com.practica;

import java.util.ArrayList;
import java.util.Date;

import com.practica.Negocio.Autor;
import com.practica.Negocio.Catalogo;
import com.practica.Negocio.GeneroLiterario;
import com.practica.Negocio.Libro;
import com.practica.Negocio.Revista;

public class Main { 
    public static void main(String[] args) {
        System.out.println("============== SISTEMA DE GESTION DE BIBLIOTECA ==============");
        System.out.println();
        
        //* Autores */
        ArrayList<Autor> autores = new ArrayList<Autor>();
        
        // * 1. Crear autores
        Autor johnAutor = new Autor(1, "John Katzenbach", "Estados Unidos", "Autor estadounidense de novelas de suspenso psicológico");
        Autor camusAutor = new Autor(2, "Albert Camus", "Algeria", "Filósofo, novelista y dramaturgo francés-argelino");
        Autor garciaMarquezAutor = new Autor(3, "Gabriel García Márquez", "Colombia", "Escritor colombiano, Premio Nobel de Literatura 1982");
        Autor asimovAutor = new Autor(4, "Isaac Asimov", "Estados Unidos", "Escritor de ciencia ficción y divulgación científica");
        
        // * 2. Agregar autores a la colección
        autores.add(johnAutor);
        autores.add(camusAutor);
        autores.add(garciaMarquezAutor);
        autores.add(asimovAutor);
        
        //* Catalogos (Libros/Revistas) */
        ArrayList<Catalogo> catalogos = new ArrayList<Catalogo>();
        
        // * 3. Crear libros
        Libro psicoanalistaLibro = new Libro("Suspenso Psicológico", new Date(), "9780345426260", "El Psicoanalista", GeneroLiterario.Novela);
        Libro psicoanalista2Libro = new Libro("Suspenso Psicológico", new Date(), "9781355426160", "El Psicoanalista en la Mira", GeneroLiterario.Novela);
        Libro cienAniosLibro = new Libro("Realismo Mágico", new Date(), "9780060883287", "Cien Años de Soledad", GeneroLiterario.Novela);
        
        // * 4. Crear revistas
        Revista nationalGeographic = new Revista("Revistas Científicas", new Date(), "9701155426160", "National Geographic", 425);
        Revista scientificAmerican = new Revista("Revistas Académicas", new Date(), "9021155426160", "Scientific American", 340);
        
        // * 5. Establecer relaciones autor-libro
        johnAutor.escribirLibro(psicoanalistaLibro);
        johnAutor.escribirLibro(psicoanalista2Libro);
        garciaMarquezAutor.escribirLibro(cienAniosLibro);
        
        psicoanalistaLibro.agregarAutor(johnAutor);
        psicoanalista2Libro.agregarAutor(johnAutor);
        cienAniosLibro.agregarAutor(garciaMarquezAutor);
        
        // * 6. Agregar los catálogos (libros y revistas) a ArrayList<Catalogo>
        catalogos.add(psicoanalistaLibro); 
        catalogos.add(psicoanalista2Libro);  
        catalogos.add(cienAniosLibro);  
        catalogos.add(nationalGeographic); 
        catalogos.add(scientificAmerican); 

        
    }
}