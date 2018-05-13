package interfaz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import model.Celda;


public class CreaMatriz {
	
	private static int X_SIZE;
	private static int Y_SIZE;

	
	public static void main(String[] args) {
	}
		
	 public static char[][] matrizDesdeArchivo(File fileMapa){
		 char[][] matriz; 
		    try {
		        BufferedReader br = getBuffered(fileMapa);
				//lee el primer renglon y segundo renglon del archivo, donde esta el tamanio de la matriz
				String lineaFilas =  br.readLine();
				String lineaColumnas = br.readLine();
				X_SIZE = Integer.parseInt(lineaFilas);
				Y_SIZE = Integer.parseInt(lineaColumnas);
				
				matriz = new char[X_SIZE][Y_SIZE];
				
				//leo el resto
				int fila = 0;
				String linea = br.readLine();
		        while(linea != null){
		            String[] values = linea.split(Pattern.quote("|"));
		            //recorremos el array de string
		            for (int i = 0; i<values.length; i++) {
		                //se obtiene el primer caracter de el arreglo de strings
		            	matriz[fila][i] = values[i].charAt(0);
		            }
		            fila++;
		            linea = br.readLine();
		        }
				return matriz;
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
			return null;
		}
	
	public static BufferedReader getBuffered(File fileMapa){

	    FileReader lector  = null;
	    BufferedReader br = null;
	    try {
	         File Arch= fileMapa;
	         if(!Arch.exists()){
	           System.out.println("No existe el archivo");
	         }else{
	           lector = new FileReader(fileMapa);
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
