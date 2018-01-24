package mx.pacman.servicios;

import java.util.List;

import mx.pacman.modelo.Vitamina;

public interface ItemServicio {
	
	public void aparecerEnLaberinto();
	
	public void desaparecerEnLaberinto();

	public void insertarDatosItem(List<Vitamina> listaVitaminas); 

}
