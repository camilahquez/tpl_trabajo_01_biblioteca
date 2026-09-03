package org.example;

public class Biblioteca {
    private  String idBiblioteca;
    private String nombre;
    private String direccion;

    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca='" + idBiblioteca + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public  Biblioteca(String nombre, String direccion, String idBiblioteca){
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
    }

}
