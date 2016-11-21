package Ataques;

import Tipos.TipoFuego;

public class Fogonazo extends AtaqueSimple {

	public Fogonazo() {
		nombre = "Fogonazo";
		potencia = new Potencia(2);
		cantidad = 4;
		tipo = new TipoFuego();
	}
}
