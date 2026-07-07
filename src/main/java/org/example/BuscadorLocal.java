package org.example;

import org.example.excepciones.ApiKeyInvalidaException;
import org.example.excepciones.LimiteConsultasExcedidoException;
import org.example.excepciones.ProductoNoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class BuscadorLocal extends BuscadorApi {

    public BuscadorLocal(String apiKey) throws ApiKeyInvalidaException {
        super(apiKey);
    }

    // correcion: Se agrega ApiKeyInvalidaException para respetar la interfaz IServicioBusqueda
    @Override
    public List<Producto> buscar(String termino) throws ProductoNoEncontradoException, LimiteConsultasExcedidoException, ApiKeyInvalidaException {
        registrarLogBusqueda(termino);
        return new ArrayList<>();
    }
}