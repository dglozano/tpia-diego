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

	public  CarToyPerception() {
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
        AmbienteCarToy environment = (AmbienteCarToy) environmentIn;
        EstadoAmbiente environmentState =
                environment.getEnvironmentState();
        
       this.posicionBoy = environmentState.getPosicionBoy();
       this.celdasVecinas = environmentState.getCasa().getCeldasVecinas(environmentState.getPosicionAgente());
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append('\n');
        str.append("\n Posicion Boy: " + posicionBoy.getX() + ", " + posicionBoy.getY() );
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
}
