package org.example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private  String idBiblioteca;
    private String nombre;
    private String direccion;
    private ArrayList<Material> listaMateriales = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
    public  Biblioteca(String nombre, String direccion, String idBiblioteca){
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public void agregarMaterial(Material material){
        listaMateriales.add(material);

    }
    public void agregarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);

    }
    public  Usuario buscarId(String idUsuario){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getIdUsuario().equals(idUsuario)){
                return usuario;
            }
        }
        System.out.println("el usuario no esta registrado");
        return null;
    }
    public  Usuario BuscarPorNombre(String nombre){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getNombre().equals(nombre)){
                return usuario;
            }
        }
        System.out.println("el usuario no esta registrado");
        return null;
    }
    public  Material BuscarIdMaterial(String idMaterial){
        for (Material material : listaMateriales){
            if (material.getIdMaterial().equals(idMaterial)){
                return material;
            }

        }
        System.out.println("el material no se encunetra en la biblioteca");
        return null;
    }

    public  Material buscarPorTitulo(String titulo){
        for (Material material : listaMateriales){
            if (material.getTitulo().equals(titulo)){
                return material;
            }
        }
        System.out.println("el material no se encunetra en la biblioteca");
        return null;
    }
    public  Material BuscarPorAutor(String autor){
        for (Material material : listaMateriales){
            if (material.getAutor().equals(autor)){
                return material;
            }
        }
        System.out.println("no hay material en la biblioteca de este autor");
        return null;
    }
    public int buscarPrestamosDisponibles(String idUsuario){
        int numeroPrestamosDisponibles;
        for (Usuario usuario : listaUsuarios){
            if (usuario.getIdUsuario().equals(idUsuario)){
                numeroPrestamosDisponibles = usuario.getNumeroPestramosDispoibles();
                return numeroPrestamosDisponibles;
            }
        }
        System.out.println("el usuario no fue encontrado, por lo tanto no tine prestamos disponibles");
        return 0;
    }
    public boolean verificarDisponibilidad(String titulo) {
        Material material = buscarPorTitulo(titulo);

        if (material == null) {
            return false;
        }

        if (material instanceof Prestable) {
            Prestable prestable = (Prestable) material;

            if (prestable.estaDisponible()) {
                System.out.println("El material está disponible.");
                return true;
            } else {
                System.out.println("El material no está disponible.");
                return false;
            }
        } else {
            System.out.println("Este material no se puede prestar.");
            return false;
        }
    }


    public void Prestar(String idUsuario, String titulo, LocalDate fechaPrestamo){
        int numeroPrestamosDisponibles;
        boolean disponibilidadMaterial;
        numeroPrestamosDisponibles = buscarPrestamosDisponibles(idUsuario);
        disponibilidadMaterial = verificarDisponibilidad(titulo);
        Usuario usuario = buscarId(idUsuario);
        Material material = buscarPorTitulo(titulo);


        if (numeroPrestamosDisponibles > 0 && disponibilidadMaterial){
            Prestamo prestamo = new Prestamo(usuario, material,fechaPrestamo);
            listaPrestamos.add(prestamo);
            usuario.setNumeroPestramosDispoibles(numeroPrestamosDisponibles - 1);
            if (material instanceof Prestable) {
                Prestable prestable = (Prestable) material;
                prestable.prestado();
            }

            System.out.println("el material fue prestado");
        }
        else{
            System.out.println("no se puede prestra el matrial");
        }

    }
    public Prestamo buscarPrestamo(String idUsuario, String titulo){
        Usuario usuario = buscarId(idUsuario);
        Material material = buscarPorTitulo(titulo);


        if (usuario == null || material == null) {
            return null;
        }

        for (Prestamo prestamo : listaPrestamos) {

            if (prestamo.getUsuario().equals(usuario)
                    && prestamo.getMaterial().equals(material) && prestamo.getFechaEntrega() == null) {

                return prestamo;
            }

        }
        System.out.println("el materia ya fue devuelto");
        return null;
    }
    public void devolver(String idUsuario, String titulo,LocalDate fechaEntrega){
        Prestamo prestamo = buscarPrestamo(idUsuario, titulo);
        if (prestamo == null){
            System.out.println("no se encontro el prestamo");
            return;
        }
        Material material = prestamo.getMaterial();

        if (material instanceof Prestable) {
            Prestable prestable = (Prestable) material;
            prestable.devuelto();
        }
        Usuario usuario = prestamo.getUsuario();
        usuario.setNumeroPestramosDispoibles(usuario.getNumeroPestramosDispoibles() + 1)
        prestamo.setFechaEntrega(fechaEntrega);
        System.out.println("se devolvio el material");

    }
    public void registrar(String idMaterial, String titulo,String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion,int cantidadDisponible){
        Libro libro = new Libro(idMaterial,  titulo, autor,  editorial,fechaPublicacion, idioma,  genero,  numeroEdicion, cantidadDisponible);
        agregarMaterial(libro);
    }
    public void registrar(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String periodicidad, String volumen, String numero, int cantidadDisponible){
        Revista revista = new Revista(idMaterial,  titulo,  autor,  editorial,  fechaPublicacion,  idioma,  periodicidad,  volumen,  numero,  cantidadDisponible);
        agregarMaterial(revista);
    }
    public void registrarLibroDigital(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion, String linkDescarga,int cantidadDescargas){
        LibroDigital libroDigital = new LibroDigital(idMaterial,  titulo, autor, editorial,  fechaPublicacion,idioma, genero,numeroEdicion, linkDescarga, cantidadDescargas);
        agregarMaterial(libroDigital);
    }
    public void registrarUsuario(String idUsuario,String nombre,int documento, String clave, int numeroPestramosDispoibles){}

}




