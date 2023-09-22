package juego.de.estrategia;

public class Arqueros extends Unidades{

	private int cantFlechas;

	public Arqueros(int vida, int daño, Punto posicion) {
		super(vida, daño, posicion);
		this.setCantFlechas(20);
	}

	@Override
	public void atacar(Unidades enemigo) {
		if(puedoAtacar(enemigo))
		{
			enemigo.recibirDaño(getDaño());
			setCantFlechas(getCantFlechas()-1);
		}

		else
			throw new Error("No puede atacar");
	}

	@Override
	public boolean puedoAtacar(Unidades enemigo) {
		return (this.estaVivo() 
				&& enemigo.estaVivo()
				&& this.tengoFlechas() 
				&& this.getPosicion().distancia(enemigo.getPosicion())<=5 
				&& this.getPosicion().distancia(enemigo.getPosicion())>=2);	
	}

	public int getCantFlechas() {
		return cantFlechas;
	}

	public boolean tengoFlechas() {
		return this.getCantFlechas()>0;
	}

	public void recargarFlechas() {
		setCantFlechas(getCantFlechas()+6);
	}

	public void setCantFlechas(int cantFlechas) {
		this.cantFlechas = cantFlechas;
	}

}
