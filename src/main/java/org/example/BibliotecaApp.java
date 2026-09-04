package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private final Biblioteca biblioteca;
    private final Scanner scanner;
    private final List<Persona> listaPersonas;

    public BibliotecaApp() {
        this.biblioteca = new Biblioteca("Biblioteca Central", "Calle Principal #123", "LIB-001");
        this.scanner = new Scanner(System.in);
        this.listaPersonas = new ArrayList<>();
    }

    public void iniciar() {
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Mostrar información de la biblioteca");
            System.out.println("2. Registrar / Ver usuarios (Estudiante / Profesor)");
            System.out.println("3. Consultar materiales");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- DATOS DE LA BIBLIOTECA ---");
                        System.out.println(biblioteca);
                        break;
                    case 2:
                        gestionarUsuarios();
                        break;
                    case 3:
                        System.out.println("\n--- CATÁLOGO DE MATERIALES ---");
                        System.out.println("Catálogo en desarrollo...");
                        break;
                    case 4:
                        System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("\nPor favor, ingrese un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }

        } while (opcion != 4);
    }

    private void gestionarUsuarios() {
        int opcionUsuario = 0;
        do {
            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Profesor");
            System.out.println("3. Listar todos los usuarios");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elija una opción: ");

            if (scanner.hasNextInt()) {
                opcionUsuario = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcionUsuario) {
                    case 1:
                        System.out.print("Ingrese ID del estudiante: ");
                        String idEst = scanner.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String nomEst = scanner.nextLine();
                        System.out.print("Ingrese carrera: ");
                        String carrera = scanner.nextLine();

                        Estudiante estudiante = new Estudiante(idEst, nomEst, carrera);
                        listaPersonas.add(estudiante);
                        System.out.println("¡Estudiante registrado con éxito!");
                        break;

                    case 2:
                        System.out.print("Ingrese ID del profesor: ");
                        String idProf = scanner.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String nomProf = scanner.nextLine();
                        System.out.print("Ingrese departamento: ");
                        String departamento = scanner.nextLine();

                        Profesor profesor = new Profesor(idProf, nomProf, departamento);
                        listaPersonas.add(profesor);
                        System.out.println("¡Profesor registrado con éxito!");
                        break;

                    case 3:
                        System.out.println("\n--- LISTA DE USUARIOS REGISTRADOS ---");
                        if (listaPersonas.isEmpty()) {
                            System.out.println("No hay usuarios registrados.");
                        } else {
                            for (Persona p : listaPersonas) {
                                System.out.println("- ID: " + p.getId() + ", Nombre: " + p.getNombre());
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Volviendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
        } while (opcionUsuario != 4);
    }
}