package org.example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private String idBiblioteca;
    private String nombre;
    private String direccion;
    private ArrayList<Material> listaMateriales = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
    private Usuario usuarioLogueado;

    public Biblioteca(String nombre, String direccion, String idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void agregarMaterial(Material material) {
        listaMateriales.add(material);
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario buscarId(String idUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario BuscarPorNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public Material BuscarIdMaterial(String idMaterial) {
        for (Material material : listaMateriales) {
            if (material.getIdMaterial().equals(idMaterial)) {
                return material;
            }
        }
        return null;
    }

    public Material buscarPorTitulo(String titulo) {
        for (Material material : listaMateriales) {
            if (material.getTitulo().equals(titulo)) {
                return material;
            }
        }
        return null;
    }

    public ArrayList<Material> buscarPorAutor(String autor) {
        ArrayList<Material> resultado = new ArrayList<>();
        for (Material material : listaMateriales) {
            if (material.getAutor().equals(autor)){
                resultado.add(material);
            }
        }
        System.out.println(resultado);
        return resultado;
    }

    public int buscarPrestamosDisponibles(String idUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                return usuario.getNumeroPrestamosDisponibles();
            }
        }
        System.out.println("El usuario no fue encontrado, por lo tanto no tiene préstamos disponibles.");
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

    public void Prestar(String idUsuario, String titulo, LocalDate fechaPrestamo) {
        if (usuarioLogueado == null) {
            System.out.println("debe iniciar sesión primero");
            return;
        }
        if (!usuarioLogueado.getIdUsuario().equals(idUsuario)) {
            System.out.println("para pedir un  prestamo debe ser con tu usuario");
            return;
        }
        int numeroPrestamosDisponibles;
        boolean disponibilidadMaterial;
        numeroPrestamosDisponibles = buscarPrestamosDisponibles(idUsuario);
        disponibilidadMaterial = verificarDisponibilidad(titulo);
        Usuario usuario = buscarId(idUsuario);
        Material material = buscarPorTitulo(titulo);

        if (numeroPrestamosDisponibles > 0 && disponibilidadMaterial) {
            Prestamo prestamo = new Prestamo(usuario, material, fechaPrestamo);
            listaPrestamos.add(prestamo);
            usuario.setNumeroPrestamosDisponibles(numeroPrestamosDisponibles - 1);
            if (material instanceof Prestable) {
                Prestable prestable = (Prestable) material;
                prestable.prestado();
            }

            System.out.println("el material fue prestado");
        } else {
            System.out.println("no se puede prestra el matrial");
        }
    }

    public Prestamo buscarPrestamo(String idUsuario, String titulo) {
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
        System.out.println("el materia ya fue devuelto o no se encontro su prestamo");
        return null;
    }

    public void devolver(String idUsuario, String titulo, LocalDate fechaEntrega) {
        if (usuarioLogueado == null) {
            System.out.println("Debe iniciar sesión primero.");
            return;
        }

        if (!usuarioLogueado.getIdUsuario().equals(idUsuario)) {
            System.out.println("No puede devolver un préstamo de otro usuario.");
            return;
        }
        Prestamo prestamo = buscarPrestamo(idUsuario, titulo);
        if (prestamo == null) {
            System.out.println("no se encontro el prestamo");
            return;
        }
        Material material = prestamo.getMaterial();

        if (material instanceof Prestable) {
            Prestable prestable = (Prestable) material;
            prestable.devuelto();
        }
        Usuario usuario = prestamo.getUsuario();
        usuario.setNumeroPrestamosDisponibles(usuario.getNumeroPrestamosDisponibles() + 1);
        prestamo.setFechaEntrega(fechaEntrega);
        System.out.println("se devolvio el material");
    }

    public void registrar(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion, int cantidadDisponible) {
        Libro libro = new Libro(idMaterial, titulo, autor, editorial, fechaPublicacion, idioma, genero, numeroEdicion, cantidadDisponible);
        agregarMaterial(libro);
    }

    public void registrar(String idMaterial, String titulo, String editorial, LocalDate fechaPublicacion, String idioma, String periodicidad, String volumen, String numero, int cantidadDisponible) {
        Revista revista = new Revista(idMaterial, titulo, editorial, fechaPublicacion, idioma, periodicidad, volumen, numero, cantidadDisponible);
        agregarMaterial(revista);
    }

    public void registrar(String idMaterial, String titulo, String autor, String editorial, LocalDate fechaPublicacion, String idioma, String genero, String numeroEdicion, String linkDescarga, double tamanoArchivo) {
        LibroDigital libroDigital = new LibroDigital(idMaterial, titulo, autor, editorial, fechaPublicacion, idioma, genero, numeroEdicion, linkDescarga, tamanoArchivo);
        agregarMaterial(libroDigital);
    }

    public void registrarUsuario(String idUsuario, String nombre, String clave, int numeroPestramosDisponibles) {
        Usuario usuario = buscarId(idUsuario);
        if (usuario == null) {
            usuario = new Usuario(idUsuario, nombre, clave, numeroPestramosDisponibles);
            agregarUsuario(usuario);
        } else {
            System.out.println("idUsuario ya existe no se puede registrar");
        }
    }

    public boolean iniciarSesion(String idUsuario, String clave) {
        Usuario usuario = buscarId(idUsuario);

        if (usuario == null) {
            System.out.println("El usuario no existe.");
            return false;
        }

        Autentificable autentificable = usuario;

        if (autentificable.ConfirmarClave(clave)) {
            usuarioLogueado = usuario;
            System.out.println("Inicio de sesión exitoso.");
            return true;
        }

        System.out.println("Clave incorrecta.");
        return false;
    }

    public void cerrarSesion() {
        usuarioLogueado = null;
        System.out.println("Sesión cerrada correctamente.");
    }

    public void mostrasMateriales() {
        if (Material.getCantidadCreados() > 0) {
            for (Material material : listaMateriales) {
                System.out.println(material.getTipo());
                System.out.println(material);
            }
        } else {
            System.out.println("no hay materiales ingresdos");
        }
    }

    public void estaditicas() {
        System.out.println("el numero actual de materiales ingresados es " + Material.getCantidadCreados());
    }

    public void descargar(String titulo) {
        Material material = buscarPorTitulo(titulo);
        if (material == null) {
            return;
        }
        if (material instanceof Descargable) {
            Descargable descargable = (Descargable) material;
            System.out.println("Enlace de descarga: " + descargable.Enlace());
            descargable.descargar();
            descargable.descargas();
            System.out.println("Total de descargas: " + descargable.totalDescargas());
        } else {
            System.out.println("Este material no se puede descargar.");
        }
    }

    public void mostrarPrestamos() {
        if (listaMateriales.isEmpty()) {
            System.out.println("no se han hecho prestamos");
        } else {
            for (Prestamo prestamo : listaPrestamos) {
                System.out.println(prestamo);
            }
        }
    }
}