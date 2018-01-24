package mx.pacman.servicios;

import java.sql.SQLException;

import mx.pacman.modelo.Tablero;

public interface TableroServicio {

	public void insertarDatosTablero(Tablero tablero, int idJuego);
	
	public char [][] obtenerEstadoTableroById(int idJuego);

	public void cargarTablero(Tablero tablero, int idJuego) throws SQLException;
	
}
