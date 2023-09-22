package juego.de.estrategia;

public abstract class Unidades {

	private int vida;
	private int da�o;
	private Punto posicion;

	public Unidades(int vida,int da�o, Punto posicion) {
		this.vida = vida;
		this.da�o=da�o;
		this.posicion = posicion;
	}

	public int getVida() {
		return vida;
	}

	public int getDa�o() {
		return da�o;
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

	public void recibirDa�o(int da�o)
	{
		this.setVida(this.getVida()-da�o);
	}

	public boolean estaVivo() {
		return getVida()>0;
	}

	public abstract boolean puedoAtacar(Unidades unidad);

}
