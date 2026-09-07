package org.example;

import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   PRUEBAS DEL SISTEMA DE GESTIÓN DE BIBLIOTECA  ");
        System.out.println("=================================================\n");

        // 1. Instanciación de la Biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // 2. Registro de Usuarios
        System.out.println("--- 1. REGISTRO DE USUARIOS ---");
        Usuario usuario1 = new Usuario("U001", "Juan Pérez", 2);
        Usuario usuario2 = new Usuario("U002", "Camila Gómez", 1);
        
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);
        System.out.println("Usuarios registrados correctamente.\n");

        // 3. Instanciación de las 3 Clases de Materiales (Herencia)
        System.out.println("--- 2. CREACIÓN DE MATERIALES (Libro, LibroDigital, Revista) ---");
        
        // Libro Físico (id, titulo, fechaPublicacion, disponible, autor, numeroPaginas)
        Libro libro1 = new Libro("L001", "Cien Años de Soledad", 1967, true, "Gabriel García Márquez", 496);
        
        // Libro Digital (id, titulo, fechaPublicacion, disponible, autor, tamanoArchivo, formato)
        LibroDigital libroDigital1 = new LibroDigital("LD001", "Clean Code", 2008, true, "Robert C. Martin", 2.5, "PDF");
        
        // Revista (id, titulo, fechaPublicacion, disponible, numeroEdicion, periodicidad)
        Revista revista1 = new Revista("R001", "National Geographic", 2023, true, 250, "Mensual");

        // Agregar los materiales al inventario
        biblioteca.agregarMaterial(libro1);
        biblioteca.agregarMaterial(libroDigital1);
        biblioteca.agregarMaterial(revista1);
        System.out.println("Materiales agregados al inventario de la biblioteca.\n");

        // 4. Demostración de Polimorfismo
        System.out.println("--- 3. DEMOSTRACIÓN DE POLIMORFISMO (Listar Todos) ---");
        biblioteca.mostrarMateriales();
        System.out.println();

        // 5. Prueba de Interfaces (Prestable y Descargable)
        System.out.println("--- 4. PRUEBA DE INTERFACES ---");
        System.out.println("a) Interfaz Prestable en Libro:");
        libro1.prestar();

        System.out.println("\nb) Interfaz Descargable en LibroDigital:");
        libroDigital1.descargar();
        System.out.println();

        // 6. Pruebas de Búsqueda
        System.out.println("--- 5. PRUEBAS DE BÚSQUEDA ---");
        System.out.println("a) Búsqueda por Título:");
        Material encontrado = biblioteca.buscarPorTitulo("Clean Code");
        if (encontrado != null) {
            encontrado.mostrarInformacion();
        }

        System.out.println("\nb) Búsqueda por Autor:");
        List<Material> porAutor = biblioteca.buscarPorAutor("Gabriel García Márquez");
        for (Material m : porAutor) {
            m.mostrarInformacion();
        }
        System.out.println();

        // 7. Pruebas de Lógica de Negocio y Préstamos
        System.out.println("--- 6. PRUEBAS DE REGLAS DE NEGOCIO (PRÉSTAMOS) ---");
        System.out.println("Consultando préstamos disponibles para U001:");
        System.out.println("Disponibles: " + biblioteca.buscarPrestamosDisponibles("U001"));

        System.out.println("\nIntentando prestar L001 a Juan Pérez (U001):");
        biblioteca.prestarMaterial("U001", "L001");

        System.out.println("\n=================================================");
        System.out.println("       FIN DE LAS PRUEBAS DE LABORATORIO         ");
        System.out.println("=================================================");
    }
}
