package frsf.cidisi.exercise.modelocartoy.search;

import model.Celda;
import utils.Matriz;
import model.Casa;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private Casa casa;
    
    private Celda posicionCarToy;
    private Celda posicionBoy;
	
	public EstadoAmbiente() {
        
        this.casa = new Casa(Matriz.crearMatrizDesdeArchivo("mapa-chico.txt"));
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	this.posicionBoy = this.casa.getCelda(1,1);
    	this.posicionCarToy = this.casa.getCelda(14,9);
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
    	
    	str.append("\n");
		for(int i = 0; i < casa.X_CELLS ; i++){
			str.append("|");
			for (int j = 0; j < casa.Y_CELLS; j++){
					if(this.posicionCarToy != null && this.posicionCarToy.getX() == i && this.posicionCarToy.getY() == j)
						str.append("A|");
					else if(this.posicionBoy != null && this.posicionBoy.getX() == i && this.posicionBoy.getY() == j) 
						str.append("B|");
					else 
						str.append(this.casa.getCelda(i, j).getChar() + "|");
				}
			str.append("\n");
			}
			str.append("\n");
        
        return str.toString();
    }
    
     public Casa getCasa(){
        return this.casa;
     }
     public void setCasa(Casa arg){
        this.casa = arg;
     }
     
     public Celda getPosicionAgente(){
        return this.posicionCarToy;
     }
     
     public void setPosicionAgente(Celda arg){
        this.posicionCarToy = arg;
     }
	
     public Celda getPosicionBoy() {
 		return posicionBoy;
 	}

 	public void setPosicionBoy(Celda posicionBoy) {
 		this.posicionBoy = posicionBoy;
 	}
 	
 	public void setPosicionAgente(int x, int y){
 		this.posicionCarToy = this.casa.getCelda(x, y);
 	}

 	public void setPosicionBoy(int x, int y){
 		this.posicionBoy = this.casa.getCelda(x, y);
 	}
}

