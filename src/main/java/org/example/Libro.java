package org.example;

import java.util.Date;

public class Libro extends Material {
    private String genero;
    private  String numeroEdicion;

    public Libro(String idMaterial, String nombre, String tipo, String autor, String editorial, Date fechaPublicacion, String idioma, int cantidadDisponible, String estado, String genero, String numeroEdicion){
        super(idMaterial,nombre, tipo, autor, editorial, fechaPublicacion, idioma, cantidadDisponible, estado);
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;

    }

}
