package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import model.Celda;
import model.TipoSuelo;

public class Matriz {
	
	private static Celda[][] plano = new Celda[82][50];

	public static Celda[][] crearMatrizDesdeArchivo(String ruta){
		try {
			BufferedReader br = getBuffered(ruta);
			//lee el primer renglón del archivo
			String linea =  br.readLine();
			int fila = 0;
			while(linea != null){
				//crea un arreglo con los caracteres del renglón separados por |
				String[] values = linea.split(Pattern.quote("|"));
				for (int i = 0; i<values.length; i++) {
					//llama a crearCelda con el caracter de esa posición del mapa como parámetro
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
			costo=1.0;
			break;
		case '#':
			suelo=TipoSuelo.PARED;
			costo=9999.0;
			break;
		case '$':
			suelo=TipoSuelo.OBSTACULO;
			costo=9999.0;
			break;
		case '~':
			suelo=TipoSuelo.PASTO;
			costo=2.0;
			break;
		case 'a':
			suelo=TipoSuelo.PUERTA_ABIERTA;
			costo=1.0;
			break;
		case 'c':
			suelo=TipoSuelo.PUERTA_CERRADA;
			costo=9999.0;
			break;
		case '\'':
			suelo=TipoSuelo.ALFOMBRA;
			costo=2.0;
			break;
		case '!':
			suelo=TipoSuelo.AGUA;
			costo=0.5;
			break;
		case '%':
			suelo=TipoSuelo.ARENA;
			costo=2.0;
			break;
		case '*':
			suelo=TipoSuelo.BASURA;
			costo=2.0;
			break;
		case '&':
			suelo=TipoSuelo.ROPA;
			costo=2.0;
			break;
		case 'N':
			suelo=TipoSuelo.ESCALERA_N;
			costo=1.0;
			break;
		case 'S':
			suelo=TipoSuelo.ESCALERA_S;
			costo=1.0;
			break;
		case 'E':
			suelo=TipoSuelo.ESCALERA_E;
			costo=1.0;
			break;
		case 'O':
			suelo=TipoSuelo.ESCALERA_O;
			costo=1.0;
			break;

		default:
			break;
		}

		celda.setTipoSuelo(suelo);
		celda.setCosto(costo);

		return celda;
	}


}
