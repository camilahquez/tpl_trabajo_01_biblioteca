package org.example;

public class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String id, String nombre, String carrera) {
        super(id, nombre);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    // Regla de negocio: Los estudiantes pueden pedir materiales por 10 días
    public int obtenerDiasPrestamo() {
        return 10;
    }
}
