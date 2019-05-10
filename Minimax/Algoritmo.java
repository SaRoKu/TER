package Minimax;

import Minimax.utils.Pair;

class Algoritmo extends Jugador{

	Algoritmo(TFicha tficha){
		super(tficha);
	}

	public static TFicha fichascontrario(TFicha misfichas){

		if(misfichas.equals(TFicha.Circulo))return TFicha.Cruz;
		return TFicha.Circulo;
	}

	/**
	 * ATENCION: El algoritmo siempre gana/pierde, pero no siempre gana en el minimo numero de movimientos
	 */
	Pair<Integer,Integer> minimax(Tablero t, int prof) { //La profundidad será las fichas que me queden por colocar mas las del contrario

		Pair<Integer, Integer> res = null; //movimiento
		
		int alfa = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		int max_subarbol;

		for (Pair<Integer, Integer> mov : t.posiciones_posibles()) { //Comienza max

			max_subarbol = valor_min(t.aplicar(misfichas,mov),prof-1,mov,alfa,beta); //valor "MIN" del tablero (estado) si coloco mi ficha en mov
			if (max_subarbol > alfa) {

				alfa = max_subarbol;
				res = mov;
			}
			if(alfa==Integer.MAX_VALUE)break; //Solo tiene sentido si no me importan los movimientos en los que gane.
		}
		return res;
	}


	int valor_min(Tablero t, int prof, Pair<Integer,Integer> lastmov, int alfa, int beta) { //Turno min

		if(t.estado_terminal(lastmov)) return Integer.MAX_VALUE;
		if(prof==0)return t.valor(misfichas);
		else{

			for(Pair<Integer,Integer> mov: t.posiciones_posibles()){

				beta = Math.min(beta,valor_max(t.aplicar(fichascontrario(misfichas),mov),prof-1,mov,alfa,beta));
				if(alfa>=beta) return beta;
			}
			return beta;
		}
	}

	int valor_max(Tablero t, int prof,Pair<Integer,Integer> lastmov, int alfa, int beta){//Turno max

		if(t.estado_terminal(lastmov)) return Integer.MIN_VALUE;
		if(prof==0)return t.valor(misfichas);
		else{

			for(Pair<Integer,Integer> mov: t.posiciones_posibles()){

				alfa = Math.max(alfa,valor_min(t.aplicar(misfichas,mov),prof-1,mov,alfa,beta));
				if(alfa>=beta) return alfa;
			}
			return alfa;
		}
	}
}