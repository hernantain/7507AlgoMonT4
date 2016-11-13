package modelo;

public class Fogonazo extends AtaqueEspecial {

	public Fogonazo() {
		danio = 2;
		cantidad = 4;
		tipo = new TipoFuego();
	}
	
	@Override
	protected void efectoSecundario(Algomon algomonAfectado) {
		algomonAfectado.cambiarEstado(new EstadoQuemado(algomonAfectado));
	}

}