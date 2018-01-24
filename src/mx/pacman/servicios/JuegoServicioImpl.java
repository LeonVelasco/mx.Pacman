package mx.pacman.servicios;

import java.sql.SQLException;
import java.util.List;

import mx.pacman.dao.JuegoDao;
import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Vitamina;

public class JuegoServicioImpl implements JuegoServicio {
	
	JuegoDao juegoDao = new JuegoDao();
	String nombreArchivo = new String();

	public String obtenerNombreArchivoJuego() {
		// String nombreArchivo;
		try {
			juegoDao.obtenerNombreArchivoJuego();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreArchivo;

	}

	public void insertarTablaJuegoPacman(int idPersonaje, int idJuego) {

		try {
			juegoDao.insertarTablaJuegoPacman(idPersonaje, idJuego);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertarTablaJuegoItem(List<Vitamina> listaVitaminas, int idJuego) {

		try {
			juegoDao.insertarTablaJuegoItem(listaVitaminas, idJuego);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertarTablaJuegoFantasma(List<Fantasma> listaFantasmas, int idJuego) {

		try {
			juegoDao.insertarTablaJuegoFantasma(listaFantasmas, idJuego);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertarNombreJuego(int idJuego, String nombreArchivo) {

		try {
			juegoDao.insertarNombreJuego(idJuego, nombreArchivo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
