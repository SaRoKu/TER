package Minimax;

import Minimax.utils.Pair;

public class ctrlDominio {

	//EN UN PROGRAMA CON A3C bien hecha, no tienen que haber tantas variables fuera de las clases del modelo (ganador,finalizada...)
	private Usuario user;
	private Algoritmo alg;
	private TresEnRaya partida;
	Pair<Integer, Integer> pos;
	private boolean ganador = false;
	private boolean tablero_completo = false;
	private boolean turnoHumano;

	void iniciarPartida(String name, int ficha, boolean comienzaPrimero) {

		turnoHumano = comienzaPrimero;
		user = new Usuario(name, TFicha.values()[ficha]);
		alg = new Algoritmo(Algoritmo.fichascontrario(user.getMisfichas()));
		partida = new TresEnRaya(user, alg, new Tablero());
		user.setTer(partida);
		alg.setTer(partida);

		if (comienzaPrimero) {

			user.setNfichas(5);
			alg.setNfichas(4);
		} else {
			user.setNfichas(4);
			alg.setNfichas(5);
		}
	}

	boolean finalizada() {

		return (ganador = partida.getTablero().estado_terminal(pos)) || ((tablero_completo = partida.getTablero().posiciones_posibles().size() == 0));
	}

	boolean JugarTurno(int row, int col) {

		pos = new Pair<>(row,col); //Evitar nullpointerexception
		turnoHumano = false;
		return user.JugarTurno(new Pair<>(row, col));
	}

	Pair<Integer,Integer> getPos(){return pos;}

	void JugarTurno(){

		alg.JugarTurno((pos = alg.minimax(partida.getTablero(), user.getNfichas() + alg.getNfichas())));
		turnoHumano = true;
	}

	int getResultados(){

		if(ganador){

			if(!turnoHumano)return 1;
			else return -1;
		}
		else if(tablero_completo) return 0;
		return -999;
	}

	String getUsername(){return user.getName();}
	boolean getTurnoHumano(){return turnoHumano;}
}
