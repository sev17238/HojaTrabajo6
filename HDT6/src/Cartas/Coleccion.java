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
    
    public  void mostrarCartasHash(HashMap<String, Carta> listaCartas) {
        String clave;
        Iterator<String> cartas = listaCartas.keySet().iterator();
        System.out.println("Las cartas son:");
        while(cartas.hasNext()){
            clave = cartas.next();
            System.out.println(clave + " - " + listaCartas.get(clave));
        }        
    }
    public boolean insertarCarta(String key, String tipo)
    {
        boolean existe = false;
        for (Map.Entry<String, Carta> entry : cartasDisponibles.entrySet()) //buscara en la lista de cartas disponibles si la que quiere ingresar existe
        {
            if (entry.getKey().equals(key))
            {
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
                existe = true;
            }
        }
        return existe;
    }
    public  void eliminarCartaHash(String key, HashMap<String, Carta> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    } 
    
    public String mostrarCartas()
    {
        String hilo ="";
        for (Map.Entry<String, Carta> entryCol : coleccion.entrySet())
        {
            hilo += "NOMBRE DE CARTA: " + entryCol.getKey() + "\n";
            hilo += "TIPO DE CARTA: "+ entryCol.getValue().getTipo() + "\n";
        }
        return hilo;
    }
    public  void mostrarCartasTree(TreeMap<String, Carta> listaCartas) {
        String clave;
        Iterator<String> cartas = listaCartas.keySet().iterator();
        System.out.println("Las cartas son:");
        while(cartas.hasNext()){
            clave = cartas.next();
            System.out.println(clave + " - " + listaCartas.get(clave));
        }        
    }
    
    public void eliminarCartaTree(String key, TreeMap<String,Carta> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    }
    
    public  void mostrarCartasLhash(LinkedHashMap<String, Carta> listaCartas) {
        String clave;
        Iterator<String> cartas = listaCartas.keySet().iterator();
        System.out.println("Las cartas son:");
        while(cartas.hasNext()){
            clave = cartas.next();
            System.out.println(clave + " - " + listaCartas.get(clave));
        }        
    }
    
    public  void eliminarCartaLhash(String key, LinkedHashMap<String, Carta> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    }

}
