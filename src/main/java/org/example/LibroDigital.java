package org.example;

import java.time.LocalDate;
import java.util.Date;

public class LibroDigital extends Material implements Descargable {
    private String genero;
    private  String numeroEdicion;
    private String linkDescarga;

    private String autor;
    private double tamanoArchivo;
    private int cantidadDescargas;

    public LibroDigital(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion, String linkDescarga, double tamanoArchivo){
        super(idMaterial,titulo,  editorial, fechaPublicacion, idioma);
        this.autor = autor;
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;
        this.linkDescarga = linkDescarga;
        this.tamanoArchivo = tamanoArchivo;
        this.cantidadDescargas = 0;

    }
    public String getAutor(){
        return autor;
    }
    public LocalDate getFechaPublicacion(){
        return fechaPublicacion;
    }
    public void descargar() {
        System.out.println("Iniciando descarga de: " + getTitulo());
        for (int i = 0; i <= 100; i += 20) {
            System.out.println("Descargando... " + i + "%");
        }
        System.out.println("Descarga completada.");
    }
    @Override
    public String Enlace() {
    return linkDescarga;
}

    @Override
    public void descargas() {
        cantidadDescargas++;
    }

    @Override
    public int totalDescargas() {
        return cantidadDescargas;
    }

    @Override
    public String getTipo() {
        return "Libro Digital";
    }
    @Override
    public String toString() {
        return "Libro Digital {" +
                "ID: " + getIdMaterial() +
                ", Título: " + getTitulo() +
                ", Autor: " + autor +
                ", Editorial: " + getEditorial() +
                ", Fecha de publicación: " + getFechaPublicacion() +
                ", Idioma: " + getIdioma() +
                ", Género: " + genero +
                ", Número de edición: " + numeroEdicion +
                ", Enlace de descarga: " + linkDescarga +
                ", Tamaño del archivo: " + tamanoArchivo +
                ", Cantidad de descargas: " + cantidadDescargas +
                '}';
    }
}
