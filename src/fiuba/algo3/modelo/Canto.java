package modelo;

public class Canto extends AtaqueSimple{

	public Canto(){
		potencia = new Potencia(0);
		cantidad = 6;
		tipo = new TipoNormal();
	}
}