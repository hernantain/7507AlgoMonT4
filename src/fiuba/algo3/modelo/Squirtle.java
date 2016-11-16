package modelo;

public class Squirtle extends Algomon {

	public Squirtle(){
		tipo = new TipoAgua();
		vida = new Vida(150);
		ataques.add(new Burbuja());
		ataques.add(new CanionDeAgua());
		ataques.add(new AtaqueRapido());
	}
	
	
}
