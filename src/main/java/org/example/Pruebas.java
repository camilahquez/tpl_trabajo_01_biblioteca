package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pruebas {
    
    public static void ejecutarPruebas() {
        System.out.println("\n=== INICIANDO PRUEBAS AUTOMÁTICAS ===");
        
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca(
                "Biblioteca UdeA",
                "Medellín",
                "B001"
        );
        biblioteca.registrar(
                "L002",
                "El amor en los tiempos del cólera",
                "Gabriel García Márquez",
                "Editorial Oveja Negra",
                LocalDate.of(1985, 12, 5),
                "Español",
                "Romance",
                "001",
                4
        );

// Tercer libro del mismo autor
        biblioteca.registrar(
                "L003",
                "Crónica de una muerte anunciada",
                "Gabriel García Márquez",
                "Editorial La Oveja Negra",
                LocalDate.of(1981, 4, 1),
                "Español",
                "Novela",
                "001",
                3
        );

        // Crear LIBRO
        biblioteca.registrar(
                "L001",
                "Cien años de soledad",
                "Gabriel García Márquez",
                "Editorial Sudamericana",
                LocalDate.of(1967, 5, 30),
                "Español",
                "Realismo mágico",
                "001",
                3
        );

        // Crear REVISTA
        biblioteca.registrar(
                "R001",
                "National Geographic",
                "National Geographic",
                LocalDate.of(2026, 8, 1),
                "Español",
                "Mensual",
                "25",
                "08",
                5
        );

        // Crear LIBRO DIGITAL
        biblioteca.registrar(
                "D001",
                "El principito",
                "Antoine de Saint-Exupéry",
                "Editorial Digital",
                LocalDate.of(1943, 4, 6),
                "Español",
                "Literatura",
                "001",
                "https://biblioteca.com/el-principito",
                2.5
        );

        // Crear USUARIO
        biblioteca.registrarUsuario(
                "1039468510",
                "Camila",
                "1234",
                5
        );

        // Mostrar materiales
        //System.out.println("===== MATERIALES =====");
        //biblioteca.mostrasMateriales();
        //biblioteca.buscarId("1039468510");
       // biblioteca.buscarPorAutor("Gabriel García Márquez");
        ArrayList<Material> resultados = biblioteca.buscarPorAutor("Gabriel García Márquez");

        for (Material material : resultados) {
            System.out.println(material);
        }
        // =========================
// INICIAR SESIÓN
// =========================

        biblioteca.iniciarSesion("1039468510", "1234");


// =========================
// HACER DOS PRÉSTAMOS
// =========================

        System.out.println("\n===== PRIMER PRÉSTAMO =====");

        biblioteca.Prestar(
                "1039468510",
                "Cien años de soledad",
                LocalDate.now()
        );


        System.out.println("\n===== SEGUNDO PRÉSTAMO =====");

        biblioteca.Prestar(
                "1039468510",
                "El amor en los tiempos del cólera",
                LocalDate.now()
        );
        biblioteca.mostrarPrestamos();


// =========================
// DEVOLVER EL PRIMER LIBRO
// =========================

        System.out.println("\n===== DEVOLUCIÓN =====");

        biblioteca.devolver(
                "1039468510",
                "Cien años de soledad", LocalDate.of(2026, 9, 8));
        biblioteca.mostrarPrestamos();
        biblioteca.estaditicas();

        
        System.out.println("=== FIN DE LAS PRUEBAS AUTOMÁTICAS ===\n");
    }
}