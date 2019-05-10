package Minimax;

import Minimax.utils.Pair;

import java.util.LinkedList;
import java.util.List;

class Tablero{
	
	private final TFicha[][] casillas = new TFicha[3][3];
	public static final int SIZE = 3;

	Tablero(){}
	Tablero(Tablero t){

		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++)casillas[i][j]=t.casillas[i][j];
		}
	}

	boolean addFicha(TFicha f, Pair<Integer,Integer> pos){

		boolean valido;
		if((valido=isAValidPosition(pos))) casillas[pos.getFirst()][pos.getSecond()]=f;
		return valido;
	}

	private boolean isAValidPosition(Pair<Integer,Integer> pos){

		if(pos==null)return false;
		if(isInsideTheBoard(pos.getFirst(),pos.getSecond())) return casillas[pos.getFirst()][pos.getSecond()]==null;
		return false;
	}

	private boolean isInsideTheBoard(int x, int y){

		return 0<=x && x < SIZE && 0 <= y && y < SIZE;
	}

	List<Pair<Integer,Integer>> posiciones_posibles(){

		List<Pair<Integer,Integer>> pp = new LinkedList<>();
		for(int x=0; x<SIZE; x++){
			for(int y=0; y<SIZE; y++){
				if(casillas[x][y]==null)pp.add(new Pair<>(x,y));
			}
		}
		return pp;
	}
	Tablero aplicar(TFicha f, Pair<Integer,Integer> pos){

		Tablero copiaTablero = new Tablero(this);
		if(!copiaTablero.addFicha(f,pos)) System.out.println("ERROR");
		return copiaTablero;
	}

	boolean estado_terminal(Pair<Integer,Integer> lastmov){

		TFicha misfichas = casillas[lastmov.getFirst()][lastmov.getSecond()];
		for(int i=0; i<SIZE; i++){//horizontal & vertical

			if(casillas[0][i]==misfichas && casillas[1][i]==misfichas && casillas[2][i]==misfichas)return true;
			if(casillas[i][0]==misfichas && casillas[i][1]==misfichas && casillas[i][2]==misfichas)return true;
		}
		if(casillas[0][0]==misfichas && casillas[1][1]==misfichas && casillas[2][2]==misfichas)return true;//Diag1
		if(casillas[2][0]==misfichas && casillas[1][1]==misfichas && casillas[0][2]==misfichas)return true;//Diag2
		return false;
	}

	int valor(TFicha misfichas){

		int contmin=8;
		int contmax=8;
		for(int i=0; i<SIZE; i++){//horizontal & vertical

			if(casillas[0][i]==misfichas || casillas[1][i]==misfichas || casillas[2][i]==misfichas)contmin--;
			if(casillas[i][0]==misfichas || casillas[i][1]==misfichas || casillas[i][2]==misfichas)contmin--;
			if(casillas[0][i]==Algoritmo.fichascontrario(misfichas) || casillas[1][i]==Algoritmo.fichascontrario(misfichas) || casillas[2][i]==Algoritmo.fichascontrario(misfichas))contmax--;
			if(casillas[i][0]==Algoritmo.fichascontrario(misfichas) || casillas[i][1]==Algoritmo.fichascontrario(misfichas) || casillas[i][2]==Algoritmo.fichascontrario(misfichas))contmax--;
		}
		if(casillas[0][0]==misfichas || casillas[1][1]==misfichas || casillas[2][2]==misfichas)contmin--;
		if(casillas[2][0]==misfichas || casillas[1][1]==misfichas || casillas[0][2]==misfichas)contmin--;
		if(casillas[0][0]==Algoritmo.fichascontrario(misfichas) || casillas[1][1]==Algoritmo.fichascontrario(misfichas) || casillas[2][2]==Algoritmo.fichascontrario(misfichas))contmax--;
		if(casillas[2][0]==Algoritmo.fichascontrario(misfichas) || casillas[1][1]==Algoritmo.fichascontrario(misfichas) || casillas[0][2]==Algoritmo.fichascontrario(misfichas))contmax--;

		return contmax-contmin;
	}
}