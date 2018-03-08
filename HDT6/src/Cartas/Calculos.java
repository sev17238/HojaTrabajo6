
package Cartas;

/**
 * Clase que realiza la distribucion de las diferentes implementaciones realizadas<p>
 * dependiendo de los parametros ingresados.
 * @author Diego Sevilla 17238
 * @author AnaLucia Hernandez 17138
 */
public class Calculos {
    static boolean INSTANCE_FLAG = false;
    
    /**
     * constructor vacio.
     */
    public Calculos() throws SingletonException    {
        
    }
    
    /**
     * Metodo que realiza la distribucion de implementaciones que se usan dependiendo de los <p>
     * parametros ingresados.
     * @param expresion: String que contiene todos los numerandos y operaciones que se quieren realizar
     * @param entryLista: tipo de lista que se desea
     * @param entryStack: tipo de stack que se desea
     * @return el resultado de operar todo lo que dice el string 
     */
    public double operar(String expresion, String entryStack, String entryLista)
    {
        Factory fac = new Factory();
        Object imp = fac.getStack(entryStack, entryLista);
        double respuesta = 0;
        if (imp instanceof StackList)
        {
            StackList lista = (StackList)imp;
            if (entryLista.equals("Lista Circular"))
            {
                respuesta = lista.operarc(expresion);
            }
            else
            {
                respuesta = lista.operar(expresion);
            }
                
        }
        else if(imp instanceof AbstractStack)
        {
            AbstractStack stack = (AbstractStack)imp;
            if (stack instanceof StackVector)
            {
                respuesta = ((StackVector) stack).operar(expresion);
            }
            else if (stack instanceof StackArrayList)
            {
                respuesta = ((StackArrayList) stack).operar(expresion);
            }
        }
        return respuesta;
    }
}
