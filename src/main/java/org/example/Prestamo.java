package org.example;

import java.time.LocalDate;

public class Prestamo {
    private Persona persona;
    private Material materia;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaEntrega;

    public Prestamo(Persona persona, Material materia, LocalDate fechaPrestamo){
        this.persona = persona;
        this.materia = materia;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaPrestamo.plusDays(15);
        this.fechaEntrega = null;
    }
}
