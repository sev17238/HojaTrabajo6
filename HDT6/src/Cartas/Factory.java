
package Cartas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Clase que demuestra la utilizacion del patron de diseño factory.
 * @author Diego Sevilla 17238
 * @author AnaLucia Hernandez 17138
 */
class Factory<K,V> {
    Object implementacion;
    /**
     * Constructor vacio.
     */
    public Factory(){}
    /**
     * Selecciona la implementacion a utilizar para un stack o una lista.
     * @param entryLista la lista que se quiere usar (simply, doubly o circular)
     * @return la instanciacion correspondiente
     */
   public Object getMap(String impMap) {
    // seleccion de la implementacion a utilizar:
        
        if(impMap.equals("HashMap"))
        {
            implementacion =  new HashMap<>();
        }
        else if(impMap.equals("TreeMap"))
        {
            implementacion = new TreeMap<>();
        }
        else if(impMap.equals("LinkeHashMap"))
        {
            implementacion = new LinkedHashMap<>();
        }
        return implementacion;            
   }
}
