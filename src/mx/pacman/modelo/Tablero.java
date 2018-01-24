package mx.pacman.modelo;

public class Tablero {
	private int idTablero = 1; 
	private int row;
	private int col;
	char[][] tablero;
	
	
	
	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}


	public Tablero(){
	
		this.row = 20;
		this.col = 40;
		tablero = crearTablero();
	}
	
	
	public int getIdTablero() {
		return idTablero;
	}


	public void setIdTablero(int idTablero) {
		this.idTablero = idTablero;
	}


	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public char[][] getTablero() {
		return tablero;
	}

	char[][] crearTablero() {
		char[][] tablero = new char[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				tablero[i][j] = '.';
				
			}
		}
		ponerParedes(tablero);
				
		return tablero;
	}	

	public char[][] ponerParedes(char[][] tablero) {
		for (int i = 3; i < row - 13; i++) {
			for (int j = 3; j < col - 25; j++) {
				tablero[i][15] = '|';
				tablero[i][25] = '|';
				tablero[7][j] = '-';
				tablero[12][j] = '-';
												
			}

		}

		for (int i = 13; i < row - 3; i++) {
			for (int j = 25; j < col - 3; j++) {
				tablero[i][15] = '|';
				tablero[i][25] = '|';
				tablero[7][j] = '-';
				tablero[12][j] = '-';

			}

		}
	
		return tablero;
	}

	public void imprimirEscenario() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				System.out.print(tablero[i][j]);
				
			}
			
			System.out.println();
			
		}System.out.println("==========================================");

	}


	public void setRow(int row) {
		this.row = row;
	}


	public void setCol(int col) {
		this.col = col;
	}

}