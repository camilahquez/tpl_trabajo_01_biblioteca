package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Biblioteca {
    private  String idBiblioteca;
    private String nombre;
    private String direccion;
    private ArrayList arrMateriales;
    private ArrayList arrPersonas;

    public  Biblioteca(String nombre, String direccion, String idBiblioteca){
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
    }

}
