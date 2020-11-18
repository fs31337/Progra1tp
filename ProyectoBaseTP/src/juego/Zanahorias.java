package juego;

import entorno.*;

public class Zanahorias {
	private Entorno entorno;
	private Conejo conejo;
	private Zanahoria zanahorias[];
	public static int contZanahorias=0;
	public Zanahorias(Entorno entorno, Conejo conejo) {
		this.zanahorias=new Zanahoria[5]; //No cambiar cantidad
		this.entorno=entorno;
		this.conejo=conejo;
		
	}
	private void crearZanahorias() {
		for(int i=0;i<zanahorias.length;i++) {
			Zanahoria zanahoria=new Zanahoria(entorno,conejo);
			zanahorias[i]=zanahoria;
		}
		
	}
	public void iniciarComponentesEnTick() {
		
		for(Zanahoria zanahoria:zanahorias) {
			zanahoria.iniciarComponentesEnTick();
		}
	}
	public void iniciarComponentesFueraTick() {
		crearZanahorias();
	}
	public Zanahoria[] getZanahorias() {
		return this.zanahorias;
	}
	
}
