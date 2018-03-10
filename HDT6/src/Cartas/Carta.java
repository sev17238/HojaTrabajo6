/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Carta (String tipo)
    {
        tipoCarta = tipo;
        cantCartas = 1;
    }
    public Carta ()
    {
        tipoCarta = "";
        cantCartas = 1;
    }
    
    public void sumarCarta()
    {
        cantCartas++;
    }
    public int getCantCartas()
    {
        return cantCartas;
    }
    public String getTipo()
    {
        return tipoCarta;
    }
}