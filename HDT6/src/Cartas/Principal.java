
package Cartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Ana Lucía Hernández (17138) Diego Sevilla (17238)
 */
public class Principal {
    
    public static void main(String[] args) throws IOException{
        int decision = 0; 
        int decision2 = 0;
        Factory fac = new Factory();
        Cartas card = new Cartas();
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
                
                String key="";
                String name="";
                
                switch(entry)
                {
                    case "1":
                        entry = "HashMap";
                        HashMap hash = (HashMap)fac.getMap(entry);
                        
                        //ciclo que lee cada linea del archivo
                        while ((line=br.readLine())!=null) {
                            sb.append(line);
                            sb.append(System.lineSeparator());  
                            line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                               //por substring
                            for(int i=1;i<line.length();i++){
                                String iter = line.substring((i-1), i); 
                                if(iter.equals("|")){
                                    key = line.substring(i, line.length()); //se obtiene la subcadena luego de "|"
                                    name = line.substring(0, i-1); //se obtiene la subcadena antes de "|"       
                                }
                            }
                            hash.put(key, name);
                            System.out.println("Llave: " + key + "Nombre: "+name); //prueba
                        }     
                        
                        while(decision2 != 7){
                            System.out.println("Elija una de las de las 7 opciones: \n1. Agregar una carta a mi coleccion"
                            + "\n2.Mostrar el tipo de una carta en especifico.\n3.Mostrar el tipo nombre,tipo y cantidad de una carta en coleccion."
                                    + "\n4. Opcion 3 solo que ordenadas por tipo.\n5.Mostrar el nombre y el tipo de todas las cartas existentes."
                                    + "\n6. Opcion 5 pero ordenadas por tipo.\n7. Salir");
                            decision2 = Integer.parseInt(teclado.nextLine());
                            
                            switch(decision2){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    card.mostrarCartasHash(hash);
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    decision2 = 7;
                                    break;
                                
                            }
                        }
                                               
                        break;
                    case "2":
                        entry = "TreeMap";
                        TreeMap tree = (TreeMap)fac.getMap(entry);
                        
                        //ciclo que lee cada linea del archivo
                        while ((line=br.readLine())!=null) {
                            sb.append(line);
                            sb.append(System.lineSeparator()); 
                            line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                               //por substring
                            for(int i=1;i<line.length();i++){
                                String iter = line.substring((i-1), i); 
                                if(iter.equals("|")){
                                    key = line.substring(i, line.length()); //se obtiene la subcadena luego de "|"
                                    name = line.substring(0, i-1); //se obtiene la subcadena antes de "|"       
                                }
                            }
                            tree.put(key, name);
                            System.out.println("Llave: " + key + "Nombre: "+name); //prueba
                        }   
                        
                        while(decision2 != 7){
                            System.out.println("Elija una de las de las 7 opciones: \n1. Agregar una carta a mi coleccion"
                            + "\n2.Mostrar el tipo de una carta en especifico.\n3.Mostrar el tipo nombre,tipo y cantidad de una carta en coleccion."
                                    + "\n4. Opcion 3 solo que ordenadas por tipo.\n5.Mostrar el nombre y el tipo de todas las cartas existentes."
                                    + "\n6. Opcion 5 pero ordenadas por tipo.\n7. Salir");
                            decision2 = Integer.parseInt(teclado.nextLine());
                            
                            switch(decision2){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    card.mostrarCartasTree(tree);
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    decision2 = 7;
                                    break;
                                
                            }
                        }
                        
                        break;
                    case "3":
                        entry = "LinkedHashMap";
                        LinkedHashMap lhash = (LinkedHashMap)fac.getMap(entry);
                        
                       //ciclo que lee cada linea del archivo
                        while ((line=br.readLine())!=null) {
                            sb.append(line);
                            sb.append(System.lineSeparator());  
                            line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                               //por substring
                            for(int i=1;i<line.length();i++){
                                String iter = line.substring((i-1), i); 
                                if(iter.equals("|")){
                                    key = line.substring(i, line.length()); //se obtiene la subcadena luego de "|"
                                    name = line.substring(0, i-1); //se obtiene la subcadena antes de "|"       
                                }
                            }
                            lhash.put(key, name);
                            System.out.println("Llave: " + key + "Nombre: "+name); //prueba
                        }   
                        
                        while(decision2 != 7){
                            System.out.println("Elija una de las de las 7 opciones: \n1. Agregar una carta a mi coleccion"
                            + "\n2.Mostrar el tipo de una carta en especifico.\n3.Mostrar el tipo nombre,tipo y cantidad de una carta en coleccion."
                                    + "\n4. Opcion 3 solo que ordenadas por tipo.\n5.Mostrar el nombre y el tipo de todas las cartas existentes."
                                    + "\n6. Opcion 5 pero ordenadas por tipo.\n7. Salir");
                            decision2 = Integer.parseInt(teclado.nextLine());
                            
                            switch(decision2){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    card.mostrarCartasLhash(lhash);
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    decision2 = 7;
                                    break;
                                
                            }
                        }
                        
                        break;   
                }              
                
                System.out.println("Desea salir? \n1. No \n2. Si");
                decision = Integer.parseInt(teclado.nextLine());

            }
            finally{
                br.close();
            }  
        }
        
    }
}
