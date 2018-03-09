/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

import java.util.*;

/**
 *
 * @author Ana Lucia Hernandez (17138) Diego Sevilla 
 */
public class Coleccion {
    
    Map<String, Carta> coleccion;
    Map<String, Carta> cartasDisponibles;
    
    public Coleccion(String impMap){
        Factory fac = new Factory();
        coleccion = fac.getMap(impMap);
        cartasDisponibles = fac.getMap(impMap);
    }
    public Map getMap()
    {
        return coleccion;
    }
    
    public Map getCartasDisp()
    {
        return cartasDisponibles;
    }
    
    public boolean insertarCarta(String key, String tipo)
    {
        boolean existe = false;
        for (Map.Entry<String, Carta> entry : cartasDisponibles.entrySet()) //buscara en la lista de cartas disponibles si la que quiere ingresar existe
        {
            if (entry.getKey().equals(key))
            {
                existe = true;
                for (Map.Entry<String, Carta> entryCol : coleccion.entrySet())
                {
                    if (entryCol.getKey().equals(key))
                    {
                        entryCol.getValue().sumarCarta();
                    }
                    else
                    {
                        key = entry.getKey();
                        Carta card = entry.getValue();
                        coleccion.put(key, card);
                    }
                }
            }
        }
        return existe;
    }
    public Map.Entry<String, Carta> buscarCarta(String nombre)
    {
        Map.Entry<String, Carta> busqueda = null;
        for (Map.Entry<String, Carta> entry : cartasDisponibles.entrySet()) //buscara en la lista de cartas disponibles si la que quiere ingresar existe
        {
            if (entry.getKey().equals(nombre))
            {
                busqueda = entry;
            }
        }
        return busqueda;
    }
    public  void eliminarCartaHash(String key, HashMap<String, Carta> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    } 
    
    public String mostrarCartasColeccion()
    {
        String hilo ="";
        for (Map.Entry<String, Carta> entryCol : coleccion.entrySet())
        {
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue().getTipo() + "\n";
        }
        return hilo;
    }
    public String mostrarCartasDisponibles()
    {
        String hilo ="";
        for (Map.Entry<String, Carta> entryCol : cartasDisponibles.entrySet())
        {
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue().getTipo() + "\n";
        }
        return hilo;
    }
}