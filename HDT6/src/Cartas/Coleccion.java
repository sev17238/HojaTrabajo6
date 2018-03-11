
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
    /**
     * Constructor de Coleccion donde se incializan los atributos; uno que es un map que contiene
     * todas las cartas disponibles y otro que representa las cartas que tiene un usuario.
     * @param impMap la cadena que dice el tipo de implementacion a utilizar
     */
    public Coleccion(String impMap){
        Factory fac = new Factory();
        coleccion = fac.getMap(impMap);
        cartasDisponibles = fac.getMap(impMap);
    }
    /**
     * Metodo que returna la coleccion
     * @return un map representando a la coleccion del usuario
     */
    public Map getColeccion()
    {
        return coleccion;
    }
    /**
     * Metodo que retorna las caratas disponibles
     * @return un map representando a todas las cartas disponibles que hay
     */
    public Map getCartasDisp()
    {
        return cartasDisponibles;
    }
    /**
     * Metodo que inserta una carta a la coleccion del usuario
     * @param key la llave de la carta
     * @param tipo el tipo de la carta
     * @return un boolean que determina si la carta existe
     */
    public boolean insertarCarta(String key, String tipo)
    {
        boolean existe = false;
        for (Map.Entry<String, Carta> entry : cartasDisponibles.entrySet()) //buscara en la lista de cartas disponibles si la que quiere ingresar existe
        {
            if (entry.getKey().equals(key) && ((entry.getValue().getTipo()).equals(tipo)))
            {
                existe = true;
                if (coleccion.isEmpty())
                {
                    Carta carta = new Carta(tipo);
                    coleccion.put(key, carta);
                }
                else 
                {
                    boolean coincide = false;
                    for (Map.Entry<String, Carta> entryCol : coleccion.entrySet())
                    {
                        if (entryCol.getKey().equals(key)) //para revisar si la carta que está intentando insertar ya existe en la colección
                        {
                            entryCol.getValue().sumarCarta();
                            coincide = true;
                        }
                    }
                    if (coincide == false) // ya que ya reviso toda la coleccion, si no se ha encontrado una existente, que la cree en la coleccion
                    {
                        Carta carta = new Carta(tipo);
                        coleccion.put(key, carta);
                    }
                    break;
                }
            }
        }
        return existe;
    }
    /**
     * Metodo que busca una carta en especifico
     * @param nombre el de la carta
     * @return la carta
     */
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
    /**
     * Metodo que muestra las cartas de la coleccion del usuaio
     * @return una string con la info
     */
    public String mostrarCartasColeccion()
    {
        String hilo ="";
        for (Map.Entry<String, Carta> entryCol : coleccion.entrySet())
        {
            hilo += "Nombre de carta: " + entryCol.getKey();
            hilo += "\tTipo: "+ entryCol.getValue().getTipo();
            hilo += "\tCantidad: " + entryCol.getValue().getCantCartas() + "\n";
        }
        return hilo;
    }
    /**
     * Metodo que muestra todas las cartas disponibles
     * @return una string con la info
     */
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
     * @param imp la implementaicion de Map que se esta utilizando
     * @return el nuevo mapa (String,String)
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
     * @param imp la implementaicion de Map que se esta utilizando
     * @return el nuevo mapa (String,String)
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
