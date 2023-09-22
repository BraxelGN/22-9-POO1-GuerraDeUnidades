package juego.de.estrategia;

public class Lanceros extends Unidades{

	public Lanceros(int vida, int da�o, Punto posicion) {
		super(vida, da�o, posicion);
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
			enemigo.recibirDa�o(getDa�o());
		else
			throw new Error("No puede atacar");
	}

	

}
