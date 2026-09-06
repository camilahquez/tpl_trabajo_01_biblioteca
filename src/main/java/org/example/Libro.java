package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Libro extends Material implements Prestable {
    private String genero;
    private  String numeroEdicion;
    private int cantidadDisponible;

    public Libro(String idMaterial, String titulo,String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion,int cantidadDisponible){
        super(idMaterial,titulo, autor, editorial, fechaPublicacion, idioma);
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;
        this.cantidadDisponible = cantidadDisponible;

    }
    public int getCantidadDisponible(){
        return cantidadDisponible;
    }

    @Override
    public void prestado() {
        if (cantidadDisponible>0) cantidadDisponible--;
    }

    @Override
    public void devuelto() {
        if(cantidadDisponible>0) cantidadDisponible++;
    }

    @Override
    public boolean estaDisponible() {
        return (cantidadDisponible>0);
    }
}

