package model;

public class Celda {

    private TipoSuelo tipoSuelo;
    private int x;
    private int y;
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
				str = "a";
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
				str = "\'";
				break;
			case AGUA:
				str = "!";
				break;
			case ARENA:
				str = "%";
				break;
			case BASURA:
				str = "*";
				break;
			case ROPA:
				str = "&";
				break;
			case ESCALERA_N:
				str = "N";
				break;
			case ESCALERA_O:
				str = "O";
				break;
			case ESCALERA_S:
				str = "S";
				break;
			case ESCALERA_E:
				str = "E";
				break;
			default:
				str = "?";
		}
		return str;
	}
	
	@Override
	public String toString(){
		return "<" + this.getChar() + "," + this.getVisitas() + "," + this.x + "," + this.y + "> " ;
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

	public double getCosto() {
		double costo = 0.0;
		switch(this.tipoSuelo){
			case COMUN:
				costo = 1.0;
				break;
			case PARED:
				costo = 1.0;
				break;
			case PUERTA_ABIERTA:
				costo = 1.0;
				break;
			case PUERTA_CERRADA:
				costo = 1.0;
				break;
			case OBSTACULO:
				costo = 9999.0;
				break;
			case PASTO:
				costo = 2.0;
				break;
			case ALFOMBRA:
				costo = 2.0;
				break;
			case AGUA:
				costo = 0.5;
				break;
			case ARENA:
				costo = 2.0;
				break;
			case BASURA:
				costo = 2.0;
				break;
			case ROPA:
				costo = 2.0;
				break;
			case ESCALERA_N:
				costo = 1.0;
				break;
			case ESCALERA_O:
				costo = 1.0;
				break;
			case ESCALERA_S:
				costo = 1.0;
				break;
			case ESCALERA_E:
				costo = 1.0;
				break;
			default:
				costo = 1.0;
		}
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
