package frsf.cidisi.exercise.modelocartoy.search;

import model.Casa;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class CarToyMain {

    public static void main(String[] args) throws PrologConnectorException {
        Casa casa = new Casa();
        
        casa.setPosicionAgente(1,1);
        casa.setPosicionBoy(8,8);
        
        CarToy agent = new CarToy(casa);
        
        AmbienteCarToy environment = new AmbienteCarToy(casa);
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
