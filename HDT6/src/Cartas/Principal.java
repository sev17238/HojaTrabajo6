
package Cartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ana Lucía Hernández (17138) Diego Sevilla (17238)
 */
public class Principal {
    
    public static void main(String[] args) throws IOException{
        int decision = 0;        
        
        System.out.println("Ingrese la direccion o el nombre del documento .txt (en el caso está en la misma carpeta que el programa): ");
        Scanner teclado = new Scanner(System.in);
        String file = teclado.nextLine();
        while(decision != 2){
            BufferedReader br = new BufferedReader(new FileReader(file));     

            try {                
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                System.out.println("¿Desea usar un Vector, una Lista o un ArrayList? (Escriba solo el numero) \n1. Hashmap \n2. Treemap \n3. LinkedHashmap");
                String entry = teclado.nextLine();
                switch(entry)
                {
                    case "1":
                        entry = "Hashmap";
                        
                        break;
                    case "2":
                        entry = "Treemap";
                        
                        break;
                    case "3":
                        entry = "LinkedHashmap";
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
