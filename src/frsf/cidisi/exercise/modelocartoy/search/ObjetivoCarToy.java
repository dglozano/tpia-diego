

package frsf.cidisi.exercise.modelocartoy.search;

import javax.swing.SwingUtilities;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;
import interfaz.PrincipalNueva;

public class ObjetivoCarToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoCarToy estado = (EstadoCarToy) agentState;
        if  (estado.getPosicionCarToy().equals(estado.getPosicionBoy())) {
            return true;
        	}
        return false;
	}
}