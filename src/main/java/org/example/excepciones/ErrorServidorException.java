package org.example.excepciones;

public class ErrorServidorException extends Exception {
    public ErrorServidorException(String mensaje) {
        super(mensaje);
    }
}