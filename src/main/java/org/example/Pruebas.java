package org.example;

import java.time.LocalDate;

public class Pruebas {
    public static void main(String[] args) {
        
        // 1. Se pasan los 3 argumentos (String, String, String) que exige el constructor
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Sede Facultad", "123456789");

        // 2. Se pasan los 4 parámetros sueltos en lugar de pasar el objeto Usuario completo
        biblioteca.registrarUsuario("U001", "Camila", "camila@universidad.edu", 3);
        biblioteca.registrarUsuario("U002", "Carlos", "carlos@universidad.edu", 5);

        // 3. Se crean los materiales respetando la cantidad y el tipo de dato de cada constructor
        
        // Libro: 9 parámetros (id, titulo, autor, categoria, fecha, idioma, editorial, isbn, paginas)
        Libro libro = new Libro(
            "MAT001", "Técnicas de Programación en Java", "John Doe", "Educación", 
            LocalDate.of(2023, 8, 15), "Español", "Ediciones Universidad", "978-1234", 350
        );

        // LibroDigital: 10 parámetros (id, titulo, autor, categoria, fecha, idioma, editorial, isbn, formato, pesoMB)
        LibroDigital libroDigital = new LibroDigital(
            "MAT002", "Kotlin in Action", "Dmitry Jemerov", "Tecnología", 
            LocalDate.of(2017, 2, 19), "Inglés", "Manning", "978-5678", "PDF", 5.2
        );

        // Revista: 9 parámetros (id, titulo, autor, fecha, idioma, editorial, issn, periodicidad, numero)
        Revista revista = new Revista(
            "MAT003", "Revista de Ingeniería", "Varios", 
            LocalDate.of(2026, 9, 1), "Español", "Facultad", "1111-2222", "Mensual", 45
        );

        System.out.println("✅ Pruebas ejecutadas. Los objetos instanciaron correctamente sin errores de compilación.");

        // NOTA: Las siguientes líneas están comentadas porque los métodos aún no existen 
        // en las clases Biblioteca, Material o Libro. Si los descomentas ahora, no compilará.
        
        // biblioteca.mostrarMateriales();
        // biblioteca.prestarMaterial("MAT001", "U001");
        // libro.prestar();
    }
}