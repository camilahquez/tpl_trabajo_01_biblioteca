# Sistema de Gestión de Biblioteca

Este proyecto es una aplicación de consola desarrollada en Java para gestionar el inventario, los usuarios y los préstamos de una biblioteca. Fue construido para el curso de Técnicas de Programación, aplicando los pilares fundamentales de la Programación Orientada a Objetos (POO).

## Características Principales

* **Gestión de Materiales:** Registro y búsqueda de diferentes tipos de recursos (Libros físicos, Libros Digitales y Revistas).
* **Gestión de Usuarios:** Registro de usuarios con control de cupos para préstamos.
* **Autenticación:** Sistema de verificación de credenciales implementado a través de la interfaz `Autentificable`.
* **Sistema de Préstamos y Devoluciones:** 
  * Validación de disponibilidad del material y cupos activos por usuario.
  * Actualización automática del número de préstamos disponibles por usuario.
  * Distinción de comportamientos entre materiales físicos (sujetos a devolución) y digitales.

## Arquitectura y Diseño (POO)

* **Herencia:** Clase base abstracta `Material` de la cual heredan entidades específicas (`Libro`, `LibroDigital` y `Revista`).
* **Polimorfismo e Interfaces:** 
  * `Prestable`: Implementada por materiales físicos que requieren devolución e inventario.
  * `Descargable`: Implementada por materiales digitales.
  * `Autentificable`: Define el contrato para la verificación de claves de usuario.
* **Encapsulamiento:** Protección del estado interno de los objetos mediante modificadores de acceso (`private`/`protected`) y métodos *getter/setter*.

## Estructura del Proyecto

El código fuente se encuentra bajo el paquete `org.example`:

```text
src/main/java/org/example/
├── Autentificable.java   # Interfaz para autenticación de usuarios
├── Biblioteca.java       # Controlador principal (gestión de listas y lógica de negocio)
├── Descargable.java      # Interfaz para materiales digitales
├── Libro.java            # Clase para libros físicos (Hereda de Material, implementa Prestable)
├── LibroDigital.java     # Clase para libros digitales (Hereda de Material, implementa Descargable)
├── Main.java             # Punto de entrada de la aplicación y menú interactivo de consola
├── Material.java         # Clase base abstracta
├── Prestable.java        # Interfaz para materiales sujetos a devolución
├── Prestamo.java         # Entidad que relaciona un Usuario, un Material y las fechas
├── Pruebas.java          # Clase de pruebas integrales para demostración de rúbrica
├── Revista.java          # Clase para revistas
└── Usuario.java          # Entidad para los usuarios de la biblioteca
```

Tecnologías Utilizadas

   Lenguaje: Java

   Gestión de Proyecto: Apache Maven (pom.xml)

   Control de Versiones: Git y GitHub

   Entorno de Desarrollo: IntelliJ IDEA / Visual Studio Code /


Instrucciones de Compilación y Ejecución

   Clonar el repositorio:

    git clone [https://github.com/camilahquez/tpl_trabajo_01_biblioteca.git](https://github.com/camilahquez/tpl_trabajo_01_biblioteca.git)
    cd tpl_trabajo_01_biblioteca

   Ejecutar desde el IDE:

   Abre el proyecto en tu IDE preferido.

   Menú interactivo principal: Ejecuta src/main/java/org/example/Main.java.

   Demostración de pruebas de laboratorio: Ejecuta src/main/java/org/example/Pruebas.java.

Ejecutar desde terminal (Maven):

mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.Main"


Autores

Proyecto desarrollado colaborativamente por:

   Camila

   Valeria

   Josue Daniel
