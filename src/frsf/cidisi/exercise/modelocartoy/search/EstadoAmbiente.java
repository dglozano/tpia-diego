package frsf.cidisi.exercise.modelocartoy.search;

import model.Celda;
import model.Casa;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private Casa casa;
    
    private Celda posicionCarToy;
    private Celda posicionBoy;
	
	public EstadoAmbiente(Casa casa) {
        
        this.casa = casa;
        this.posicionBoy = new Celda();
        this.posicionCarToy = new Celda();
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	this.posicionBoy = casa.getPosicionBoy();
    	this.posicionCarToy = casa.getPosicionAgente();
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str += "Estado del ambiente: \n";
		
        str += this.casa.toString();
        
        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public Casa getCasa(){
        return this.casa;
     }
     public void setplanoCasa(Casa arg){
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
 		this.casa.setPosicionAgente(x, y);
 		this.posicionCarToy = this.casa.getPosicionAgente();
 	}

 	public void setPosicionBoy(int x, int y){
 		this.casa.setPosicionBoy(x, y);
 		this.posicionBoy = this.casa.getPosicionBoy();
 	}
}

