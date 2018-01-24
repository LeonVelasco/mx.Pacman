package mx.pacman.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaDao {
	protected static Connection miConexion;
	protected static Statement miStatement ; 
	protected ResultSet miResultSet;

	public void conectaBaseDatos() {

		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pacman?useSSL=false", "root","Alettaocean");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}	
	
	public static void cierraConexion() throws SQLException{
		if(miConexion != null){
			if(!miConexion.isClosed()){
				miConexion.isClosed();
			}
		}
				
	}
}
