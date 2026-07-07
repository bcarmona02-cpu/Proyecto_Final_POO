package org.example;

import org.example.excepciones.*;
import java.util.ArrayList;
import java.util.List;

public class BuscadorLocal extends BuscadorApi {

    public BuscadorLocal(String apiKey) throws ApiKeyInvalidaException {
        super(apiKey);
    }

    @Override
    public List<Producto> buscar(String termino) throws
            ProductoNoEncontradoException,
            LimiteConsultasExcedidoException,
            ApiKeyInvalidaException,
            AccesoDenegadoException,
            ErrorServidorException {

        registrarLogBusqueda(termino);
        return new ArrayList<>(); // Devuelve lista vacía simulada
    }
}