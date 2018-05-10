package frsf.cidisi.exercise.modelocartoy.search;

import model.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCarToy extends Environment {

    public AmbienteCarToy(Casa casa) {
        // Create the environment state
        this.environmentState = new EstadoAmbiente(casa);
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
         perception.setPosicionBoy(environmentState.getPosicionBoy());
         perception.setCeldasVecinas(environmentState.getCasa().
        		 getCeldasVecinas(environmentState.getPosicionAgente()));
         
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState =
                this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }
}
