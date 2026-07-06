package org.example;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBusqueda {
    private String terminoBuscado;
    private List<Producto> listaProductos;

    // Constructor
    public ResultadoBusqueda(String terminoBuscado, List<Producto> listaProductos) {
        this.terminoBuscado = terminoBuscado;
        this.listaProductos = listaProductos != null ? listaProductos : new ArrayList<>();
    }

    // Metodo para obtener el producto con el menor precio
    public Producto obtenerMasBarato() {
        if (listaProductos.isEmpty()) {
            return null;
        }

        Producto masBarato = listaProductos.get(0);
        for (Producto prod : listaProductos) {
            if (prod.getPrecio() < masBarato.getPrecio()) {
                masBarato = prod;
            }
        }
        return masBarato;
    }

    // Metodo para filtrar la lista por el nombre de una tienda específica
    public List<Producto> filtrarPorTienda(String nombreTienda) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto prod : listaProductos) {
            // Comparamos ignorando mayúsculas/minúsculas para evitar errores
            if (prod.getTienda().equalsIgnoreCase(nombreTienda)) {
                filtrados.add(prod);
            }
        }
        return filtrados;
    }

    // Getters y Setters necesarios
    public String getTerminoBuscado() {
        return terminoBuscado;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}