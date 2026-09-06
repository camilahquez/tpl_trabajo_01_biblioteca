package org.example;

import java.time.LocalDate;

public abstract class Material {
    private static int CantidadCreados=0;
    protected String idMaterial;
    protected String titulo;
    protected String editorial;
    protected LocalDate fechaPublicaion;
    protected String idioma;

    public Material(String idMaterial,String titulo, String editorial, LocalDate fechaPublicacion, String idioma){
        this.idMaterial = idMaterial;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicaion = fechaPublicacion;
        this.idioma = idioma;
        CantidadCreados++;
    }

    public abstract String getTipo();

    public String getIdMaterial(){
        return idMaterial;
    }
    public String getTitulo(){
        return titulo;
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

    public static int getCantidadCreados (){
        return CantidadCreados;
    }

    public void MostrarInformacion() {
        System.out.println("titulo:" + titulo);
        System.out.println("ID del material:" + idMaterial);
        System.out.println("editorial:" + editorial);
        System.out.println("fecha de publicación:" + fechaPublicaion);
        System.out.println("idioma:" + idioma);
    }
}
