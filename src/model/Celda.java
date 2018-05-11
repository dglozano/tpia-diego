package model;

public class Celda {

    private TipoSuelo tipoSuelo;
    private int x;
    private int y;
    private double costo;
    private int visitas;
    private boolean descubierta;
    
    public Celda(){
    	this.tipoSuelo = TipoSuelo.COMUN;
    }
    
    public Celda(TipoSuelo tipoSuelo, Double costo){
    	this.tipoSuelo = tipoSuelo;
    }
    
	public TipoSuelo getTipoSuelo() {
		return tipoSuelo;
	}

	public void setTipoSuelo(TipoSuelo tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}
	
	public Celda clone(){
		Celda celdaClone = new Celda();
		
		celdaClone.x = this.x;
		celdaClone.y = this.y;
		celdaClone.visitas = this.visitas;
		celdaClone.descubierta = this.descubierta;
		celdaClone.tipoSuelo = this.tipoSuelo;
		celdaClone.costo = this.costo;
		
		return celdaClone;
	}
	
	@Override
	public boolean equals(Object c){
		return ((Celda) c).getX() == this.getX() && this.getY() == ((Celda) c).getY();
	}
	
	public String getChar(){
		String str = "";
		switch(this.tipoSuelo){
			case COMUN:
				str = "_";
				break;
			case PARED:
				str = "#";
				break;
			case PUERTA_ABIERTA:
				str = "o";
				break;
			case PUERTA_CERRADA:
				str = "c";
				break;
			case OBSTACULO:
				str = "$";
				break;
			case PASTO:
				str = "~";
				break;
			case ALFOMBRA:
				str = "\\";
				break;
			default:
				str = "?";
		}
		return str;
	}
	
	@Override
	public String toString(){
		return "<" + this.x + "," + this.y + "> " + this.getChar();
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
	
	public boolean esAccisble(){
		TipoSuelo ts = this.getTipoSuelo();
		return ts != TipoSuelo.PARED &&
				ts != TipoSuelo.OBSTACULO &&
				ts != TipoSuelo.PUERTA_CERRADA;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getCosto() {
		return costo;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	public void incrementarVisitas() {
		this.visitas = this.visitas + 1;
	}
	
	public boolean isDescubierta() {
		return descubierta;
	}

	public void setDescubierta(boolean descubierta) {
		this.descubierta = descubierta;
	}
}
