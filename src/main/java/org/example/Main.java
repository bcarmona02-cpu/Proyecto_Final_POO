package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.excepciones.ApiKeyInvalidaException;
import org.example.excepciones.LimiteConsultasExcedidoException;
import org.example.excepciones.ProductoNoEncontradoException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONSULTANDO...  ===");

        // Carga la API Key desde el archivo .env
        Dotenv dotenv = Dotenv.load();
        String apiKeySecret = dotenv.get("SERP_API_KEY");

        try {
            BuscadorApi buscador = new BuscadorShopping(apiKeySecret);

            // Escribir aquí el producto que se quiera buscar
            String articuloBuscar = "";
            List<Producto> productosReales = buscador.buscar(articuloBuscar);

            // Pasamos los objetos de la API a la clase matemática de tu diagrama
            ResultadoBusqueda analisis = new ResultadoBusqueda(articuloBuscar, productosReales);

            System.out.println("\n=== PRODUCTOS EN TIEMPO REAL ===");
            for (Producto p : productosReales) {
                System.out.println(p);
                System.out.println("----------------------------------------------------------------");
            }

            System.out.println("\n=== ANÁLISIS DE PRECIOS ===");
            Producto masEconomico = analisis.obtenerMasBarato();
            System.out.println("🏆 EL PRODUCTO MÁS BARATO ES:");
            System.out.println(masEconomico);

        } catch (ApiKeyInvalidaException e) {
            System.out.println("\n [Excepción de Acceso]: " + e.getMessage());
        } catch (ProductoNoEncontradoException e) {
            System.out.println("\n️ [Excepción de Negocio]: " + e.getMessage());
        } catch (LimiteConsultasExcedidoException e) {
            System.out.println("\n [Excepción de Servidor]: " + e.getMessage());
        }
    }
}