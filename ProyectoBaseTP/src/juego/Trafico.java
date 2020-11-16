package juego;

import entorno.*;

public class Trafico {
	private Auto autos[];
	private Entorno entorno;
	private Carretera carretera;
	private Conejo conejo;
	private double velocidad;
	private Kamehameha kamehameha;
	private Zanahoria zanahoria;
	private RayoConversorZanahoria rayoConversorZanahoria;
	public Trafico(Entorno entorno,Carretera carretera, Conejo conejo,Kamehameha kamehameha,Zanahoria zanahoria,RayoConversorZanahoria rayoConversorZanahoria,double velocidad) {
		autos=new Auto[4];
		this.entorno=entorno;
		this.carretera=carretera;
		this.conejo=conejo;
		this.velocidad=velocidad;
		this.kamehameha=kamehameha;
		this.zanahoria=zanahoria;
		this.rayoConversorZanahoria=rayoConversorZanahoria;
	}
	private void crearAutos() {
		for (int i=0;i<autos.length;i++) {
			Auto auto=new Auto(entorno,carretera,conejo,kamehameha,zanahoria,rayoConversorZanahoria,velocidad);
			autos[i]=auto;
		}
		
	}
	private void posicionarAutos() {
		double x=0;
		for(Auto auto:autos) {
			auto.setX(x);
			x+=200;
		}
	}
	public void iniciarComponentesFueraTick() {
		crearAutos();
		posicionarAutos();
		for(Auto auto:autos) {
			auto.iniciarComponentesFueraTick();
		}
	}
	public void iniciarComponentesEnTick() {
		for(Auto auto:autos) {
			auto.iniciarComponentesEnTick();
		}
	}
}
