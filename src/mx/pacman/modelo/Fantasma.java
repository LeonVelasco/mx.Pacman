package mx.pacman.modelo;

import mx.pacman.dao.FantasmasDao;

public class Fantasma extends Personaje {
	private String colorFantasma;
	
	public Fantasma(){
		
	}
	
	public Fantasma(int idFantasma, String color, int posX, int posY){
		this.setIdPersonaje(idFantasma);
		this.setCaracterPersonaje('n');
		this.setColorFantasma(color);
		this.setPosX(posX);
		this.setPosY(posY);
	}
	
	public String getColorFantasma() {
		return colorFantasma;
	}

	public void setColorFantasma(String colorFantasma) {
		this.colorFantasma = colorFantasma;
	}
}
