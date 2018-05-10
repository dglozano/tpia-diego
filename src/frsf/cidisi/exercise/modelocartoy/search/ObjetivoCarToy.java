

package frsf.cidisi.exercise.modelocartoy.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoCarToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoCarToy estado = (EstadoCarToy) agentState;
        if  (estado.getPosicionCarToy().equals(estado.getPosicionBoy())) //(posicionAgente.equals(Boy.getPosicion))
        	{
            return true;
        	}
        return false;
	}
}