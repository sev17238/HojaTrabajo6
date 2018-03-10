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
 *
 * @author anahernandez
 */
public class Cartas {
    public  void mostrarCartasHash(HashMap<String, String> listaCartas) {
        String clave;
        Iterator<String> cartas = listaCartas.keySet().iterator();
        System.out.println("Las cartas son:");
        while(cartas.hasNext()){
            clave = cartas.next();
            System.out.println(clave + " - " + listaCartas.get(clave));
        }        
    }
    
    public  void eliminarCartaHash(String key, HashMap<String,String> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    } 
    
    public  void mostrarCartasTree(TreeMap<String, String> listaCartas) {
        String clave;
        Iterator<String> cartas = listaCartas.keySet().iterator();
        System.out.println("Las cartas son:");
        while(cartas.hasNext()){
            clave = cartas.next();
            System.out.println(clave + " - " + listaCartas.get(clave));
        }        
    }
    
    public void eliminarCartaTree(String key, TreeMap<String,String> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    }
    
    public  void mostrarCartasLhash(LinkedHashMap<String, String> listaCartas) {
        String clave;
        Iterator<String> cartas = listaCartas.keySet().iterator();
        System.out.println("Las cartas son:");
        while(cartas.hasNext()){
            clave = cartas.next();
            System.out.println(clave + " - " + listaCartas.get(clave));
        }        
    }
    
    public  void eliminarCartaLhash(String key, LinkedHashMap<String,String> listaCartas) {
        if (listaCartas.containsKey(key)) {
            listaCartas.remove(key);
        } else {
            System.out.println("No hay ninguna carta con esa llave.");  
        }       
    }
    
}
