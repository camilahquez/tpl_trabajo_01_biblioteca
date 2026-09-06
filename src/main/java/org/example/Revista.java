package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Revista extends Material implements Prestable {
    private String periodicidad;
    private String volumen;
    private  String numero;
    private int cantidadDisponible;

    public  Revista(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String periodicidad, String volumen, String numero, int cantidadDisponible){
        super(idMaterial,titulo, autor, editorial, fechaPublicacion, idioma);
        this.periodicidad = periodicidad;
        this.volumen = volumen;
        this.numero = numero;
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
