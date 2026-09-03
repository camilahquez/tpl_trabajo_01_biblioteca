package org.example;

import java.util.Date;

public class LibroDigital extends Material {
    private String genero;
    private  String numeroEdicion;
    private String linkDescarga;

    public LibroDigital(String idMaterial, String nombre, String tipo, String autor, String editorial, Date fechaPublicacion, String idioma, int cantidadDisponible, String estado, String genero, String numeroEdicion, String linkDescarga){
        super(idMaterial,nombre, tipo, autor, editorial, fechaPublicacion, idioma, cantidadDisponible, estado);
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;
        this.linkDescarga = linkDescarga;

    }

}
