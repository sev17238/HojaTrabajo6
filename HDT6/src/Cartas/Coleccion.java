/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartas;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Clase donde se realizan las busquedas, incersiones y ordenamientos en las implementaciones de Map.
 * @author Ana Lucía Hernández (17138) Diego Sevilla (17238)
 */
public class Coleccion {
    
    Map<String, Carta> coleccion;
    Map<String, Carta> cartasDisponibles;
    
    public Coleccion(String impMap){
        Factory fac = new Factory();
        coleccion = fac.getMap(impMap);
        cartasDisponibles = fac.getMap(impMap);
    }
    public Map getColeccion()
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
    
//------------------------------------Sort de los Maps---------------------------------------------
/*public String ordenarPorTipoCol(String impMap)
{
    Factory fac = new Factory();
    Map<String,Carta> newMap = fac.getMap(impMap);
    ArrayList values = new ArrayList(coleccion.keySet());
    Collections.sort(values);
    //GnomeSort gs = new GnomeSort();
    Iterator it = values.iterator();
    String tmp="";
    while(it.hasNext()){
        tmp = (String)it.next();
        for(Map.Entry<String,Carta> k : coleccion.entrySet()){
            if(tmp.equals(k.getKey())){
                newMap.put(k.getKey(), k.getValue());
            }
        }
    }
    String hilo ="";
        for (Map.Entry<String, Carta> entryCol : newMap.entrySet()){
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue().getTipo() + "\n";
        }
        return hilo;
//return newMap;
}*/
/*
public String ordenarPorTipoCol(String impMap)
{
    Factory fac = new Factory();
    Map<String,Carta>  newMap = fac.getMap(impMap);
    ArrayList values = new ArrayList(cartasDisponibles.values());
    Carta card = new Carta();
    
    ArrayList tipos = new ArrayList();
    for(int i=0;i<values.size();i++){
        card = (Carta)values.get(i);
        tipos.add(card.getTipo());
    }
    
    Collections.sort(tipos);
    //GnomeSort gs = new GnomeSort();
    Iterator it = tipos.iterator();
    Carta card2 = new Carta();
    String tmp ="";
    while(it.hasNext()){
        tmp = (String)it.next();
        //tmp = card2.getTipo();
        for(Map.Entry<String,Carta> k : cartasDisponibles.entrySet()){
            if(tmp.equals(k.getValue().getTipo())){
                newMap.put(k.getKey(), k.getValue());
            }
        }
    }
    String hilo ="";
        for (Map.Entry<String, Carta> entryCol : newMap.entrySet()){
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue().getTipo() + "\n";
        }
        return hilo;
//return newMap;
    }

public String ordenarPorTipoDisp(String impMap)
{
    Factory fac = new Factory();
    Map<String,Carta>  newMap = fac.getMap(impMap);
    ArrayList values = new ArrayList(cartasDisponibles.values());
    Carta card = new Carta();
    
    ArrayList tipos = new ArrayList();
    for(int i=0;i<values.size();i++){
        card = (Carta)values.get(i);
        tipos.add(card.getTipo());
    }
    
    Collections.sort(tipos);
    //GnomeSort gs = new GnomeSort();
    Iterator it = tipos.iterator();
    Carta card2 = new Carta();
    String tmp ="";
    while(it.hasNext()){
        tmp = (String)it.next();
        //tmp = card2.getTipo();
        for(Map.Entry<String,Carta> k : cartasDisponibles.entrySet()){
            if(tmp.equals(k.getValue().getTipo())){
                newMap.put(k.getKey(), k.getValue());
            }
        }
    }
    String hilo ="";
        for (Map.Entry<String, Carta> entryCol : newMap.entrySet()){
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue().getTipo() + "\n";
        }
        return hilo;
//return newMap;
    } */

    /**
     * Metodo que ordena una implementacion de map por sus valores.
     * @param <K> un generico
     * @param <V> un generico
     * @param map un map(K,V)
     * @return el map ya ordenado
     */
    public <K, V extends Comparable<? super V>> Map<K, V> ordenarPorValor(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        });
        
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }        
        //Aqui se imprime el Map ya ordenado.
        String hilo ="";
        for (Map.Entry<K, V> entryCol : result.entrySet()){
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue() + "\n";
        }
        System.out.println(hilo);
        return result; //este retorno no se usa pero ni modo jajaja ya salio xD
    }
    /**
     * Metodo que genera un Map(String,String) a partir del Map(String,Carta) "cartasDisponibles" de
     * manera que pueda ser ordenada por el metodo "ordenarPorValor"
     * @param imp
     * @return 
     */
    public Map<String,String> deMapValueCartaAMapValueTipo_D(String imp){
        Factory fac = new Factory();
        Map<String,String> newMap = fac.getMap(imp);
        String name="";
        String tipo="";        
        for (Map.Entry<String, Carta> entry : cartasDisponibles.entrySet()) //buscara en la lista de cartas disponibles si la que quiere ingresar existe
        {
            name = entry.getKey();
            tipo = entry.getValue().getTipo();
            newMap.put(name,tipo);            
        }
        return newMap;
    }
    /**
     * Metodo que genera un Map(String,String) a partir del Map(String,Carta) "coleccion" de
     * manera que pueda ser ordenada por el metodo "ordenarPorValor"
     * @param imp
     * @return 
     */
    public Map<String,String> deMapValueCartaAMapValueTipo_C(String imp){
        Factory fac = new Factory();
        Map<String,String> newMap = fac.getMap(imp);
        String name="";
        String tipo="";        
        for (Map.Entry<String, Carta> entry : coleccion.entrySet()) //buscara en la lista de cartas disponibles si la que quiere ingresar existe
        {
            name = entry.getKey();
            tipo = entry.getValue().getTipo();
            newMap.put(name,tipo);            
        }
        return newMap;
    }
}