package model;

public class Celda implements Comparable {

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
	
	public char getChar(){
		char chr;
		switch(this.tipoSuelo){
			case COMUN:
				chr = '_';
				break;
			case PARED:
				chr = '#';
				break;
			case PUERTA_ABIERTA:
				chr = 'a';
				break;
			case PUERTA_CERRADA:
				chr = 'c';
				break;
			case OBSTACULO:
				chr = '$';
				break;
			case PASTO:
				chr = '~';
				break;
			case ALFOMBRA:
				chr = '\'';
				break;
			case AGUA:
				chr = '!';
				break;
			case ARENA:
				chr = '%';
				break;
			case BASURA:
				chr = '*';
				break;
			case ROPA:
				chr = '&';
				break;
			case ESCALERA_N:
				chr = 'N';
				break;
			case ESCALERA_O:
				chr = 'O';
				break;
			case ESCALERA_S:
				chr = 'S';
				break;
			case ESCALERA_E:
				chr = 'E';
				break;
			default:
				chr = '?';
		}
		return chr;
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

	@Override
	public int compareTo(Object arg0) {
		Celda celdaComparada = (Celda) arg0;
		if(celdaComparada.getX() < this.getX())
			return -1;
		else if (celdaComparada.getX() > this.getX())
			return 1;
		else if(celdaComparada.getY() < this.getY())
			return -1;
		else if(celdaComparada.getY() > this.getY())
			return 1;
		else return 0;
	}
}
