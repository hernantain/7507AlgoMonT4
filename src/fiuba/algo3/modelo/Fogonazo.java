package modelo;

public class Fogonazo extends AtaqueSimple {

	public Fogonazo() {
		potencia = new Potencia(2);
		cantidad = 4;
		tipo = new TipoFuego();
	}
}