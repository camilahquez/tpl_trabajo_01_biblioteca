package org.example;

public class Usuario implements Autentificable {

    private String idUsuario;
    private String nombre;
    private int documento;
    private String clave;
    private int numeroPrestamosDisponibles;

    // Constructor sin documento
    public Usuario(String idUsuario, String nombre, String clave, int numeroPrestamosDisponibles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.numeroPrestamosDisponibles = numeroPrestamosDisponibles;
    }

    // Constructor con documento (por si lo necesitas)
    public Usuario(String idUsuario, String nombre, int documento, String clave, int numeroPrestamosDisponibles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.documento = documento;
        this.clave = clave;
        this.numeroPrestamosDisponibles = numeroPrestamosDisponibles;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNumeroPrestamosDisponibles() {
        return numeroPrestamosDisponibles;
    }

    public void setNumeroPrestamosDisponibles(int numeroPrestamosDisponibles) {
        this.numeroPrestamosDisponibles = numeroPrestamosDisponibles;
    }

    @Override
    public boolean ConfirmarClave(String clavePuesta) {
        return this.clave != null && this.clave.equals(clavePuesta);
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "ID: " + idUsuario +
                ", Nombre: " + nombre +
                ", Documento: " + documento +
                ", Préstamos disponibles: " + numeroPrestamosDisponibles +
                '}';
    }
}