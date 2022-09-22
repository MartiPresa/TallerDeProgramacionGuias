package org.cerveceria;

import org.modelo.BeerHouse;
import org.negocio.negocio;
import org.vista.Ventana;

/**
 * Clase Lanzador : Es aquella que nos permite ejecutar la aplicación desde linea de comandos.
 * Recibe los argumentos externos e instancia la capa de negocio y dentro de esta inicializa la
 * capa de interface y del modelo.
 */

public class App
{
    private static org.negocio.negocio negocioCerveza = negocio.getInstance();

    public static void main(String[] args)
    {
        /**
         * Genero una instancia Singleton de la capa de negocio y la relaciona con
         * una instancia de la interface (Ventana) y con el modelo (BeerHouse),
         * las cuales son inicializadas
         */
        negocioCerveza.setVentana(new Ventana());
        negocioCerveza.setBeerHouse(new BeerHouse(10));
    }
}
