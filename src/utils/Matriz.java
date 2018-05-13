package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import model.Celda;
import model.TipoSuelo;

public class Matriz {
	
	private static int X_SIZE;
	private static int Y_SIZE;
	
	public static Celda[][] crearMatrizDesdeArchivo(String ruta){
		Celda[][] plano = null;
		try {
			BufferedReader br = getBuffered(ruta);
			//lee el primer renglon y segundo renglon del archivo, donde esta el tamanio de la matriz
			String lineaFilas =  br.readLine();
			String lineaColumnas = br.readLine();
			X_SIZE = Integer.parseInt(lineaFilas);
			Y_SIZE = Integer.parseInt(lineaColumnas);
			
			plano = new Celda[X_SIZE][Y_SIZE];
			
			//leo el resto
			int fila = 0;
			String linea = br.readLine();
			while(linea != null){
				//crea un arreglo con los caracteres del renglon separados por |
				String[] values = linea.split(Pattern.quote("|"));
				for (int i = 0; i<values.length; i++) {
					//llama a crearCelda con el caracter de esa posicion del mapa como parametro
					Celda celda = crearCelda(values[i].charAt(0));
					celda.setX(fila);
					celda.setY(i);
					plano[fila][i] = celda;
				}
				fila++;
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return plano;
	}

	private static BufferedReader getBuffered(String link){

		FileReader lector = null;
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

	private static Celda crearCelda (char caracter){
		Celda celda = new Celda();
		TipoSuelo suelo = null;
		Double costo = null;

		switch (caracter) {
		case '_':
			suelo=TipoSuelo.COMUN;
			break;
		case '#':
			suelo=TipoSuelo.PARED;
			break;
		case '$':
			suelo=TipoSuelo.OBSTACULO;
			break;
		case '~':
			suelo=TipoSuelo.PASTO;
			break;
		case 'a':
			suelo=TipoSuelo.PUERTA_ABIERTA;
			break;
		case 'c':
			suelo=TipoSuelo.PUERTA_CERRADA;
			break;
		case '\'':
			suelo=TipoSuelo.ALFOMBRA;
			break;
		case '!':
			suelo=TipoSuelo.AGUA;
			break;
		case '%':
			suelo=TipoSuelo.ARENA;
			break;
		case '*':
			suelo=TipoSuelo.BASURA;
			break;
		case '&':
			suelo=TipoSuelo.ROPA;
			break;
		case 'N':
			suelo=TipoSuelo.ESCALERA_N;
			break;
		case 'S':
			suelo=TipoSuelo.ESCALERA_S;
			break;
		case 'E':
			suelo=TipoSuelo.ESCALERA_E;
			break;
		case 'O':
			suelo=TipoSuelo.ESCALERA_O;
			break;

		default:
			break;
		}

		celda.setTipoSuelo(suelo);
		celda.setVisitas(0);
		celda.setDescubierta(false);

		return celda;
	}
}
