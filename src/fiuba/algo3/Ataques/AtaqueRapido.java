package Ataques;

import Tipos.TipoNormal;

public class AtaqueRapido extends AtaqueSimple {
	
	public AtaqueRapido(){
		nombre = "Ataque Rapido";
		tipo = new TipoNormal();
		potencia = new Potencia(10);
		cantidad = 16;
	}
}
