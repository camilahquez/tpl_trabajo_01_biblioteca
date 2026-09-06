package org.example;

public class Usuario implements Autentificable {

       private String nombre;
       private int documento;
       private String clave;

    public Usuario (String nombre,int documento, String clave){
        this.nombre =nombre;
        this.documento= documento;
        this.clave= clave;
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
