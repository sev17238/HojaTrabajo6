
package Cartas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *  Clase que representa a una Carta.
 * @author Ana Lucía Hernández (17138) Diego Sevilla (17238)
 */
public class Carta {
    
    private String tipoCarta;
    private int cantCartas; //si el usuario ingresa mas de una carta con el mismo nombre y valor, se le agregara al contador en lugar de repetirlas
    /**
     * COnstructor primario de carta que le agrega un tipo.
     * @param tipo el tipo de la carta
     */
    public Carta (String tipo)
    {
        tipoCarta = tipo;
        cantCartas = 1;
    }
    /**
     * COnstructor secundario que crea una carta vacia.
     */
    public Carta ()
    {
        tipoCarta = "";
        cantCartas = 1;
    }
    /**
     * Aumenta la cantidad de cartas que hay de una determinada carta de un tipo
     */
    public void sumarCarta()
    {
        cantCartas++;
    }
    /**
     * Returna la cantidad de cartas de un tipo
     * @return la cantidad
     */
    public int getCantCartas()
    {
        return cantCartas;
    }
    /**
     * Returna el tipo de la carta
     * @return el tipo
     */
    public String getTipo()
    {
        return tipoCarta;
    }
}