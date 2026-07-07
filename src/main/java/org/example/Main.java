package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.excepciones.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONSULTANDO...  ===");

        Dotenv dotenv = Dotenv.load();
        String apiKeySecret = dotenv.get("SERP_API_KEY");

        try {
            BuscadorApi buscador = new BuscadorShopping(apiKeySecret);
            //Escribir en el String lo que se requiera buscar
            String articuloBuscar = "Orejeras de Gato";
            List<Producto> productosReales = buscador.buscar(articuloBuscar);

            ResultadoBusqueda analisis = new ResultadoBusqueda(articuloBuscar, productosReales);

            System.out.println("\n PRODUCTOS EN TIEMPO REAL");
            for (Producto p : productosReales) {
                System.out.println(p);
                System.out.println("----------------------------------------------------------------");
            }

            System.out.println("\n ANÁLISIS DE PRECIOS ");
            Producto masEconomico = analisis.obtenerMasBarato();
            System.out.println(" EL PRODUCTO MÁS BARATO ES:");
            System.out.println(masEconomico);

        } catch (ApiKeyInvalidaException e) {
            System.out.println("\n [Problema de Clave]: " + e.getMessage());
        } catch (ProductoNoEncontradoException e) {
            System.out.println("\n️ [Sin Resultados]: " + e.getMessage());
        } catch (LimiteConsultasExcedidoException e) {
            System.out.println("\n [Límite Alcanzado]: " + e.getMessage());
        } catch (AccesoDenegadoException e) {
            System.out.println("\n [Acceso Denegado]: " + e.getMessage());
        } catch (ErrorServidorException e) {
            System.out.println("\n [Error de Servidor]: " + e.getMessage());
        }
    }
}