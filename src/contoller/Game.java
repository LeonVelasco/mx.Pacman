package contoller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mx.pacman.modelo.Fantasma;
import mx.pacman.modelo.Pacman;
import mx.pacman.modelo.Tablero;
import mx.pacman.modelo.Vitamina;
import mx.pacman.servicios.FantasmaServicioImpl;
import mx.pacman.servicios.ItemServicio;
import mx.pacman.servicios.ItemServicioImpl;
import mx.pacman.servicios.JuegoServicio;
import mx.pacman.servicios.JuegoServicioImpl;
import mx.pacman.servicios.PacmanServicioImpl;
import mx.pacman.servicios.PersonajeServicio;
import mx.pacman.servicios.TableroServicio;
import mx.pacman.servicios.TableroServicioImpl;

public class Game {
	private int idJuego;
	String nombreArchivo;
	Tablero tablero = new Tablero();
	Pacman pacman = new Pacman();
	List<Vitamina> listaVitaminas = new ArrayList<Vitamina>();
	List<Fantasma> listaFantasmas = new ArrayList<Fantasma>();
	PersonajeServicio pacmanServicio = new PacmanServicioImpl();
	PersonajeServicio fantasmaServicio = new FantasmaServicioImpl();
	ItemServicio vitaminaServicio = new ItemServicioImpl();
	TableroServicio tableroServicio = new TableroServicioImpl();
	JuegoServicio juegoServicio = new JuegoServicioImpl();

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public void iniciaJuego() throws SQLException {

		Fantasma fantasmaRojo = new Fantasma(1, "rojo", 9, 23);
		Fantasma fantasmaAzul = new Fantasma(2, "azul", 9, 21);
		Fantasma fantasmaAmarillo = new Fantasma(3, "amarillo", 9, 19);
		Fantasma fantasmaVerde = new Fantasma(4, "verde", 9, 17);

		listaFantasmas.add(fantasmaRojo);
		listaFantasmas.add(fantasmaAzul);
		listaFantasmas.add(fantasmaAmarillo);
		listaFantasmas.add(fantasmaVerde);

		for (int i = 0; i < listaFantasmas.size(); i++) {
			tablero.getTablero()[listaFantasmas.get(i).getPosX()][listaFantasmas.get(i).getPosY()] =
					listaFantasmas.get(i).getCaracterPersonaje();
		}

		tablero.getTablero()[pacman.getPosX() + 11][pacman.getPosY() + 20] = pacman.getCaracterPersonaje();

		Vitamina vitamina1 = new Vitamina(1, "superior izquierda", 2, 2);
		Vitamina vitamina2 = new Vitamina(2, "superior derecho", 2, 37);
		Vitamina vitamina3 = new Vitamina(3, "inferior izquierda", 18, 2);
		Vitamina vitamina4 = new Vitamina(4, "inferior derecha", 18, 37);

		listaVitaminas.add(vitamina1);
		listaVitaminas.add(vitamina2);
		listaVitaminas.add(vitamina3);
		listaVitaminas.add(vitamina4);

		for (int i = 0; i < listaVitaminas.size(); i++) {
			tablero.getTablero()[listaVitaminas.get(i).getPosX()][listaVitaminas.get(i).getPosY()] =
					listaVitaminas.get(i).getCaracterItem();
		}

		tablero.imprimirEscenario();
		int vecesQueSeImprimeTablero = 0;

		while (vecesQueSeImprimeTablero <= 8) {

			if (pacmanServicio.sePuedeMover(1, pacman, tablero)) {
				pacmanServicio.moverPersonaje(1, pacman, tablero);
			} else if (pacmanServicio.sePuedeMover(2, pacman, tablero)) {
				pacmanServicio.moverPersonaje(2, pacman, tablero);
			} else if (pacmanServicio.sePuedeMover(3, pacman, tablero)) {
				pacmanServicio.moverPersonaje(3, pacman, tablero);
			} else if (pacmanServicio.sePuedeMover(4, pacman, tablero)) {
				pacmanServicio.moverPersonaje(4, pacman, tablero);
			} else if (pacmanServicio.sePuedeMover(5, pacman, tablero)) {
				pacmanServicio.moverPersonaje(5, pacman, tablero);
			}

			for (int i = 0; i < listaFantasmas.size(); i++) {
				if (fantasmaServicio.sePuedeMover(5, listaFantasmas.get(i), tablero)) {
					fantasmaServicio.moverPersonaje(5, listaFantasmas.get(i), tablero);
				} else if (fantasmaServicio.sePuedeMover(4, listaFantasmas.get(i), tablero)) {
					fantasmaServicio.moverPersonaje(4, listaFantasmas.get(i), tablero);
				} else if (fantasmaServicio.sePuedeMover(3, listaFantasmas.get(i), tablero)) {
					fantasmaServicio.moverPersonaje(3, pacman, tablero);
				} else if (fantasmaServicio.sePuedeMover(2, listaFantasmas.get(i), tablero)) {
					fantasmaServicio.moverPersonaje(2, listaFantasmas.get(i), tablero);
				} else if (fantasmaServicio.sePuedeMover(1, listaFantasmas.get(i), tablero)) {
					pacmanServicio.moverPersonaje(1, listaFantasmas.get(i), tablero);
				}

			}

			tablero.imprimirEscenario();
			vecesQueSeImprimeTablero++;

		}
		// LLENADO DE TABLAS //SETTEO
		pacman.setPosX(pacman.getPosX());
		pacman.setPosY(pacman.getPosY());
		pacman.setEstadoPersonaje(pacman.getEstadoPersonaje());
		pacman.setIdPersonaje(1);

	}

