package mx.pacman.dao;

import java.sql.SQLException;
import java.util.List;

import mx.pacman.modelo.Item;
import mx.pacman.modelo.Vitamina;

public class ItemDao extends ConectaDao {

	public ItemDao() {
		this.conectaBaseDatos();
		try {
			this.cierraConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public int obtenerIdItem(List<Vitamina> listaVitaminas, int idItem) throws SQLException {

		try {
			miStatement = miConexion.createStatement();
			String sql = "SELECT * FROM item WHERE id_item = " + idItem;
			miResultSet = miStatement.executeQuery(sql);
			while (miResultSet.next()) {
				idItem = miResultSet.getInt("id_item");
				System.out.println("id_item: " + idItem);
			}
			cierraConexion();
		} catch (Exception e) {
			cierraConexion();
			System.out.println("ResulSet No	 sirve!!!");

		}
		return idItem;
	}


	public void insertarDatosItem(List<Vitamina> listaVitaminas) throws SQLException {
		try {
			miStatement = miConexion.createStatement();
			for (int j = 0; j < listaVitaminas.size(); j++) {

				String sql = "INSERT INTO item (nombre_item, char_item, estado_item, posx_item, posy_item) values("
						+ "'" + listaVitaminas.get(j).getNombreVitamina() + "'" + ", " + "'"
						+ listaVitaminas.get(j).getCaracterItem() + "'" + ", " + listaVitaminas.get(j).getEstadoItem()
						+ ", " + listaVitaminas.get(j).getPosX() + ", " + listaVitaminas.get(j).getPosY() + ")";
				miStatement.executeUpdate(sql);
			}
			System.out.println("Datos item guardados");
			cierraConexion();
		} catch (SQLException e) {
			cierraConexion();
			e.printStackTrace();
		}

	}

	
	public void guardarDatosItem(List<Vitamina> listaVitaminas) throws SQLException {
		try {
			for (int i = 0; i < listaVitaminas.size(); i++) {
				int posActualX = listaVitaminas.get(i).getPosX();
				int posActualY = listaVitaminas.get(i).getPosY();
				miStatement = miConexion.createStatement();
				String sql = "UPDATE item SET estado_item = " + listaVitaminas.get(i).getEstadoItem() + ", "
						+ "posx_item = " + posActualX + ", " + "posy_item = " + posActualY + " WHERE id_item = "
						+ listaVitaminas.get(i).getIdItem();
				miStatement.executeUpdate(sql);
			}
			System.out.println("Guardó vitaminas");
			cierraConexion();
		} catch (SQLException e) {
			cierraConexion();
			System.out.println("No guardó vitaminas");
		}

	}


	public void deleteDatosItem(List<Vitamina> listaVitaminas) {
		// TODO Auto-generated method stub

	}
	
}
