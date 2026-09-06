package org.example;

import java.time.LocalDate;

public class Prestamo {
    private Usuario usuario;
    private Material materia;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaEntrega;

    public Prestamo(Usuario usuario, Material materia, LocalDate fechaPrestamo){
        this.usuario = usuario;
        this.materia = materia;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaPrestamo.plusDays(15);
        this.fechaEntrega = null;
    }
}
