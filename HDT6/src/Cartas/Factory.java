
package Cartas;

/**
 * Clase que demuestra la utilizacion del patron de diseño factory.
 * @author Diego Sevilla 17238
 * @author AnaLucia Hernandez 17138
 */
class Factory<E> {
    Object implementacion;
    /**
     * Constructor vacio.
     */
    public Factory(){}
    /**
     * Selecciona la implementacion a utilizar para un stack o una lista.
     * @param entryStack el stack que se quiere usar (vector, arraylist)
     * @param entryLista la lista que se quiere usar (simply, doubly o circular)
     * @return la instanciacion correspondiente
     */
   public Object getStack(String entryStack, String entryLista) {
    // seleccion de la implementacion a utilizar:
        
        if(entryStack.equals("Hashmap"))
        {
            //implementacion =  new StackVector<>();
        }
        else if(entryStack.equals("Treemap"))
        {
            //implementacion = new StackArrayList<>();
        }
        else if(entryStack.equals("LinkedHashmap"))
        {
            //implementacion = new StackList<>(entryLista);
        }
        return implementacion;            
   }
}
