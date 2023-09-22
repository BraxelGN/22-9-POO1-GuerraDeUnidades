package juego.de.estrategia;

public abstract class Unidades {

	private int vida;
	private int daño;
	private Punto posicion;

	public Unidades(int vida,int daño, Punto posicion) {
		this.vida = vida;
		this.daño=daño;
		this.posicion = posicion;
	}

	public int getVida() {
		return vida;
	}

	public int getDaño() {
		return daño;
	}

	public Punto getPosicion() {
		return posicion;
	}

	public void setVida(int vida) {
		this.vida=vida;
	}

	public void setPosicion(Punto posicion) {
		this.posicion=posicion;
	}

	public abstract void atacar(Unidades enemigo);

	public void recibirDaño(int daño)
	{
		this.setVida(this.getVida()-daño);
	}

	public boolean estaVivo() {
		return getVida()>0;
	}

	public abstract boolean puedoAtacar(Unidades unidad);

}
