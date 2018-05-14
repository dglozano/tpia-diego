package frsf.cidisi.exercise.modelocartoy.search;

import model.Celda;
import utils.Matriz;
import model.Casa;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;
import interfaz.PrincipalNueva;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private Casa casa;
    
    private Celda posicionCarToy;
    private Celda posicionBoy;
    private List<Celda> eventosCercanos;
	
	public EstadoAmbiente() {
    	PrincipalNueva pp = PrincipalNueva.getInstancia();

        this.casa = new Casa(Matriz.crearMatrizDesdeChar(pp.plano));
        this.eventosCercanos = new ArrayList<Celda>();
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	PrincipalNueva pp = PrincipalNueva.getInstancia();

    	int x_agente = pp.posYagente, y_agente = pp.posXagente;
    	int x_boy = pp.posYninio, y_boy = pp.posXninio;
    	this.posicionBoy = this.casa.getCelda(x_boy,y_boy);
    	this.posicionCarToy = this.casa.getCelda(x_agente,y_agente);
    	
    	if(this.casa.isBetweenLimits(pp.posYevento1, pp.posXevento1))
    		this.eventosCercanos.add(this.casa.getCelda(pp.posYevento1, pp.posXevento1).clone());
    	if(this.casa.isBetweenLimits(pp.posYevento2, pp.posXevento2))
    		this.eventosCercanos.add(this.casa.getCelda(pp.posYevento2, pp.posXevento2).clone());
    	if(this.casa.isBetweenLimits(pp.posYevento3, pp.posXevento3))
    		this.eventosCercanos.add(this.casa.getCelda(pp.posYevento3, pp.posXevento3).clone());
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
			
			str.append(this.getEventosCercanos());
        
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

	public List<Celda> getEventosCercanos() {
		return eventosCercanos;
	}

	public void setEventosCercanos(List<Celda> eventosCercanos) {
		this.eventosCercanos = eventosCercanos;
	}
	
	public void remove(Celda c) {
		this.eventosCercanos.remove(c);
	}
}

