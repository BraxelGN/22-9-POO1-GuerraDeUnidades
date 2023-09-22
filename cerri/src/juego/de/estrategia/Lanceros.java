package juego.de.estrategia;

public class Lanceros extends Unidades{

	public Lanceros(int vida, int daño, Punto posicion) {
		super(vida, daño, posicion);
	}

	@Override
	public boolean puedoAtacar(Unidades enemigo) {
		return (this.estaVivo() 
				&& enemigo.estaVivo() 
				&& this.getPosicion().distancia(enemigo.getPosicion())<=3 
				&& this.getPosicion().distancia(enemigo.getPosicion())>=1);	
	}

	@Override
	public void atacar(Unidades enemigo) {
		if(puedoAtacar(enemigo))
			enemigo.recibirDaño(getDaño());
		else
			throw new Error("No puede atacar");
	}

	

}
