package mx.pacman.modelo;

public class Pacman extends Personaje {
	public String nombrePacman  ="player1";
	
	public Pacman() {
		setCaracterPersonaje('C');
		
	}
			
	public void comerPuntos(){
		System.out.println("Come puntos");
	}
	
	
}

