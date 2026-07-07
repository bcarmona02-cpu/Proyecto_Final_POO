package org.example;

import java.text.NumberFormat;
import java.util.Locale;

public class Producto {
    private final String nombre;
    private final double precio;
    private final String tienda;
    private final String linkCompra;
    private final String imagenUrl;

    public Producto(String nombre, double precio, String tienda, String linkCompra, String imagenUrl) {
        this.nombre = nombre;
        this.precio = precio;
        this.tienda = tienda;
        this.linkCompra = linkCompra;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getTienda() { return tienda; }
    public String getLinkCompra() { return linkCompra; }
    public String getImagenUrl() { return imagenUrl; }

    public String getPrecioFormateado() {
        // Creamos un formato usando la configuración de Chile para los puntos de miles
        NumberFormat formatoChile = NumberFormat.getInstance(new Locale("es", "CL"));
        return "$" + formatoChile.format(this.precio) + " CLP";
    }

    @Override
    public String toString() {
        return "📦 " + nombre + "\n" +
                "   💵 Precio: " + getPrecioFormateado() + " | 🏬 Tienda: " + tienda + "\n" +
                "   🔗 Enlace: " + linkCompra + "\n" +
                "   🖼️ Imagen: " + imagenUrl;
    }
}