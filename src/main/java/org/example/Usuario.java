package org.example;

public class Usuario implements Autentificable {

       private String idUsuario;
       private String nombre;
       private int documento;
       private String clave;
       private int numeroPestramosDispoibles;

    public Usuario (String idUsuario,String nombre,int documento, String clave, int numeroPestramosDispoibles){
        this.idUsuario = idUsuario;
        this.nombre =nombre;
        this.documento= documento;
        this.clave= clave;
        this.numeroPestramosDispoibles = 5;


    }

    public String getIdUsuario(){
        return idUsuario;
    }

    public int getNumeroPestramosDispoibles(){
        return numeroPestramosDispoibles;
    }
    public void setNumeroPestramosDispoibles(int numeroPestramosDispoibles){
        this.numeroPestramosDispoibles = numeroPestramosDispoibles;

    }

    @Override
    public boolean ConfirmarClave(String clavePuesta) {
        return this.clave.equals(clavePuesta);
    }

    public String getNombre(){
        return nombre;
    }
    public int getDocumento(){
        return documento;
    }
}
