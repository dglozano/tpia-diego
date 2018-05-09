package model;

import java.util.List;

public class Obstaculo {
	
	private List<Celda> celdasObstaculo;
	
	public Obstaculo(List<Celda> celdasObstaculo) {
		super();
		this.celdasObstaculo = celdasObstaculo;
	}

	public void setCeldasObstaculo(List<Celda> celdasObstaculo) {
		this.celdasObstaculo = celdasObstaculo;
	}

	public List<Celda> getCeldasHabitacion() {
		return celdasObstaculo;
	}
}
