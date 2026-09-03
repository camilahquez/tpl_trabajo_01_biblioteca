package org.example;

public class BibliotecaApp {
    private Biblioteca biblioteca;

    public BibliotecaApp() {
        this.biblioteca = new Biblioteca("Biblioteca Central", "Campus Principal", "001");
    }

    public void iniciar() {
        System.out.println("=== Sistema de Biblioteca Iniciado ===");
        System.out.println("Biblioteca: " + biblioteca);
    }
}
