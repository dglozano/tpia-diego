package frsf.cidisi.exercise.modelocartoy.search;

import model.Casa;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CarToyMain {

    public static void main(String[] args) throws PrologConnectorException {
        
        CarToy agent = new CarToy();
        
        AmbienteCarToy environment = new AmbienteCarToy();
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
