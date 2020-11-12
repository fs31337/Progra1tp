package juego;

import entorno.*;

public class Trafico {
	private Auto autos[];
	private Entorno entorno;
	private Carretera carretera;
	private Conejo conejo;
	private double velocidad;
	public Trafico(Entorno entorno,Carretera carretera, Conejo conejo,double velocidad) {
		autos=new Auto[5];
		this.entorno=entorno;
		this.carretera=carretera;
		this.conejo=conejo;
		this.velocidad=velocidad;
	}
	public void crearAutos() {
		for (int i=0;i<autos.length;i++) {
			Auto auto=new Auto(entorno,carretera,conejo,velocidad);
			autos[i]=auto;
		}
		
	}
	public void posicionarAutos() {
		double x=0;
		for(Auto auto:autos) {
			auto.setX(x);
			x+=200;
		}
	}
	public void iniciarComponentesFueraTick() {
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
