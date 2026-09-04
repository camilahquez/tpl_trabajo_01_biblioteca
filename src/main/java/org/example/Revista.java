package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Revista extends Material {
    private String periodicidad;
    private String volumen;
    private  String numero;
    private int cantidadDisponible;
    private  String estado;

    public  Revista(String idMaterial, String nombre, String tipo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, int cantidadDisponible, String estado, String periodicidad, String volumen, String numero){
        super(idMaterial,nombre, tipo, autor, editorial, fechaPublicacion, idioma);
        this.periodicidad = periodicidad;
        this.volumen = volumen;
        this.numero = numero;
        this.cantidadDisponible = cantidadDisponible;
        this.estado = estado;
        
    }

}
