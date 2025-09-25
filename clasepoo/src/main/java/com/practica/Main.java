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
        
        // * 2. Agregar autores a la colección
        autores.add(johnAutor);
        autores.add(camusAutor);
        autores.add(garciaMarquezAutor);
        
        //* Catalogos (Libros/Revistas) */
        ArrayList<Catalogo> catalogos = new ArrayList<Catalogo>();
        
        // * 3. Crear libros
        Libro psicoanalistaLibro = new Libro("Suspenso Psicológico", new Date(), "9780345426260", "El Psicoanalista", GeneroLiterario.Novela);
        Libro psicoanalista2Libro = new Libro("Suspenso Psicológico", new Date(), "9781355426160", "El Psicoanalista en la Mira", GeneroLiterario.Novela);
        Libro cienAniosLibro = new Libro("Realismo Mágico", new Date(), "9780060883287", "Cien Años de Soledad", GeneroLiterario.Novela);
        Libro laPesteNegraLibro = new Libro("Historias en tiempos dificiles", new Date(), "9750163883287", "La Peste Negra", GeneroLiterario.Historia);
        
        // * 4. Crear revistas
        Revista nationalGeographic = new Revista("Revistas Científicas", new Date(), "9701155426160", "National Geographic", 425);
        Revista scientificAmerican = new Revista("Revistas Académicas", new Date(), "9021155426160", "Scientific American", 340);
        
        // * 5. Establecer relaciones autor-libro
        johnAutor.escribirLibro(psicoanalistaLibro);
        johnAutor.escribirLibro(psicoanalista2Libro);
        camusAutor.escribirLibro(laPesteNegraLibro);
        garciaMarquezAutor.escribirLibro(cienAniosLibro);
        
        psicoanalistaLibro.agregarAutor(johnAutor);
        psicoanalista2Libro.agregarAutor(johnAutor);
        cienAniosLibro.agregarAutor(garciaMarquezAutor);
        laPesteNegraLibro.agregarAutor(camusAutor);
        
        // * 6. Agregar los catálogos (libros y revistas) a ArrayList<Catalogo>
        catalogos.add(psicoanalistaLibro); 
        catalogos.add(psicoanalista2Libro);  
        catalogos.add(cienAniosLibro);  
        catalogos.add(laPesteNegraLibro);  
        catalogos.add(nationalGeographic); 
        catalogos.add(scientificAmerican); 

        //* Consultas básicas */
        System.out.println("============== CONSULTAS BÁSICAS ==============");

        //* 7. Listado de todos los libros y revistas (Usando el metodo etiquetaCatalogo()) */
        System.out.println();
        System.out.println("============== LISTADO CATALOGO ==============");

        for (Catalogo catalogo : catalogos) {
            System.out.println("- " + catalogo.etiquetaCatalogo());
        }

        //* 8. Mostrar los autores y sus libros (listarLibros()) */
        System.out.println();
        System.out.println("============== LISTADO AUTORES ==============");
        for (Autor autor : autores) {
            String authorInfo = "- " + autor.getNombre() + " (" + autor.getNacionalidad() + ")";

            for (Libro libro : autor.listarLibros()) {
                authorInfo += "\n - " + libro.getNombre() + " (ISBN: " + libro.getIsbn() + "): " + libro.getGenero();
            }

            System.out.println(authorInfo);
            System.out.println();
        }

        //* 9. Citas */
        System.out.println();
        System.out.println("============== LISTADO CITAS ==============");

        for (Catalogo catalogo : catalogos) {            
            if(catalogo instanceof Libro) {
                Libro libro = (Libro) catalogo; //Casting
                System.out.println("- Libro: " + libro.getNombre());
                System.out.println("\n - Cita BibText: " + libro.generarCitaBibText());
                System.out.println("\n - Cita Ris: " + libro.generarCitaRIS());
                System.out.println("\n - Cita RefWorks: " + libro.generarCitaRefWorks());
            }else{
                Revista revista = (Revista) catalogo; //Casting
                System.out.println("- Revista: " + revista.getTitulo());
                System.out.println("\n - Cita BibText: " + revista.generarCitaBibText());
                System.out.println("\n - Cita Ris: " + revista.generarCitaRIS());
                System.out.println("\n - Cita RefWorks: " + revista.generarCitaRefWorks());
            }

            System.out.println();
        }
    }
}