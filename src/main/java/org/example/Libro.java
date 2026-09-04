package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Libro extends Material {
    private String genero;
    private  String numeroEdicion;
    private int cantidadDisponible;
    private  String estado;

    public Libro(String idMaterial, String nombre, String tipo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, int cantidadDisponible, String estado, String genero, String numeroEdicion){
        super(idMaterial,nombre, tipo, autor, editorial, fechaPublicacion, idioma);
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;
        this.cantidadDisponible = cantidadDisponible;
        this.estado = estado;
    }

}
