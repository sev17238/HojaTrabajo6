
package Cartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Clase principal donde se ejecuta el menu del programa.
 * @author Ana Lucía Hernández (17138) Diego Sevilla (17238)
 */
public class Principal {
    
    public static void main(String[] args) throws IOException{
        int decision = 0; 
        int decision2 = 0;
        Coleccion cards = null;
        Carta card = null;
        System.out.println("Ingrese la direccion o el nombre del documento .txt (en el caso está en la misma carpeta que el programa): ");
        Scanner teclado = new Scanner(System.in);
        String file = teclado.nextLine();
        while(decision != 2){
            BufferedReader br = new BufferedReader(new FileReader(file));     

            try {                
                StringBuilder sb = new StringBuilder();
                String line = "";
                
                
                System.out.println("¿Que Implementacion de la interface Map desea usar? (Escriba solo el numero) \n1. HashMap \n2. TreeMap \n3. LinkedHashMap");
                String entry = teclado.nextLine();
                
                Map<String, Carta> imp = null;
                String name ="";
                String key = "";
                
                switch(entry)
                {
                    case "1":
                        entry = "HashMap";
                        cards = new Coleccion(entry);
                        imp = (HashMap)cards.getColeccion();   
                        break;
                    case "2":
                        entry = "TreeMap";
                        cards = new Coleccion(entry);
                        imp = (TreeMap)cards.getColeccion();
                        break;
                    case "3":
                        entry = "LinkedHashMap";
                        cards = new Coleccion(entry);
                        imp = (LinkedHashMap)cards.getColeccion();
                        break;   
                } 
                //AHORA LOS KEYS SERAN EL NOMBRE DE LA CARTA 
                //EL VALUE CONTENDRA A LA CARTA EN SI
                while ((line=br.readLine())!=null) {
                    sb.append(line);
                    sb.append(System.lineSeparator()); 
                    line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                       //por substring
                    for(int i=1;i<line.length();i++){
                        String iter = line.substring((i-1), i); 
                        if(iter.equals("|")){
                            name = line.substring(i, line.length()).toUpperCase(); //se obtiene la subcadena luego de "|"
                            card = new Carta(name);
                            key = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de "|"       
                        }
                    }
                    cards.getCartasDisp().put(key, card); //para poner en una coleccion todas las cartas disponibles
                }
                
                while(decision2 != 7)
                {
                    System.out.println("Elija una de las de las 7 opciones: \n1. Agregar una carta a mi coleccion"
                    + "\n2. Mostrar el tipo de una carta en especifico.\n3. Mostrar el nombre,tipo y cantidad de cada carta en coleccion."
                            + "\n4. Opcion 3 solo que ordenadas por tipo.\n5. Mostrar el nombre y el tipo de todas las cartas existentes."
                            + "\n6. Opcion 5 pero ordenadas por tipo.\n7. Salir");
                    decision2 = Integer.parseInt(teclado.nextLine());

                    switch(decision2)
                    {
                        case 1:
                            System.out.println("Ingrese el tipo de carta que desea agregar (monstruo, trampa, hechizo)");
                            String value = teclado.nextLine().toUpperCase();
                            System.out.println("Ingrese el nombre de la carta");
                            key = teclado.nextLine().toUpperCase();
                            if (cards.insertarCarta(key, value) == false)
                            {
                                System.out.println("ERROR: La carta que está intentando ingresar a su colección no se encuentra disponible.\n");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre de la carta: ");
                            String nombre = teclado.nextLine().toUpperCase();
                            System.out.println("El tipo de la carta ingresada es: " + cards.buscarCarta(nombre).getValue().getTipo());
                            break;
                        case 3:
                            System.out.println(cards.mostrarCartasColeccion());
                            break;
                        case 4:
                            cards.ordenarPorValor(cards.deMapValueCartaAMapValueTipo_C(entry));
                            break;
                        case 5: // se muestran las cartas disponibles
                            System.out.println(cards.mostrarCartasDisponibles());
                            break;
                        case 6:
                            //System.out.println(cards.ordenarPorTipoDisp(entry));                            
                            cards.ordenarPorValor(cards.deMapValueCartaAMapValueTipo_D(entry));
                            break;
                        case 7:
                            decision2 = 7;
                            break;

                    }
                }
                System.out.println("Desea salir del programa? \n1. No \n2. Si");
                decision = Integer.parseInt(teclado.nextLine());

            }
            finally{
                br.close();
            }  
        }
        
    }
}
