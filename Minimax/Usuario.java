package Minimax;

class Usuario extends Jugador{

	private final String name;

	Usuario(String name, TFicha f){

		super(f);
		this.name = name;
	}

	String getName(){return name;}
}
