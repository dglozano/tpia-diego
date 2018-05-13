package frsf.cidisi.exercise.modelocartoy.search;


import frsf.cidisi.exercise.modelocartoy.search.actions.*;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

import model.Casa;

public class CarToy extends SearchBasedAgent {

    public CarToy() {

        // The Agent Goal
        ObjetivoCarToy agGoal = new ObjetivoCarToy();

        // The Agent State
        EstadoCarToy agState = new EstadoCarToy();
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new IrNorte());
        operators.addElement(new IrOeste());
        operators.addElement(new IrSur());
        operators.addElement(new IrEste());
        
        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {
    	
    	Strategy strategy = null;
        // Create the search strategy
    	//strategy = new DepthFirstSearch();
    	strategy = new BreathFirstSearch();   
 		//IStepCostFunction cost = new CostFunction();

 		//strategy = new UniformCostSearch(cost); 
    	//strategy = new AStarSearch(new CostFunction(), new Heuristic());

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(CarToy.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
