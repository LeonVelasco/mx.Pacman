package mx.pacman.servicios;

import java.util.List;

import contoller.Game;
import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Vitamina;

public interface JuegoServicio {
	
	public String obtenerNombreArchivoJuego();
	
	public void insertarTablaJuegoPacman(int idPersonaje, int idJuego);
	
	public void insertarTablaJuegoItem(List<Vitamina> listaVitaminas, int idJuego);
	
	public void insertarTablaJuegoFantasma(List<Fantasma> listaFantasmas, int idJuego);

	public void insertarNombreJuego(int idJuego, String nombreArchivo);

}
