package org.example;

import java.time.LocalDate;
import java.util.Date;

public class LibroDigital extends Material {
    private String genero;
    private  String numeroEdicion;
    private String linkDescarga;

    public LibroDigital(String idMaterial, String nombre, String tipo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion, String linkDescarga){
        super(idMaterial,nombre, tipo, autor, editorial, fechaPublicacion, idioma);
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;
        this.linkDescarga = linkDescarga;

    }

}
