package mx.pacman.dao;

import java.sql.SQLException;

import contoller.Game;
import mx.pacman.modelo.Tablero;

public class TableroDao extends ConectaDao {
	int row = 20;
	int col = 40;
	public TableroDao() {
		this.conectaBaseDatos();
		try {
			this.cierraConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public char[][] obtenerEstadoTableroById(int idJuego) throws SQLException {
		char[][] tableroNuevo = new char[row][col];

		try {
			miStatement = miConexion.createStatement();
			String sql = "SELECT caracter FROM estado_tablero WHERE id_juego = " + idJuego;
			miResultSet = miStatement.executeQuery(sql);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (miResultSet.next()) {
						tableroNuevo[i][j] = miResultSet.getString("caracter").charAt(0);

					}
				}
			}
			cierraConexion();
		} catch (Exception e) {
			cierraConexion();
			System.out.println("ResulSet No	 sirve!!!");
			e.printStackTrace();

		}
		return tableroNuevo;
	}

	public void insertarDatosTablero(Tablero tablero, int idJuego) {
		try{
			miStatement = miConexion.createStatement();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
						
					String sql = "INSERT INTO estado_tablero (indice_i, indice_j, caracter, id_Juego) VALUES(" 
					+ j 
					+ ", " 
					+ j 
					+ ", "
					+ "'" + tablero.getTablero()[i][j] + "'" +","
					+ idJuego
					+ ")";
					miStatement.executeUpdate(sql);
				}
			}
			System.out.println("Estado tablero guardado");
			cierraConexion();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	public String deleteDatosTablero(Tablero tablero) {
		// TODO Auto-generated method stub
		return null;
	}

}
