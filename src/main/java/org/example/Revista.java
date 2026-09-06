package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Revista extends Material implements Prestable {
    private String periodicidad;
    private String volumen;
    private  String numero;
    private int cantidadDisponible;

    public  Revista(String idMaterial, String titulo, String editorial, LocalDate fechaPublicacion, String idioma, String periodicidad, String volumen, String numero, int cantidadDisponible){
        super(idMaterial,titulo, editorial, fechaPublicacion, idioma);
        this.periodicidad = periodicidad;
        this.volumen = volumen;
        this.numero = numero;
        this.cantidadDisponible = cantidadDisponible;
    }
    public LocalDate getFechaPublicacion(){
        return fechaPublicaion;
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
        cantidadDisponible++;
    }

    @Override
    public boolean estaDisponible() {
        return (cantidadDisponible>0);
    }

    @Override
    public String getTipo() {
        return "Revisata";
    }
    @Override
    public String toString() {
        return "Revista {" +
                "ID: " + getIdMaterial() +
                ", Título: " + getTitulo() +
                ", Editorial: " + getEditorial() +
                ", Fecha de publicación: " + getFechaPublicacion() +
                ", Idioma: " + getIdioma() +
                ", Periodicidad: " + periodicidad +
                ", Volumen: " + volumen +
                ", Número: " + numero +
                ", Cantidad disponible: " + cantidadDisponible +
                '}';
    }
}
