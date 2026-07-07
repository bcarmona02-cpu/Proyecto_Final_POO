package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.excepciones.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("  [CapySearch]  ");
        System.out.println("=== CONSULTANDO... ===");

        Dotenv dotenv = Dotenv.load();
        String apiKeySecret = dotenv.get("SERP_API_KEY");

        try {
            BuscadorApi buscador = new BuscadorShopping(apiKeySecret);
            // Escribir aquí el producto que deseas buscar
            String articuloBuscar = "";

            System.out.println("Buscando '" + articuloBuscar + "'...");
            List<Producto> productosReales = buscador.buscar(articuloBuscar);

            System.out.println("\n RESULTADOS EN TIEMPO REAL ");
            System.out.println("----------------------------------------------------------------");
            for (Producto p : productosReales) {
                System.out.println(p);
                System.out.println("----------------------------------------------------------------");
            }

        } catch (ApiKeyInvalidaException e) {
            System.out.println("\n [Problema de Clave]: " + e.getMessage());
        } catch (ProductoNoEncontradoException e) {
            System.out.println("\n [Sin Resultados]: " + e.getMessage());
        } catch (LimiteConsultasExcedidoException e) {
            System.out.println("\n [Límite Alcanzado]: " + e.getMessage());
        } catch (AccesoDenegadoException e) {
            System.out.println("\n [Acceso Denegado]: " + e.getMessage());
        } catch (ErrorServidorException e) {
            System.out.println("\n [Error de Servidor]: " + e.getMessage());
        }
    }
}