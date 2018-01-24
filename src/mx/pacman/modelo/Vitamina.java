 package mx.pacman.modelo;

public class Vitamina extends Item {
	private String nombreVitamina;

	public Vitamina(int id, String nombre, int posX, int posY) {
		this.setIdItem(id);
		this.setCaracterItem('#');
		this.setPosX(posX);
		this.setPosY(posY);
		this.setNombreVitamina(nombre);

	}
	
	
	public String getNombreVitamina() {
		return nombreVitamina;
	}

	public void setNombreVitamina(String colorVitamina) {
		this.nombreVitamina = colorVitamina;
	}

}
