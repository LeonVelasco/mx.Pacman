package mx.pacman.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contoller.Game;
import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Pacman;
import mx.pacman.modelo.Personaje;
import mx.pacman.modelo.Tablero;
import mx.pacman.modelo.Vitamina;

public class JuegoDao extends ConectaDao {

	public JuegoDao() {
		this.conectaBaseDatos();
		try {
			this.cierraConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> obtenerNombreArchivoJuego() throws SQLException {

		try {
			List<String> nombreArchivo = new ArrayList<String>();
			miStatement = miConexion.createStatement();
			String sql = "SELECT * FROM juego";
			miResultSet = miStatement.executeQuery(sql);
			while (miResultSet.next()) {
				nombreArchivo.add(miResultSet.getString("nombre_Carpeta"));
				System.out.print(miResultSet.getInt("id_juego"));
				System.out.println(" " + miResultSet.getString("nombre_carpeta"));
			}
			cierraConexion();
			return nombreArchivo;
		} catch (Exception e) {
			cierraConexion();
			System.out.println("ResulSet No	Sirve!");

		}
		return null;
	}

	public void guardarDatosJuego(int idJuego) throws SQLException {
		System.out.println(idJuego);
		try {
			miStatement = miConexion.createStatement();
			String sql = "UPDATE juego set id_juego =" + idJuego;
			miStatement.executeUpdate(sql);
			System.out.println("Datos juego guardados");
			cierraConexion();
		} catch (SQLException e) {
			System.out.println("no guardo datos juego");
			cierraConexion();
		}

	}

	public int obtenerIdTablero(Tablero tablero, int idTablero) throws SQLException {

		try {
			miStatement = miConexion.createStatement();
			String sql = "SELECT * FROM tablero where id_tablero = " + idTablero;
			miResultSet = miStatement.executeQuery(sql);
			while (miResultSet.next()) {
				idTablero = miResultSet.getInt("id_tablero");
				System.out.println("id_tablero: " + idTablero);
			}
			cierraConexion();
		} catch (Exception e) {
			cierraConexion();
			System.out.println("ResulSet No	 sirve!!!");

		}
		return idTablero;

	}

	public void insertarTablaJuegoPacman(int idPersonaje, int idJuego) throws SQLException {

		try {
			miStatement = miConexion.createStatement();
			String sql = "INSERT INTO juego_pacman (pacman_id_pacman, juego_id_juego) VALUES (" + idPersonaje + ", "
					+ idJuego + ")";
			miStatement.executeUpdate(sql);
			System.out.println("Tabla juego_pacman guardada");
			cierraConexion();
		} catch (SQLException e) {
			System.out.println("no guardo tabla juego_pacman");
			cierraConexion();
		}

	}

	public void insertarTablaJuegoItem(List<Vitamina> listaVitaminas, int idJuego) throws SQLException {
		try {
			miStatement = miConexion.createStatement();
			for (int i = 0; i < listaVitaminas.size(); i++) {
				String sql = "INSERT INTO juego_item (item_id_item, juego_id_juego) VALUES ("
						+ listaVitaminas.get(i).getIdItem() + ", " + idJuego + ")";
				miStatement.executeUpdate(sql);
			}
			System.out.println("Tabla juego_item guardado");
			cierraConexion();
		} catch (SQLException e) {
			System.out.println("no guardo tabla juego_item");
			cierraConexion();
		}

	}

	public void insertarTablaJuegoFantasma(List<Fantasma> listaFantasmas, int idJuego) throws SQLException {
		try {
			miStatement = miConexion.createStatement();
			for (int i = 0; i < listaFantasmas.size(); i++) {
				String sql = "INSERT INTO juego_fantasma (fantasma_id_fantasma, juego_id_juego) VALUES ("
						+ listaFantasmas.get(i).getIdPersonaje() + ", " + idJuego + ")";
				miStatement.executeUpdate(sql);
			}

			System.out.println("Tabla juego_fantasma guardado");
			cierraConexion();
		} catch (SQLException e) {
			System.out.println("no guardo tabla juego_fantasma");
			cierraConexion();
		}

	}

	public void insertarNombreJuego(int idJuego, String nombreArchivo) throws SQLException {
		
		try {
			miStatement = miConexion.createStatement();
			String sql = "UPDATE juego SET nombre_carpeta =" + " \" " + nombreArchivo + " \" " + "WHERE id_juego ="
					+ idJuego;
			miStatement.executeUpdate(sql);
			System.out.println("Nombre guardado");
			cierraConexion();
		} catch (SQLException e) {
			System.out.println("no guardo nombre");
			cierraConexion();
		}
	}
}
