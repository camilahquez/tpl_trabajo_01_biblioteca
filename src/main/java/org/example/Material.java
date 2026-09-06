package org.example;

import java.time.LocalDate;

public abstract class Material {
    private static int CantidadCreados=0;

    protected String idMaterial;
    protected String titulo;
    protected String autor;
    protected String editorial;
    protected LocalDate fechaPublicaion;
    protected String idioma;

    public Material(String idMaterial,String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma){
        this.idMaterial = idMaterial;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicaion = fechaPublicacion;
        this.idioma = idioma;

        int i=CantidadCreados++;
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

    public static int getCantidadCreados (){
        return CantidadCreados;
    }

    public void MostrarInformacion() {
        System.out.println("titulo:" + titulo);
        System.out.println("ID del material:" + idMaterial);
        System.out.println("autor:" + autor);
        System.out.println("editorial:" + editorial);
        System.out.println("fecha de publicación:" + fechaPublicaion);
        System.out.println("idioma:" + idioma);
    }
}
