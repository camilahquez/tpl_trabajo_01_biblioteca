package org.example;

public class Profesor extends Persona {
    private String departamento;

    public Profesor(String id, String nombre, String departamento) {
        super(id, nombre);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    // Regla de negocio: Los profesores pueden pedir materiales por 30 días
    public int obtenerDiasPrestamo() {
        return 30;
    }
}