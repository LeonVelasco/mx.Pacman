package mx.pacman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Personaje;

public class FantasmasDao extends ConectaDao {
	
	
	public FantasmasDao() {
		this.conectaBaseDatos();
		try {
			this.cierraConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int obtenerIdPersonaje(List<Fantasma>  listaFantasmas, int idPersonaje) throws SQLException {
		
		try{
			miStatement = miConexion.createStatement();
			String sql = "SELECT * FROM fantasma WHERE id_fantasma =" + idPersonaje;
			miResultSet = miStatement.executeQuery(sql);
			while (miResultSet.next()){
				idPersonaje = miResultSet.getInt("id_fantasma");
				System.out.println("id_fantasma: " + idPersonaje);
			}
			cierraConexion();
			
		}catch(Exception e){
			cierraConexion();
			System.out.println("ResulSet No	 sirve!!!");
			e.printStackTrace();
			
		}
		return idPersonaje;
	}


	public static void insertarDatosPersonaje(List<Fantasma> listaFantasmas) throws SQLException {
		try{
			miStatement = miConexion.createStatement();
			for (int j = 0; j < listaFantasmas.size(); j++) {
			
			String sql = "INSERT INTO fantasma (char_personaje_fantasma, color_fantasma, estado_fantasma, posx_fantasma, posy_fantasma) values(" 
					+ "'"
					+ listaFantasmas.get(j).getCaracterPersonaje()+"'"
					+ ", "
					+ "'" + listaFantasmas.get(j).getColorFantasma() + "'"
					+ ", "
					+ listaFantasmas.get(j).getEstadoPersonaje()
					+ ", "
					+ listaFantasmas.get(j).getPosX()
					+ ", "
					+ listaFantasmas.get(j).getPosY()
					+")";
			miStatement.executeUpdate(sql);
		}System.out.println("Datos fantasmas guardados");
		cierraConexion();
		}catch (SQLException e) {
			cierraConexion();
			e.printStackTrace();
		}
	
	}


	public void guardarDatosPersonaje(List<Fantasma> listaFantasmas) throws SQLException {
		try {
			for (int i = 0; i < listaFantasmas.size(); i++) { 
				int posActualX = listaFantasmas.get(i).getPosX();
				int posActualY = listaFantasmas.get(i).getPosY();
				miStatement = miConexion.createStatement();
				String sql = "UPDATE fantasma SET estado_fantasma = "
						+ listaFantasmas.get(i).getEstadoPersonaje()
						+ ","
						+ "posx_fantasma = " + posActualX 
						+ ", "
						+ "posy_fantasma = " + posActualY 
						+ " WHERE id_fantasma = " 
						+ listaFantasmas.get(i).getIdPersonaje();
				miStatement.executeUpdate(sql);
			}
			
			System.out.println("Guardó fantasmas");
			cierraConexion();

		} catch (SQLException e) {
			System.out.println("No guardó fantasmas");
			cierraConexion();
			e.printStackTrace();
		}
	}


	public void deleteDatosPersonaje(List<Fantasma> listaFantasmas) {
		
		return ;
	}
	
	public Fantasma obtenerFantasmaById(int idFantasma) throws SQLException{
		Fantasma fantasma = null;
		try{
			miStatement = miConexion.createStatement();
			String sql = "SELECT * FROM fantasma WHERE id_fantasma = " + idFantasma;
			miResultSet = miStatement.executeQuery(sql);
			while(miResultSet.next()){
				fantasma.setIdPersonaje(miResultSet.getInt("id_fantasma"));
				fantasma.setCaracterPersonaje(miResultSet.getString("char_personaje_fantasma").charAt(0));
				fantasma.setColorFantasma(miResultSet.getString("color_fantasma"));
				fantasma.setEstadoPersonaje(miResultSet.getInt("estado_fantasma"));
				fantasma.setPosX(miResultSet.getInt("posx_fantasma"));
				fantasma.setPosY(miResultSet.getInt("posy_fantasma"));
			}
			cierraConexion();
		}catch(SQLException e){
			cierraConexion();	
		}
		return new Fantasma();
	}
	
	public Fantasma crearNuevoFantasma(Fantasma fantasma) throws SQLException{
		try{
			miStatement = miConexion.createStatement();
			String sql = "SELECT char_personaje, posx, posy FROM pos_originales WHERE id_fantasma = " +fantasma.getIdPersonaje();
			miResultSet = miStatement.executeQuery(sql);
			fantasma.setCaracterPersonaje(miResultSet.getString("char_personaje").charAt(0));
			fantasma.setPosX(miResultSet.getInt("posx"));
			fantasma.setPosY(miResultSet.getInt("posy"));
		}catch(SQLException e){
			cierraConexion();
		}
		return fantasma;
	}
	
	
	
}
