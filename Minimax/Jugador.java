package Minimax;

import Minimax.utils.Pair;

abstract class Jugador {

	TFicha misfichas;
	protected TresEnRaya ter;
	protected int nfichas;

	Jugador(TFicha ficha){

		misfichas = ficha;
	}

	protected void setNfichas(int nfichas){this.nfichas=nfichas;}
	protected TFicha getMisfichas(){return misfichas;}
	protected void setTer(TresEnRaya t){ter=t;}
	protected boolean JugarTurno(Pair<Integer,Integer> pos) {

		boolean puedo_colocar_ficha;
		if ((puedo_colocar_ficha = ter.JugarTurno(misfichas, pos))) nfichas--;
		return puedo_colocar_ficha;
	}
	protected int getNfichas(){return nfichas;}
}
