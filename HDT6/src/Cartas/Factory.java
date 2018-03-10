
package Cartas;

import java.util.*;

/**
 * Clase que demuestra la utilizacion del patron de diseño factory.
 * @author Ana Lucía Hernández (17138) Diego Sevilla (17238)
 */
class Factory<K,V> {
    Map implementacion;
    /**
     * Constructor vacio.
     */
    public Factory(){}
    
    public Map getMap(String impMap) {
    // seleccion de la implementacion a utilizar:
        
        if(impMap.equals("HashMap"))
        {
            implementacion =  new HashMap<>();
        }
        else if(impMap.equals("TreeMap"))
        {
            implementacion = new TreeMap<>();
        }
        else if(impMap.equals("LinkedHashMap"))
        {
            implementacion = new LinkedHashMap<>();
        }
        return implementacion;            
   }

}
