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
				casaClone.setCelda(this.getCelda(i, j));
			}
		}

		return casaClone;
	}
	
	public List<Celda> getCeldasVecinas(Celda c){
		List<Celda> celdasVecinas = new ArrayList<Celda>();
		
		int x = c.getX();
		int y = c.getY();
		/*
        for(int i=0; i<3; i++){
        	for(int j=0; j<3; j++){
        		if(i!=1 || j!=1){
        			if(this.isBetweenLimits(x+i-1, y+j-1)){
        				celdasVecinas.add(this.plano[x+i-1][y+j-1]);
        			}
        		}
        	}
        }*/
		

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
			if(v.esAccisble() && v.getVisitas() < siguiente.getVisitas()) {
				return true;
			}
		}
		
		return false;
	}
}

