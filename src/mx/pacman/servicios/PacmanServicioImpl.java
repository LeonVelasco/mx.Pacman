package mx.pacman.servicios;

import java.sql.SQLException;
import java.util.List;

import mx.pacman.dao.FantasmasDao;
import mx.pacman.dao.PacmanDao;
import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Pacman;
import mx.pacman.modelo.Personaje;
import mx.pacman.modelo.Tablero;

public class PacmanServicioImpl implements PersonajeServicio {
	PacmanDao pacmanDao = new PacmanDao();

	@Override
	public void comer(Personaje personaje) {
		
	}

	@Override
	public boolean sePuedeMover(int direccion, Personaje personaje, Tablero tablero) {
		if (direccion == 1 && personaje.getPosX() < tablero.getTablero().length - 1
				&& personaje.getPosY() < tablero.getTablero().length - 1) {
			if (tablero.getTablero()[personaje.getPosX() + 1][personaje.getPosY() + 1] == '.') {
				return true;
			}
		}
		if (direccion == 2 && personaje.getPosX() < tablero.getTablero().length - 1) {
			if (tablero.getTablero()[personaje.getPosX() + 1][personaje.getPosY()] == '.') {
				return true;
			}
		}
		if (direccion == 3 && personaje.getPosY() < tablero.getTablero().length - 1) {
			if (tablero.getTablero()[personaje.getPosX()][personaje.getPosY() + 1] == '.') {
				return true;
			}
		}
		if (direccion == 4 && personaje.getPosX() < tablero.getTablero().length
				&& personaje.getPosY() < tablero.getTablero().length - 1 && personaje.getPosX() > 0) {
			if (tablero.getTablero()[personaje.getPosX() - 1][personaje.getPosY() + 1] == '.') {
				return true;
			}
		}

		if (direccion == 5 && personaje.getPosX() < tablero.getTablero().length - 1 && personaje.getPosY() > 0) {
			if (tablero.getTablero()[personaje.getPosX() + 1][personaje.getPosY() - 1] == '.') {
				return true;
			}
		}
		return false;

	}

	@Override
	public void moverPersonaje(int direccion, Personaje personaje, Tablero tablero) {
		tablero.getTablero()[personaje.getPosX()][personaje.getPosY()] = ' ';

		if (direccion == 1) {
			personaje.setPosX(personaje.getPosX() + 11);
			personaje.setPosY(personaje.getPosY() + 20);

		}
		if (direccion == 2) {
			personaje.setPosX(personaje.getPosX() + 1);

		}
		if (direccion == 3) {
			personaje.setPosY(personaje.getPosY() + 1);

		}
		if (direccion == 4) {
			personaje.setPosX(personaje.getPosX() - 1);
			personaje.setPosY(personaje.getPosY() + 1);

		}
		if (direccion == 5) {
			personaje.setPosX(personaje.getPosX() + 1);
			personaje.setPosY(personaje.getPosY() - 1);

		}

		tablero.getTablero()[personaje.getPosX()][personaje.getPosY()] = personaje.getCaracterPersonaje();
	}

	public void insertarDatosPersonaje(Personaje personaje) {
		try {
			pacmanDao.insertarDatosPersonaje(personaje);

		} catch (Exception e) {

		}

	}

	public void guardarDatosPersonaje(Personaje personaje) throws SQLException {

	}

	public void deleteDatosPersonaje(Personaje personaje) {

	}

	@Override
	public void insertarDatosPersonaje(List<Fantasma> listaFantasmas) {
		// TODO Auto-generated method stub

	}

}
