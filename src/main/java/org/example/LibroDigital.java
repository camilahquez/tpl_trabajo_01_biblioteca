package org.example;

import java.time.LocalDate;
import java.util.Date;

public class LibroDigital extends Material implements Descargable {
    private String genero;
    private  String numeroEdicion;
    private String linkDescarga;
    private int cantidadDescargas;

    public LibroDigital(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion, String linkDescarga,int cantidadDescargas){
        super(idMaterial,titulo, autor, editorial, fechaPublicacion, idioma);
        this.genero = genero;
        this.numeroEdicion = numeroEdicion;
        this.linkDescarga = linkDescarga;
        this.cantidadDescargas =cantidadDescargas;

    }
    @Override
    public String Enlace() {
    return linkDescarga;
}

    @Override
    public void descargas() {
        cantidadDescargas++;
    }

    @Override
    public int totalDescargas() {
        return cantidadDescargas;
    }
}
