
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
    /**
     * Metodo que retorna la implementacion a utilizar
     * @param impMap el string que dice que implementacionse utilizara
     * @return el Map correspondiente
     */
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
