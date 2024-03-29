package frsf.cidisi.exercise.modelocartoy.search;

import model.*;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCarToy extends Environment {

    public AmbienteCarToy() {
        // Create the environment state
        this.environmentState = new EstadoAmbiente();
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  CarToyPerception getPercept() {
        // Create a new perception to return
         CarToyPerception perception = new CarToyPerception();
		         
         EstadoAmbiente environmentState = this.getEnvironmentState();
         List<Celda> celdasVecinas = environmentState.getCasa().getCeldasVecinas(environmentState.getPosicionAgente());
         
         List<Celda>  eventosCercanos = new ArrayList<Celda>();
         for(Celda c : celdasVecinas) {
      	   if(environmentState.getEventosCercanos().contains(c)) {
      		 perception.addEventoCercano(c.clone());
      	   }
      	   if(environmentState.getPosicionBoy().equals(c)) {
      		 perception.setPosicionBoy(c.clone());
      	   }
         }
         
         perception.setCeldasVecinas(celdasVecinas);
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState =
                this.getEnvironmentState();
        //si no hay mas eventos y no llego al ninio, falla
        if(envState.getEventosCercanos().isEmpty() && !envState.getPosicionAgente().equals(envState.getPosicionBoy())) {
        	return true;
        }

        return false;
    }
}
