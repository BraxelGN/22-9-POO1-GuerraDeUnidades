package juego.de.estrategia;

public class Caballo implements Bebedor{

	private boolean rebelde;
	
	public boolean estaRebelde() {
		return this.rebelde;
	}
	
	public void setRebeldia() {
		this.rebelde= true;
	}
	
	@Override
	public void beberAgua() {
		this.rebelde=false;
		
	}

	
}
