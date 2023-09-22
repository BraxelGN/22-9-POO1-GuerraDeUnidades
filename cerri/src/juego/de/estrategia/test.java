package juego.de.estrategia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {
	
	

	@Test
	public void crearUnidad() {
		Lanceros lancer = new Lanceros(200,20,(new Punto()));
		
		assertEquals(200,lancer.getVida());
		assertEquals(20,lancer.getDaño());
	}
	
	@Test
	public void combateTest() {
		Lanceros lancer = new Lanceros(200,20,(new Punto()));
		Lanceros lancer1 = new Lanceros(200,20,(new Punto(0,1)));
		
		lancer.atacar(lancer1);
		
		assertEquals(180,lancer1.getVida());
	}
	
	@Test
	public void combateSoldado() {
		Lanceros lancer = new Lanceros(200,20,(new Punto()));
		Soldados soldier = new Soldados (200,20,(new Punto()),100);
		
		soldier.atacar(lancer);
		assertEquals(180,lancer.getVida());
		assertEquals(soldier.getEnergia(),90);
		
		soldier.beberAgua();
		assertEquals(100,soldier.getEnergia());
	}
	
	@Test
	public void combateArquero() {
		Lanceros lancer = new Lanceros(200,20,(new Punto()));
		Arqueros archer = new Arqueros(200,20,(new Punto(5,0)));
		
		archer.atacar(lancer);
		assertEquals(180,lancer.getVida());
		assertEquals(archer.getCantFlechas(),19);
		
		while(archer.puedoAtacar(lancer)) {
			archer.atacar(lancer);
		}
		
		archer.recargarFlechas();
		assertEquals(16,archer.getCantFlechas());
	}
	
	@Test
	public void combateCaballero() {
		Lanceros lancer = new Lanceros(500,20,(new Punto()));
		Caballeros horseman = new Caballeros(200,50,(new Punto(1,0)),(new Caballo()));
		
		horseman.atacar(lancer);
		assertEquals(450,lancer.getVida());
		
		assertEquals(1,horseman.getCantidadDeAtaques());
		horseman.atacar(lancer);
		horseman.atacar(lancer);
		horseman.atacar(lancer);
		assertEquals(false,horseman.puedoAtacar(lancer));
	}
}