	public void guardaJuego() throws SQLException {
		System.out.print("Deseas guardar el juego?\n\n");
		System.out.println("Salvar Juego Presiona 1 \nTerminar Presiona 2");
		Scanner x = new Scanner(System.in);
		int guardar = x.nextInt();
		if (guardar == 1) {
			System.out.println("Elige tu archivo para guardar");

			String nombre = juegoServicio.obtenerNombreArchivoJuego();
			x = new Scanner(System.in);
			int id = x.nextInt();
			setIdJuego(id);
			System.out.println("Nombra tu archivo: _ _ _ ");
			x = new Scanner(System.in);
			setNombreArchivo(x.nextLine());
			
			juegoServicio.insertarNombreJuego(getIdJuego(), getNombreArchivo());
			pacmanServicio.insertarDatosPersonaje(pacman);
			fantasmaServicio.insertarDatosPersonaje(listaFantasmas);
			vitaminaServicio.insertarDatosItem(listaVitaminas);
			
			System.out.println("SALVANDO JUEGO......ESPERE");
			
			tableroServicio.insertarDatosTablero(tablero, getIdJuego());
			juegoServicio.insertarTablaJuegoPacman(pacman.getIdPersonaje(), getIdJuego());
			juegoServicio.insertarTablaJuegoFantasma(listaFantasmas, id);
			juegoServicio.insertarTablaJuegoItem(listaVitaminas, id);

			System.out.println("PARTIDA GUARDADA");
		}

		System.out.println("GAME OVER");
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public void eligeJuego() throws SQLException {

		System.out.println("ELIGE JUEGO GUARDADO:");

		nombreArchivo = juegoServicio.obtenerNombreArchivoJuego();
		Scanner z = new Scanner(System.in);
		int partidaElegida = z.nextInt();
		if (partidaElegida == 1) {
			setIdJuego(partidaElegida);
			tablero.setTablero(tableroServicio.obtenerEstadoTableroById(idJuego));
			tableroServicio.cargarTablero(tablero, idJuego);
		} else if (partidaElegida == 2) {
			setIdJuego(2);
			tablero.setTablero(tableroServicio.obtenerEstadoTableroById(idJuego));
			tableroServicio.cargarTablero(tablero, idJuego);
		} else if (partidaElegida == 3) {
			setIdJuego(3);
			tablero.setTablero(tableroServicio.obtenerEstadoTableroById(idJuego));
			tableroServicio.cargarTablero(tablero, idJuego);
		}
	}

}
