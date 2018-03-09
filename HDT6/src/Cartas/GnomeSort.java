

/**
 * Clase que implementa el metodo de ordenamiento de Gnome.
 * @author Cpn. Javier Garfio 17077
 * @author Diego C-villa 17238
 */
public class GnomeSort {
    public Comparable[] GnomeSort(Comparable[] list){        
        int index=1; //start of search
        int temp;
        for(index = 1; index<list.length;){ //until the array is fully sorted
            if((int)list[index] < (int)list[index-1]){ //compares list[index] with list[index-1]. if smaller, switch.
                temp = (int)list[index];
                list[index]=list[index-1];
                list[index-1]=temp;
                index--; //must decrease index to recheck. since they have been swapped, the array may still be out of order
                if(index==0){ //prevents index from going lower than 1
	          index=1;
	        }
	    }
	      else{
	        index++; //if sorted, go up
	      }
	}        
        return list;
    }
}
