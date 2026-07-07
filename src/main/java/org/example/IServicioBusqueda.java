package org.example;

import org.example.excepciones.*;

import java.util.List;

public interface IServicioBusqueda {
    List<Producto> buscar(String termino) throws ProductoNoEncontradoException, LimiteConsultasExcedidoException, ApiKeyInvalidaException, AccesoDenegadoException, ErrorServidorException;}