package model;

import java.util.ArrayList;
import java.util.List;

import utils.Matriz;


public class Casa {
	
	public int X_CELLS;
	public int Y_CELLS;

    private Celda[][] plano;
    
    public Casa(int X, int Y) {
    	this.X_CELLS = X;
    	this.Y_CELLS = Y;
    	this.plano = new Celda[X_CELLS][Y_CELLS];
    }
    
	public Casa(Celda[][] plano) {
		this.plano = plano;
		this.X_CELLS = plano.length ;
		this.Y_CELLS = plano[0].length ;
	}
	
	@Override
	public Casa clone() {
		Casa casaClone = new Casa(X_CELLS, Y_CELLS);
		
		for(int i=0 ; i<this.X_CELLS; i++) {
			for(int j=0;j <this.Y_CELLS; j++) {
				casaClone.setCelda(this.getCelda(i, j).clone());
			}
		}

		return casaClone;
	}
	
	public List<Celda> getCeldasVecinas(Celda c){
		List<Celda> celdasVecinas = new ArrayList<Celda>();
		
		int x = c.getX();
		int y = c.getY();
		
        if(this.isBetweenLimits(x, y-1)){
        	celdasVecinas.add(this.plano[x][y-1]);
        }
        if(this.isBetweenLimits(x-1, y)){
        	celdasVecinas.add(this.plano[x-1][y]);
        }
        if(this.isBetweenLimits(x+1, y)){
        	celdasVecinas.add(this.plano[x+1][y]);
        }
        if(this.isBetweenLimits(x, y+1)){
        	celdasVecinas.add(this.plano[x][y+1]);
        }
 
        return celdasVecinas;
	}
	
	public Celda getCelda(int x, int y){
		return this.plano[x][y];
	}
	
	public void setCelda(Celda c) {
		this.plano[c.getX()][c.getY()] = c.clone();
	}

	public Celda[][] getPlano() {
		return plano;
	}
 
	public void setPlano(Celda[][] plano) {
		this.plano = plano;
	}
	
	public boolean isBetweenLimits(int x, int y) {
		return x >=0 && y >=0 && x<X_CELLS && y <Y_CELLS;
	}
	
	public boolean hayCeldaVecinaConMenosVisitas(Celda actual, Celda siguiente) {
		List<Celda> vecinas = this.getCeldasVecinas(actual);
		for(Celda v: vecinas) {
			if(v.esAccisble() && !v.equals(siguiente) && 0 < siguiente.getVisitas() - v.getVisitas()) {
				return true;
			}
		}
		
		return false;
	}
	
	public char[][] getPlanoChars(){
		char[][] planoChars = new char[this.X_CELLS][this.Y_CELLS];
		for(int i = 0; i < this.X_CELLS; i++) {
			for(int j=0; j<this.Y_CELLS; j++) {
				planoChars[i][j] = this.getCelda(i, j).getChar();
				if(!plano[i][j].isDescubierta()) {
					planoChars[i][j] = 'x';
				}
			}
		}
		return planoChars;
	}
	
	public static Casa convertirASinDescubrir(Casa casa) {
		Casa casaSinDescubrir = new Casa(casa.X_CELLS, casa.Y_CELLS);
		for(int i = 0; i < casa.X_CELLS; i++) {
			for(int j=0; j< casa.Y_CELLS; j++) {
				planoChars[i][j] = this.getCelda(i, j).getChar();
			}
		}
	}
}

