package model;

import java.util.ArrayList;
import java.util.List;

import utils.Matriz;


public class Casa {
	
	public static final int X_CELLS = 13;
	public static final int Y_CELLS = 18;

	
    private Celda[][] plano = new Celda[X_CELLS][Y_CELLS];
    private Celda posicionAgente;
    private Celda posicionBoy;
    
	public Casa() {
		//this.Crear();
		plano = Matriz.crearMatrizDesdeArchivo("mapa-chico.txt");
	}

	// FIXME: Plano casa ejemplo, borrar luego
	public void Crear() {
		for (int x = 0; x < X_CELLS; x++){
			for (int y= 0; y < Y_CELLS; y++){
				Celda celda = new Celda();
				celda.setX(x);
				celda.setY(y);
				if(x == 0 || x == X_CELLS-1 || y == 0 || y == Y_CELLS-1 || (y == Y_CELLS/2 && x != X_CELLS/2)){
					celda.setTipoSuelo(TipoSuelo.PARED);
					celda.setCosto(9999.0);
				} else if (y == Y_CELLS/2 && x == X_CELLS/2){
					celda.setTipoSuelo(TipoSuelo.PUERTA_ABIERTA);
					celda.setCosto(1.0);
				} else {
					celda.setTipoSuelo(TipoSuelo.COMUN);
					celda.setCosto(1.0);
				}
				plano[x][y]= celda;
			}
		}
	}
	
	public List<Celda> getCeldasVecinas(Celda c){
		List<Celda> celdasVecinas = new ArrayList<Celda>();
		
		int x = c.getX();
		int y = c.getY();
		
        for(int i=0; i<3; i++){
        	for(int j=0; j<3; j++){
        		if(i!=1 || j!=1){
        			if(Casa.isBetweenLimits(x+i-1, y+j-1)){
        				celdasVecinas.add(this.plano[x+i-1][y+j-1]);
        			}
        		}
        	}
        }
        
        return celdasVecinas;
	}
	
	public Celda getCelda(int x, int y){
		return this.plano[x][y];
	}

	public Celda[][] getPlano() {
		return plano;
	}

	public void setPlano(Celda[][] plano) {
		this.plano = plano;
	}
	
	@Override
	public String toString(){
		String output = "";
		for(int i = 0; i < X_CELLS ; i++){
			output += "|";
			for (int j = 0; j < Y_CELLS; j++){
				if(this.posicionAgente != null && this.posicionAgente.getX() == i && this.posicionAgente.getY() == j)
					output += "A|";
				else if(this.posicionBoy != null && this.posicionBoy.getX() == i && this.posicionBoy.getY() == j) 
					output += "B|";
				else 
					output += this.plano[i][j].getChar() + "|";
			}
			output += "\n";
		}
		return output;
	}
	
	public static boolean isBetweenLimits(int x, int y) {
		return x >=0 && y >=0 && x<X_CELLS && y <Y_CELLS;
	}

	public void setPosicionAgente(Celda posicionAgente) {
		this.posicionAgente = posicionAgente;
	}

	public Celda getPosicionAgente() {
		return posicionAgente;
	}

	public void setPosicionBoy(Celda posicionBoy) {
		this.posicionBoy = posicionBoy;
	}

	public Celda getPosicionBoy() {
		return posicionBoy;
	}
	
 	public void setPosicionAgente(int x, int y){
 		this.posicionAgente = this.getCelda(x, y);
 	}

 	public void setPosicionBoy(int x, int y){
 		this.posicionBoy = this.getCelda(x, y);
 	}
}

