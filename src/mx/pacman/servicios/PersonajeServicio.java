 package mx.pacman.servicios;

import java.util.List;

import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Personaje;
import mx.pacman.modelo.Tablero;

public interface PersonajeServicio {

	public void insertarDatosPersonaje(Personaje personaje);
	
	public void insertarDatosPersonaje(List<Fantasma> listaFantasmas);
	
	public void comer(Personaje personaje);
		
	public boolean sePuedeMover(int direccion, Personaje personaje, Tablero tablero);
	
	public void moverPersonaje(int direccion, Personaje personaje, Tablero tablero);

	
	
	
			
}
	
