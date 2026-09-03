package org.example;

public class Bibliotecario extends Persona {
    private String turno;

    public Bibliotecario(String id, String nombre, String turno) {
        super(id, nombre);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }
}
