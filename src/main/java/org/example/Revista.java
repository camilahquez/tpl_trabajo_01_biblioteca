package org.example;

import java.util.Date;

public class Revista extends Material {
    private String periodicidad;
    private String volumen;
    private  String numero;

    public  Revista(String idMaterial, String nombre, String tipo, String autor, String editorial, Date fechaPublicacion, String idioma, int cantidadDisponible, String estado, String periodicidad, String volumen, String numero){
        super(idMaterial,nombre, tipo, autor, editorial, fechaPublicacion, idioma, cantidadDisponible, estado);
        this.periodicidad = periodicidad;
        this.volumen = volumen;
        this.numero = numero;
        
    }

}
