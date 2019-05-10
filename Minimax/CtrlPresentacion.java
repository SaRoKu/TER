package Minimax;

import Minimax.utils.Pair;

public class CtrlPresentacion {

	private VistaInicial vistaInicial;
	private VistaPartida vistaPartida;
	private ctrlDominio CD;
	private boolean UsuarioJuegaCruz;
	public CtrlPresentacion(){

		CD = new ctrlDominio();
		inicializarPresentacion();
	}

	public void inicializarPresentacion(){

		vistaInicial = new VistaInicial(this);
		vistaInicial.hacerlaVisible();
	}

	public void sincronizacion_VistaInicial_a_VistaPartida(){

		vistaInicial.hacerlaInvisible();
		vistaPartida = new VistaPartida(this);
		vistaPartida.hacerlaVisible();
	}

	public void setUsuarioJuegaCruz(boolean usuarioJuegaCruz){
		this.UsuarioJuegaCruz = usuarioJuegaCruz;
	}

	public boolean getUsuarioJuegaCruz(){return UsuarioJuegaCruz;}

	/********************LLAMADAS AL CONTROLADOR DE DOMINIO*****************************/

	void iniciarPartida(String name, int ficha, boolean comienzaPrimero) {

		CD.iniciarPartida(name,ficha,comienzaPrimero);
	}

	boolean finalizada() {

		return CD.finalizada();
	}

	boolean JugarTurno(int row, int col) {

		return CD.JugarTurno(row,col);
	}

	void JugarTurno(){

		CD.JugarTurno();
	}

	int getResultados(){

		return CD.getResultados();
	}

	Pair<Integer,Integer> getPos(){return CD.getPos();}
	String getUsername(){return CD.getUsername();}
	boolean getTurnoHumano(){return CD.getTurnoHumano();}
}
