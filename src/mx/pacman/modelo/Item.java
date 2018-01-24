package mx.pacman.modelo;

public abstract class Item {
	
	private int estadoItem = 1;
	private int idItem;
	private char caracterItem;
	private int posX = 0;
	private int posY = 0;

	
	
	
	public int getEstadoItem() {
		return estadoItem;
	}
	public void setEstadoItem(int estadoItem) {
		this.estadoItem = estadoItem;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	public void setCaracterItem(char caracterItem) {
		this.caracterItem = caracterItem;
	}
	public char getCaracterItem() {
		return caracterItem;
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
