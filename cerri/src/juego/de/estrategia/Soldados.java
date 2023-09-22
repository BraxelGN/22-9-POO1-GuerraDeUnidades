package juego.de.estrategia;

public class Soldados extends Unidades implements Bebedor {

	private int energia;
	
	
	public Soldados(int vida, int daño, Punto posicion,int energia) {
		super(vida, daño, posicion);
		this.energia=energia;
	}
	
	public int getEnergia() {
		return  this.energia;
	}
	
	public void setEnergia(int energia) {
		this.energia=energia;
	}

	@Override
	public void beberAgua() {
		setEnergia(100);
	}

	@Override
	public void atacar(Unidades enemigo) {
		if(puedoAtacar(enemigo))
		{
			enemigo.recibirDaño(getDaño());
			this.setEnergia((this.getEnergia()-10));
		}
		else
			throw new Error("No puede atacar");
	}

	@Override
	public boolean puedoAtacar(Unidades enemigo) {
		return (this.estaVivo() 
				&& enemigo.estaVivo() 
				&& this.getPosicion().distancia(enemigo.getPosicion())<=2
				&& getEnergia()>10);	
	}

}
