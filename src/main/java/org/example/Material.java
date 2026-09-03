package org.example;

import java.util.Date;

public class Material {
    private String idMaterial;
    private String nombre;
    private String tipo;
    private  String autor;
    private String editorial;
    private Date fechaPublicaion;
    private String idioma;
    private int cantidadDisponible;
    private  String estado;
    public Material(String idMaterial,String nombre, String tipo, String autor, String editorial, Date fechaPublicacion, String idioma, int cantidadDisponible,String estado){
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.tipo = tipo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicaion = fechaPublicacion;
        this.idioma = idioma;
        this.cantidadDisponible = cantidadDisponible;
        this.estado = estado;
    }

}
