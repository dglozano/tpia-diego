

package frsf.cidisi.exercise.modelocartoy.search;

import javax.swing.SwingUtilities;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;
import interfaz.PrincipalNueva;
import model.Celda;

public class ObjetivoCarToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoCarToy estado = (EstadoCarToy) agentState;
    	Celda proxObjetivo = estado.getProximoObjetivo();
    	boolean llegoProxObj = proxObjetivo != null && estado.getPosicionCarToy().equals(proxObjetivo);
        if (llegoProxObj) {
            return true;
        }
        return false;
	}
}