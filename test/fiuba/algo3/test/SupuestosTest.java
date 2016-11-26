package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Algomones.*;
import modelo.AlgomonRepetidoExcepcion;
import modelo.Jugador;
import modelo.LimiteDeAlgomonesAlcanzadoExcepcion;

public class SupuestosTest {
	
	@Test
	public void testCadaJugadorEligeTresAlgomones() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		boolean sePudoElegirCuartoAlgomon = true;
				
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		Chansey chansey_1 = new Chansey();
				
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		
		jugador1.setAlgomon(jigglypuff);
		jugador2.setAlgomon(bulbasaur);
		
		jugador1.setAlgomon(rattata);
		jugador2.setAlgomon(squirtle);

		jugador1.setAlgomon(charmander);
		jugador2.setAlgomon(chansey);
		
		//No deberia poder realizarse
		try {
			jugador1.setAlgomon(chansey_1);
		} catch (LimiteDeAlgomonesAlcanzadoExcepcion e) {
			sePudoElegirCuartoAlgomon = false;
		}
		
		assertFalse(sePudoElegirCuartoAlgomon);
	}
	
	@Test
	public void testLosJugadoresNoPuedenTenerAlgomonesRepetidos() {
		Jugador jugador1 = new Jugador("j1");
		Jugador jugador2 = new Jugador("j2");
		
		boolean sePudoElegirAlgomonRepetido = true;
				
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chanseyRepetido = new Chansey();
				
		Bulbasaur bulbasaur = new Bulbasaur();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		
		jugador1.setAlgomon(jigglypuff);
		jugador2.setAlgomon(bulbasaur);
		
		jugador1.setAlgomon(chansey);
		jugador2.setAlgomon(squirtle);

		//jugador 1 no deberia poder volver a elegir un Chansey
		try{
			jugador1.setAlgomon(chanseyRepetido);
		} catch (AlgomonRepetidoExcepcion e) {
			sePudoElegirAlgomonRepetido = false;
		}
		
		assertFalse(sePudoElegirAlgomonRepetido);
	}
	
}
