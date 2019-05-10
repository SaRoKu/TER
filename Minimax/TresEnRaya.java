package Minimax;

import Minimax.utils.Pair;

class TresEnRaya {

	private final Tablero tablero;
	private final Jugador J1;
	private final Jugador J2;

	TresEnRaya(Jugador j1, Jugador j2, Tablero t){

		J1 = j1;
		J2 = j2;
		tablero = t;
	}

	boolean JugarTurno(TFicha f, Pair<Integer,Integer> pos){

		return tablero.addFicha(f,pos);
	}

	Tablero getTablero(){

		return tablero;
	}
}
