package frsf.cidisi.exercise.modelocartoy.search;

import java.util.ArrayList;
import java.util.List;

import model.Celda;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CarToyPerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;   
	
    private List<Celda> celdasVecinas;
    private Celda posicionBoy;
    private List<Celda> eventosCercanos;

	public  CarToyPerception() {
		this.eventosCercanos = new ArrayList<Celda>();
		this.celdasVecinas = new ArrayList<Celda>();
    }

    public CarToyPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
        CarToy agent = (CarToy) agentIn;
        EstadoCarToy agentState = (EstadoCarToy) agent.getAgentState();
        AmbienteCarToy environment = (AmbienteCarToy) environmentIn;
        EstadoAmbiente environmentState =
                environment.getEnvironmentState();
        
       this.celdasVecinas = environmentState.getCasa().getCeldasVecinas(agentState.getPosicionCarToy());
       this.eventosCercanos = new ArrayList<Celda>();
       for(Celda c : this.celdasVecinas) {
    	   if(environmentState.getEventosCercanos().contains(c)) {
    		   this.addEventoCercano(c.clone());
    	   }
    	   if(environmentState.getPosicionBoy().equals(c)) {
    		   this.setPosicionBoy(c.clone());
    	   }
       }
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append('\n');
        str.append("\n Celdas Vecinas: \n");
        for(Celda c: this.celdasVecinas){
        	str.append(c.toString());
        	str.append("\n");
        }
        return str.toString();
    }

	public List<Celda> getCeldasVecinas() {
		return celdasVecinas;
	}

	public void setCeldasVecinas(List<Celda> celdasVecinas) {
		this.celdasVecinas = celdasVecinas;
	}
	
	public void addCeldaVecina(Celda c){
		this.celdasVecinas.add(c);
	}

	public Celda getPosicionBoy() {
		return posicionBoy;
	}

	public void setPosicionBoy(Celda posicionBoy) {
		this.posicionBoy = posicionBoy;
	}

	public List<Celda> getEventosCercanosDescubiertos() {
		return eventosCercanos;
	}

	public void setEventosCercanosDescubiertos(List<Celda> eventosCercanos) {
		this.eventosCercanos = eventosCercanos;
	}
	
	public void addEventoCercano(Celda e){
		this.eventosCercanos.add(e);
	}
	
}
