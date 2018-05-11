package frsf.cidisi.exercise.modelocartoy.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Celda;
import model.Casa;
import model.TipoSuelo;
import utils.Matriz;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoCarToy extends SearchBasedAgentState {
	
    private Casa casa;
    
    private Celda posicionCarToy;
	private Celda posicionBoy;
    
    private double costo;
	
    public EstadoCarToy() {
    
        this.casa = new Casa(Matriz.crearMatrizDesdeArchivo("mapa-chico-sin-descubrir.txt"));
        this.initState();
    }
    
    /**
     * This method is optional, and sets the initial state of the agent.
     */
    /* (non-Javadoc)
     * @see frsf.cidisi.faia.state.State#initState()
     */
    @Override
    public void initState() {
    	this.posicionBoy = this.casa.getCelda(14,5);
    	this.posicionCarToy = this.casa.getCelda(1,1);
        this.costo = 0.0;
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	EstadoCarToy estadoClone = new EstadoCarToy();
    	
    	estadoClone.setCasa(this.casa.clone());
    		
    	estadoClone.setPosicionCarToy(this.posicionCarToy.clone());
    	estadoClone.setPosicionBoy(this.posicionBoy.clone());
        	
    	estadoClone.costo = this.costo;
    	
        return estadoClone;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
    	CarToyPerception carToyPerception = (CarToyPerception) p;
    	
    	for(Celda celdaVecina: carToyPerception.getCeldasVecinas()){
    		this.casa.getCelda(celdaVecina.getX(), celdaVecina.getY()).setCosto(celdaVecina.getCosto());
    		this.casa.getCelda(celdaVecina.getX(), celdaVecina.getY()).setTipoSuelo(celdaVecina.getTipoSuelo());
    		this.casa.getCelda(celdaVecina.getX(), celdaVecina.getY()).setDescubierta(true);
    	}
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
       
        str.append("\n");
		for(int i = 0; i < this.casa.X_CELLS ; i++){
			str.append("|");
			for (int j = 0; j < this.casa.Y_CELLS; j++){
				if(this.posicionCarToy != null && this.posicionCarToy.getX() == i && this.posicionCarToy.getY() == j)
					str.append("A|");
				else if(this.casa.getCelda(i, j).isDescubierta()){
					if(this.posicionBoy != null && this.posicionBoy.getX() == i && this.posicionBoy.getY() == j) 
						str.append("B|");
					else 
						str.append(this.casa.getCelda(i, j).getChar() + "|");
				} else {
					str.append("x|");
				}
				
			}
			str.append("\n");
		}
        return str.toString();
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       EstadoCarToy estadoComparado = (EstadoCarToy) obj;
       
       // Comparo que esten en la misma posicion
       boolean mismaPosicion;
       mismaPosicion = estadoComparado.getPosicionCarToy().getX() == this.getPosicionCarToy().getX() &&
       estadoComparado.getPosicionCarToy().getY() == this.getPosicionCarToy().getY();
       
       
       boolean mismasDescubiertas = true;

       for(int i=0 ; i<this.casa.X_CELLS; i++) {
    	   for(int j=0; j<this.casa.Y_CELLS; j++) {
    		   if(this.casa.getCelda(i, j).isDescubierta() != estadoComparado.getCasa().getCelda(i, j).isDescubierta()) {
    			   mismasDescubiertas = false;
    			   break;
    		   }
    	   }
       }
     
       return mismaPosicion && mismasDescubiertas; 
    }

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setPosicionCarToy(Celda posicionCarToy) {
		this.posicionCarToy = posicionCarToy;
	}

	public Celda getPosicionCarToy() {
		return posicionCarToy;
	}

	public Celda getPosicionBoy() {
		return posicionBoy;
	}

	public void setPosicionBoy(Celda posicionBoy) {
		this.posicionBoy = posicionBoy;
	}
	
	public double getCosto(){

		return this.costo;
	}

	public void incrementarCosto(double costo){

		this.costo += costo;
	}
}

