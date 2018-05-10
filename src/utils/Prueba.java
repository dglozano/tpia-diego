package utils;

import model.Celda;
import utils.Matriz;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Celda[][] plano = Matriz.crearMatrizDesdeArchivo("mapa.txt");
		System.out.println("El suelo de la casilla es del tipo: "+plano[33][20].getTipoSuelo());
		System.out.println("Y su costo de la casila es de: "+plano[33][20].getCosto());

	}

}
