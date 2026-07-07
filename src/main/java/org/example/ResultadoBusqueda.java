package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultadoBusqueda {

    private final String terminoBuscado;
    private final List<Producto> listaProductos;

    public ResultadoBusqueda(String terminoBuscado, List<Producto> listaProductos) {
        this.terminoBuscado = terminoBuscado;
        this.listaProductos = listaProductos != null ? listaProductos : new ArrayList<>();
    }

    //Prog.Funcional con .filter() y .collect()
    public List<Producto> filtrarPorTienda(String nombreTienda) {
        return listaProductos.stream()
                .filter(prod -> prod.getTienda().equalsIgnoreCase(nombreTienda))
                .collect(Collectors.toList());
    }

    // Métodos extra funcionales para sumar puntos de exigencia:
    public double obtenerPrecioPromedio() {
        return listaProductos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
    }

    public String getTerminoBuscado() { return terminoBuscado; }

    public List<Producto> getListaProductos() { return listaProductos; }
}