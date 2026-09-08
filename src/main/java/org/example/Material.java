package org.example;

import java.time.LocalDate;

public abstract class Material {
    private static int CantidadCreados=0;
    protected String idMaterial;
    protected String titulo;
    protected String editorial;
    protected LocalDate fechaPublicacion;
    protected String idioma;

    public Material(String idMaterial,String titulo, String editorial, LocalDate fechaPublicacion, String idioma){
        this.idMaterial = idMaterial;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.idioma = idioma;
        CantidadCreados++;
    }
public Material(String idMaterial,String titulo, String editorial, String idioma){
    this.idMaterial = idMaterial;
    this.titulo = titulo;
    this.editorial = editorial;
    this.fechaPublicacion = null;
    this.idioma = idioma;
    CantidadCreados++;
}

    public abstract String getTipo();
    public  abstract String getAutor();

    public String getIdMaterial(){
        return idMaterial;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getEditorial(){
        return editorial;
    }
    public LocalDate getFechaPublicacion(){
        return fechaPublicacion;
    }
    public String getIdioma(){
        return idioma;
    }

    public static int getCantidadCreados (){
        return CantidadCreados;
    }

    public void MostrarInformacion() {
        System.out.println("titulo:" + titulo);
        System.out.println("ID del material:" + idMaterial);
        System.out.println("editorial:" + editorial);
        System.out.println("fecha de publicación:" + fechaPublicacion);
        System.out.println("idioma:" + idioma);
    }
}
