package mx.pacman.servicios;

import java.sql.SQLException;

import mx.pacman.dao.TableroDao;
import mx.pacman.modelo.Tablero;

public class TableroServicioImpl implements TableroServicio {
	TableroDao tableroDao = new TableroDao();

	public void insertarDatosTablero(Tablero tablero, int idJuego) {

		tableroDao.insertarDatosTablero(tablero, idJuego);

	}

	@Override
	public char[][] obtenerEstadoTableroById(int idJuego) {

		int row = 20;
		int col = 40;
		char[][] tableroNuevo = new char[row][col];
		try {
			tableroDao.obtenerEstadoTableroById(idJuego);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tableroNuevo;
	}

	public void cargarTablero(Tablero tablero, int idJuego) throws SQLException {

		tablero.setTablero(tableroDao.obtenerEstadoTableroById(idJuego));
		tablero.imprimirEscenario();

	}

}
