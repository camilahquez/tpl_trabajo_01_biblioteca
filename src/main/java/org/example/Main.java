package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializamos la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle Principal 123", "BIBLIO-001");
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("¡Bienvenido al sistema de la Biblioteca Central!");

        while (opcion != 10) {
            System.out.println("\n================ MENÚ PRINCIPAL ================");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrar Material (Libro, Libro Digital o Revista)");
            System.out.println("3. Registrar Usuario (Profesor, Estudiante, Empleado)");
            System.out.println("4. Prestar Material");
            System.out.println("5. Devolver Material");
            System.out.println("6. Mostrar todos los Materiales");
            System.out.println("7. Descargar Material Digital");
            System.out.println("8. Ver Estadísticas"); // <-- ¡Aquí está de vuelta!
            System.out.println("9. Cerrar Sesión");
            System.out.println("10. Salir del sistema");
            System.out.println("11.buscar por autor");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.println("\n--- INICIAR SESIÓN ---");
                    System.out.print("ID Usuario: ");
                    String idLogin = scanner.nextLine();
                    System.out.print("Clave: ");
                    String claveLogin = scanner.nextLine();
                    biblioteca.iniciarSesion(idLogin, claveLogin);
                    break;

                case 2:
                    System.out.println("\n--- TIPO DE MATERIAL ---");
                    System.out.println("1. Libro Físico");
                    System.out.println("2. Libro Digital");
                    System.out.println("3. Revista");
                    System.out.print("Elige el tipo (1, 2 o 3): ");
                    int tipoMaterial = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    System.out.print("ID Material: ");
                    String idM = scanner.nextLine();
                    System.out.print("Título: ");
                    String tit = scanner.nextLine();
                    System.out.print("Editorial: ");
                    String edit = scanner.nextLine();
                    System.out.print("Idioma: ");
                    String idio = scanner.nextLine();

                    if (tipoMaterial == 1) {
                        System.out.print("Autor: ");
                        String aut = scanner.nextLine();
                        System.out.print("Género: ");
                        String gen = scanner.nextLine();
                        System.out.print("Número de edición: ");
                        String numEd = scanner.nextLine();
                        System.out.print("Cantidad disponible: ");
                        int cant = scanner.nextInt();
                        scanner.nextLine();
                        
                        biblioteca.registrar(idM, tit, aut, edit, LocalDate.now(), idio, gen, numEd, cant);
                        System.out.println("Libro Físico registrado con éxito.");
                        
                    } else if (tipoMaterial == 2) {
                        System.out.print("Autor: ");
                        String aut = scanner.nextLine();
                        System.out.print("Género: ");
                        String gen = scanner.nextLine();
                        System.out.print("Número de edición: ");
                        String numEd = scanner.nextLine();
                        System.out.print("Link de descarga: ");
                        String link = scanner.nextLine();
                        System.out.print("Tamaño del archivo (ej. 2.5): ");
                        double tamano = scanner.nextDouble();
                        scanner.nextLine();
                        
                        biblioteca.registrar(idM, tit, aut, edit, LocalDate.now(), idio, gen, numEd, link, tamano);
                        System.out.println("Libro Digital registrado con éxito.");
                        
                    } else if (tipoMaterial == 3) {
                        System.out.print("Periodicidad (ej. Mensual, Semanal): ");
                        String per = scanner.nextLine();
                        System.out.print("Volumen: ");
                        String vol = scanner.nextLine();
                        System.out.print("Número de revista: ");
                        String numRev = scanner.nextLine();
                        System.out.print("Cantidad disponible: ");
                        int cant = scanner.nextInt();
                        scanner.nextLine();
                        
                        biblioteca.registrar(idM, tit, edit, LocalDate.now(), idio, per, vol, numRev, cant);
                        System.out.println("Revista registrada con éxito.");
                        
                    } else {
                        System.out.println("Tipo de material no válido.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- REGISTRAR USUARIO ---");
                    System.out.print("ID Usuario: ");
                    String idU = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nom = scanner.nextLine();
                    System.out.print("Clave: ");
                    String clave = scanner.nextLine();
                    
                    System.out.println("¿Qué tipo de usuario es?");
                    System.out.println("1. Profesor (5 préstamos)");
                    System.out.println("2. Estudiante (3 préstamos)");
                    System.out.println("3. Empleado (1 préstamo)");
                    System.out.print("Elige una opción: ");
                    int tipoUsr = scanner.nextInt();
                    scanner.nextLine();
                    
                    int maxPrestamos;
                    if (tipoUsr == 1) {
                        maxPrestamos = 5;
                    } else if (tipoUsr == 2) {
                        maxPrestamos = 3;
                    } else if (tipoUsr == 3) {
                        maxPrestamos = 1;
                    } else {
                        System.out.println("Opción no válida. Se asignará 1 préstamo por defecto.");
                        maxPrestamos = 1;
                    }
                    
                    biblioteca.registrarUsuario(idU, nom, clave, maxPrestamos);
                    System.out.println("Usuario registrado correctamente.");
                    break;

                case 4:
                    System.out.println("\n--- PRESTAR MATERIAL ---");
                    System.out.print("Ingresa tu ID de Usuario (el que inició sesión): ");
                    String idPrestamo = scanner.nextLine();
                    System.out.print("Ingresa el Título del material: ");
                    String tituloPrestar = scanner.nextLine();
                    
                    biblioteca.Prestar(idPrestamo, tituloPrestar, LocalDate.now());
                    break;

                case 5:
                    System.out.println("\n--- DEVOLVER MATERIAL ---");
                    System.out.print("Ingresa tu ID de Usuario (el que inició sesión): ");
                    String idDevolucion = scanner.nextLine();
                    System.out.print("Ingresa el Título del material a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    
                    biblioteca.devolver(idDevolucion, tituloDevolver, LocalDate.now());
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE MATERIALES ---");
                    biblioteca.mostrasMateriales();
                    break;

                case 7:
                    System.out.println("\n--- DESCARGAR MATERIAL DIGITAL ---");
                    System.out.print("Ingresa el Título del libro digital a descargar: ");
                    String tituloDescargar = scanner.nextLine();
                    biblioteca.descargar(tituloDescargar);
                    break;

                case 8:
                    System.out.println("\n--- ESTADÍSTICAS ---");
                    biblioteca.estaditicas(); // Llama al método que ya tenías en Biblioteca
                    break;

                case 9:
                    System.out.println("\n--- CERRANDO SESIÓN ---");
                    biblioteca.cerrarSesion();
                    break;

                case 10:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;

                case 11:
                    System.out.println("buscar por autor");
                    String autor = scanner.nextLine();
                    biblioteca.buscarPorAutor(autor);


                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
        
        scanner.close();
    }
}