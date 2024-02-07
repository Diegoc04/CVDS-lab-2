package edu.eci.cvds.patterns.archetype;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String nombre = "";
        String apellido = "";
        
        if (args.length > 0) {  
            nombre = args[0];
            if (args.length > 1) {
                apellido = args[1];
            }
            System.out.println("Hola, " + nombre + (apellido.isEmpty() ? "" : " " + apellido) + "! Bienvenido a mi aplicacion creada con la herramienta Maven para el lab de CVDS.");
        } else {
            System.out.println("Hello world!");
        }
    }
}

