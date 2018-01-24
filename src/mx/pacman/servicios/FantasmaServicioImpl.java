package mx.pacman.servicios;

import java.util.List;
import mx.pacman.dao.FantasmasDao;
import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Personaje;
import mx.pacman.servicios.PersonajeServicio;
import mx.pacman.modelo.Tablero;

public class FantasmaServicioImpl implements PersonajeServicio {
	FantasmasDao fantasmaDao = new FantasmasDao();

	@Override
	public void comer(Personaje personaje) {

	}

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

	public void moverPersonaje(int direccion, Personaje personaje, Tablero tablero) {

		tablero.getTablero()[personaje.getPosX()][personaje.getPosY()] = '.';

		if (direccion == 1) {
			personaje.setPosX(personaje.getPosX() + 1);
			personaje.setPosY(personaje.getPosY() + 1);

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

	public void insertarDatosPersonaje(List<Fantasma> listaFantasmas) {
		try {
			FantasmasDao.insertarDatosPersonaje(listaFantasmas);
		} catch (Exception e) {

		}
	}

	@Override
	public void insertarDatosPersonaje(Personaje personaje) {
		// TODO Auto-generated method stub

	}

}
