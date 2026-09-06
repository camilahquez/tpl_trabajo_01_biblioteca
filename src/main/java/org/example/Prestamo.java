package org.example;

import java.time.LocalDate;

public class Prestamo {

    private Usuario usuario;
    private Material material;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaEntrega;

    public Prestamo(Usuario usuario, Material material, LocalDate fechaPrestamo){
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaPrestamo.plusDays(15);
        this.fechaEntrega = null;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public Material getMaterial(){
        return material;
    }
    public LocalDate getFechaEntrega(){
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    @Override
    public String toString() {
        return "Prestamo {" +
                "Usuario: " + usuario.getNombre() +
                ", ID Usuario: " + usuario.getIdUsuario() +
                ", Material: " + material.getTitulo() +
                ", ID Material: " + material.getIdMaterial() +
                ", Fecha de préstamo: " + fechaPrestamo +
                ", Fecha de entrega: " + fechaEntrega +
                '}';
    }
}

