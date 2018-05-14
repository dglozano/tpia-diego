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
	
	public static Celda[][] crearMatrizDesdeChar(char[][] matriz){
			X_SIZE = matriz.length;
			Y_SIZE = matriz[0].length;
			
			Celda[][] plano = new Celda[X_SIZE][Y_SIZE];
			
			for(int i=0;i<X_SIZE;i++) {
				for(int j=0; j<Y_SIZE;j++) {
					Celda celda = crearCelda(matriz[i][j]);
					celda.setX(i);
					celda.setY(j);
					plano[i][j] = celda;
				}
			}
			
		return plano;
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
