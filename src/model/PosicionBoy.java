package model;

public class PosicionBoy {
	
	private Celda posicionBoy;
	private Habitacion habitacionBoy;
	
	public PosicionBoy(){}
	
	public PosicionBoy(Celda posicionBoy, Habitacion habitacionBoy) {
		super();
		this.posicionBoy = posicionBoy;
		this.habitacionBoy = habitacionBoy;
	}

	public void setPosicionLlamada(Celda posicionBoy) {
		this.posicionBoy = posicionBoy;
	}
	
	public Celda getPosicionLlamada() {
		return posicionBoy;
	}

	public void setHabitacionLlamada(Habitacion habitacionBoy) {
		this.habitacionBoy = habitacionBoy;
	}

	public Habitacion getHabitacionLlamada() {
		return habitacionBoy;
	}
}
