
public class Bulbasaur extends Algomon{
	
	public Bulbasaur(){
		tipo = new TipoPlanta();
		vida = 140.0;
		// Ac� falta el ataque Chupavidas que todav�a no es necesario
		ataques.put("Latigo cepa", new LatigoCepa());
		ataques.put("Ataque Rapido", new AtaqueRapido());
	}
}

