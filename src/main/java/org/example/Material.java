package org.example;

import java.time.LocalDate;

public abstract class Material {
    private String idMaterial;
    private String titulo;
    private  String autor;
    private String editorial;
    private LocalDate fechaPublicaion;
    private String idioma;

    public Material(String idMaterial,String nombre, String autor, String editorial, LocalDate fechaPublicacion, String idioma){
        this.idMaterial = idMaterial;
        this.titulo = nombre;

        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicaion = fechaPublicacion;
        this.idioma = idioma;

    }
    public String getIdMaterial(){
        return idMaterial;
    }
    public String getTitulo(){
        return titulo;
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
