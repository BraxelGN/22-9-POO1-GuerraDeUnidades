package juego.de.estrategia;

public class Caballeros extends Unidades{

	private Caballo caballo;
	private int contadorDeAtaques = 0;
	
	public Caballeros(int vida, int daño, Punto posicion, Caballo ponySalvaje) {
		super(vida, daño, posicion);
		caballo = ponySalvaje;
		
	}
	
	public void setCaballoRebelde() {
		if(this.getCantidadDeAtaques()>3)
			caballo.setRebeldia();
	}
	
	public void darAguaAlCaballo() {
		this.caballo.beberAgua();
		this.contadorDeAtaques=0;
	}
	
	public int getCantidadDeAtaques() {
		return this.contadorDeAtaques;
	}

	@Override
	public void atacar(Unidades enemigo) {
		if(puedoAtacar(enemigo))
		{
			enemigo.recibirDaño(getDaño());
			this.contadorDeAtaques++;
			setCaballoRebelde();
		}

		else
			throw new Error("No puede atacar");	
		
	}

	@Override
	public boolean puedoAtacar(Unidades enemigo) {
		return (this.estaVivo() 
				&& enemigo.estaVivo()
				&& !this.caballo.estaRebelde() 
				&& this.getPosicion().distancia(enemigo.getPosicion())<=2 
				&& this.getPosicion().distancia(enemigo.getPosicion())>=1);	
	}

}
