package modelo;

public class Turno {

	private Jugador jugadorActivo;  //Es el jugador que le corresponde jugar
	private Jugador jugador1;
	private Jugador jugador2;       //Los 2 jugadores del juego
	
	public Turno(Jugador player1, Jugador player2) {
		jugadorActivo = player1;   //Esto hay que implmentarlo al azar, despues vemos como.
		jugador1 = player1;
		jugador2 = player2;
		jugador1.setOponente(jugador2);
		jugador2.setOponente(jugador1);
	}
	
	public void jugar(AccionDeJugador accion){ //Al jugador que le corresponde jugar se le pasa la accion correspondiente
		jugadorActivo.realizarAccion(accion);  //Por ahora solo atacamos...
		cambiarJugador();					   //Cada vez que se realiza una accion, cambia el jugador activo.
	}
	
	public void cambiarJugador(){
		if (jugadorActivo == jugador1){
			jugadorActivo = jugador2;
			return;
		}
		jugadorActivo = jugador1;
	}
	
	public Jugador jugadorActivo(){
		return jugadorActivo;
	}
	
	public Jugador jugadorNoActivo(){
		if (jugadorActivo == jugador1) {
			return jugador2;
		} else {
			return jugador1;
		}
	}
}
