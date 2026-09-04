package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Material {
    private String idMaterial;
    private String nombre;
    private String tipo;
    private  String autor;
    private String editorial;
    private LocalDate fechaPublicaion;
    private String idioma;

    public Material(String idMaterial,String nombre, String tipo, String autor, String editorial, LocalDate fechaPublicacion, String idioma){
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.tipo = tipo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicaion = fechaPublicacion;
        this.idioma = idioma;

    }
    public String getIdMaterial(){
        return idMaterial;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public String getAutor(){
        return autor;
    }
    public String getEditorial(){
        return editorial;
    }
    public LocalDate getFechaPublicaion(){
        return fechaPublicaion;
    }
    public String getIdioma(){
        return idioma;
    }

}
