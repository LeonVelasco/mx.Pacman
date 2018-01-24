package mx.pacman.modelo;

public abstract class Personaje{
	
	private int estadoPersonaje;
	private int idPersonaje;
	private char caracterPersonaje;
	private int posX;
	private int posY;
	
		
	public int getEstadoPersonaje() {
		return estadoPersonaje;
	}

	public void setEstadoPersonaje(int estadoPersonaje) {
		this.estadoPersonaje = estadoPersonaje;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public void setCaracterPersonaje(char caracterPersonaje) {
		this.caracterPersonaje = caracterPersonaje;
	}

	public char getCaracterPersonaje() {
		return caracterPersonaje;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
