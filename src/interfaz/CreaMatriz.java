package interfaz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import model.Celda;


public class CreaMatriz {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
		
	 public static char[][] matrizDesdeArchivo(String ruta){
		    try {
		        BufferedReader br = getBuffered(ruta);
		        //leemos la primera linea
		        String linea =  br.readLine();
		        //creamos la matriz vacia
		        char[][] matriz = new char[13][18];
		        int contador = 0;
		        while(linea != null){
		            String[] values = linea.split(Pattern.quote("|"));
		            //recorremos el array de string
		            for (int i = 0; i<values.length; i++) {
		                //se obtiene el primer caracter de el arreglo de strings
		            	matriz[contador][i] = values[i].charAt(0);
		            }
		            contador++;
		            linea = br.readLine();
		        }
				return matriz;
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
			return null;
		}
	
	public static BufferedReader getBuffered(String link){

	    FileReader lector  = null;
	    BufferedReader br = null;
	    try {
	         File Arch=new File(link);
	         if(!Arch.exists()){
	           System.out.println("No existe el archivo");
	         }else{
	           lector = new FileReader(link);
	           br = new BufferedReader(lector);
	         }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return br;
	}
	

	 public static void imprimirMatriz(char[][] matriz){
		    for (int x=0; x < matriz.length; x++) {
		        for (int y=0; y < matriz[x].length; y++) {
		          System.out.print (matriz[x][y]);
		        }
		        System.out.println();
		      }
	 }
	 
}
