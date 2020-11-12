package juego;


import java.awt.Color;

import entorno.*;


public class Juego extends InterfaceJuego
{
	
	private Entorno entorno;
	Conejo conejo;
	Carretera carretera1;
	Carretera carretera2;
	
	Trafico autos;
	Trafico autos2;
	
	Kamehameha kamehameha;
	Juego()
	{
		
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		this.conejo = new Conejo(entorno);
		this.carretera1= new Carretera(entorno,"derecha",0); //Se crea una carretera, la cual pide un sentido y una posicion
		this.carretera2= new Carretera(entorno,"izquierda",300);
		this.autos = new Trafico(entorno,carretera1,conejo,1); //Se crea un arreglo de autos la cual toma una carretera (con su respectivo sentido), un conejo, y una velocidad
		this.autos2 = new Trafico(entorno,carretera2,conejo,2);
		this.kamehameha = new Kamehameha(entorno, conejo);
		
		conejo.inicarComponentesFueraTick();//se inician los respectivos componentes
		autos.crearAutos(); //se crea el arreglo de autos
		autos.posicionarAutos(); //Se posiciona correctamete los autos
		autos.iniciarComponentesFueraTick(); //se inician los respectivos componentes
		autos2.crearAutos();
		autos2.posicionarAutos();
		autos2.iniciarComponentesFueraTick();
		kamehameha.iniciarComponentesFueraTick();
		
		this.entorno.iniciar();
	}

	
	public void tick()
	{
		juegoActivoTick();
		
		

		

	}
	private void juegoActivoTick() {
		if(conejo.getVida()) {
			carretera1.iniciarComponentesEnTick();
			carretera2.iniciarComponentesEnTick();
			conejo.iniciarComponentesEnTick();
			autos.iniciarComponentesEnTick();
			autos2.iniciarComponentesEnTick();
			kamehameha.iniciarComponentesEnTick();
		}
		else {
			gameOver();
		}
	}
	private void gameOver() {
		entorno.cambiarFont("Arial", 100, Color.white);
		entorno.escribirTexto("GAME OVER", entorno.ancho()/8, entorno.alto()/2);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
		
	}
}