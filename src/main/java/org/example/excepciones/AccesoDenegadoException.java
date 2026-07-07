package org.example.excepciones;

public class AccesoDenegadoException extends Exception {
    public AccesoDenegadoException(String mensaje) {
        super(mensaje);
    }
}