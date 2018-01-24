package contoller;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Game jugada = new Game();
		
		System.out.println("PACMAN");
		System.out.println("1- Juego Nuevo   \n2- Continuar Juego");
		Scanner x = new Scanner(System.in);
		int juegoNuevo = x.nextInt();
		if (juegoNuevo == 1) {
			jugada.iniciaJuego();
			jugada.guardaJuego();
		} else {
			jugada.eligeJuego();
		
		}
		
	}

}
