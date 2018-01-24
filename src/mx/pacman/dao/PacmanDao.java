package mx.pacman.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jboss.resource.adapter.jdbc.vendor.SybaseExceptionSorter;

import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Pacman;
import mx.pacman.modelo.Personaje;
import mx.pacman.modelo.Tablero;
import mx.pacman.servicios.PersonajeServicio;

public class PacmanDao extends ConectaDao {

	public PacmanDao() {

		try {
			this.conectaBaseDatos();
			this.cierraConexion();
			// this.cierraConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int obtenerIdPersonaje(Personaje personaje, int idPersonaje) throws SQLException {

		try {
			miStatement = miConexion.createStatement();
			String sql = "SELECT * FROM pacman WHERE id_pacman = " + idPersonaje;
			miResultSet = miStatement.executeQuery(sql);
			while (miResultSet.next()) {
				idPersonaje = miResultSet.getInt("id_pacman");
				System.out.println("id_personaje: " + idPersonaje);
			}
			cierraConexion();
		} catch (Exception e) {
			cierraConexion();
			System.out.println("ResulSet No	 sirve!!!");
			e.printStackTrace();

		}
		return idPersonaje;

	}

	public void insertarDatosPersonaje(Personaje personaje) throws SQLException {
		try {
			miStatement = miConexion.createStatement();
			String sql = "INSERT INTO pacman (char_personaje_pacman, posx_pacman, posy_pacman, estado_pacman) values("
					+ "'" + personaje.getCaracterPersonaje() + "'" + ", " + personaje.getPosX() + ", "
					+ personaje.getPosY() + ", " + personaje.getEstadoPersonaje() + ")";
			miStatement.executeUpdate(sql);
			System.out.println("Datos pacman guardados");
			cierraConexion();
		} catch (SQLException e) {
			cierraConexion();
			e.printStackTrace();
		}

	}

	public void guardarDatosPersonaje(Personaje personaje) throws SQLException {

		try {
			int posActualX = personaje.getPosX();
			int posActualY = personaje.getPosY();
			miStatement = miConexion.createStatement();
			String sql = "UPDATE pacman SET posx_pacman = " + posActualX + ", " + "posy_pacman = " + posActualY + ", "
					+ "estado_pacman = " + personaje.getEstadoPersonaje() + " WHERE id_pacman = "
					+ personaje.getIdPersonaje();
			miStatement.executeUpdate(sql);
			System.out.println("Datos pacman guardados");
			cierraConexion();
		} catch (SQLException e) {
			cierraConexion();

		}

	}

	public void deleteDatosPersonaje(Personaje personaje) {

	}

}
