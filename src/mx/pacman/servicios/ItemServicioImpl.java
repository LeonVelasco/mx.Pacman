package mx.pacman.servicios;

import java.sql.SQLException;
import java.util.List;

import mx.pacman.dao.ItemDao;
import mx.pacman.modelo.Vitamina;

public class ItemServicioImpl implements ItemServicio {
	static ItemDao vitaminaDao = new ItemDao();

	public void aparecerEnLaberinto() {
		System.out.println("Aparece Item");
	}

	public void desaparecerEnLaberinto() {
		System.out.println("Desaparece Item");
	}

	public void insertarDatosItem(List<Vitamina> listaVitaminas) {
		try {
			vitaminaDao.insertarDatosItem(listaVitaminas);

		} catch (SQLException e) {

		}
	}
}
