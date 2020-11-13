package juego;


import java.awt.Color;

import entorno.*;


public class Juego extends InterfaceJuego
{
	
	private Entorno entorno;
	Conejo conejo;
	Carretera carretera1; //mano derecha
	Carretera carretera2;
	Carretera carretera3;
	Carretera carretera4;
	Carretera carretera5; //mano izquierda
	Carretera carretera6;
	Carretera carretera7;
	Carretera carretera8;
	
	Trafico autos1;
	Trafico autos2;
	Trafico autos3;
	Trafico autos4;
	Trafico autos5;
	Trafico autos6;
	Trafico autos7;
	Trafico autos8;
	
	Kamehameha kamehameha;
	public Juego()
	{
		
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		this.conejo = new Conejo(entorno);
		this.carretera1= new Carretera(entorno,"derecha",0); //Se crea una carretera, la cual pide un sentido y una posicion
		this.carretera2= new Carretera(entorno,"izquierda",30);
		this.carretera3= new Carretera(entorno,"derecha",60);
		this.carretera4= new Carretera(entorno,"izquierda",90);
		this.carretera5= new Carretera(entorno,"derecha",300);
		this.carretera6= new Carretera(entorno,"izquierda",330);
		this.carretera7= new Carretera(entorno,"derecha",360);
		this.carretera8= new Carretera(entorno,"izquierda",390);
		
		this.kamehameha = new Kamehameha(entorno, conejo);
		
		this.autos1 = new Trafico(entorno,carretera1,conejo,kamehameha,2); //Se crea un arreglo de autos la cual toma una carretera (con su respectivo sentido), un conejo, y una velocidad
		this.autos2 = new Trafico(entorno,carretera2,conejo,kamehameha,1.1);
		this.autos3 = new Trafico(entorno,carretera3,conejo,kamehameha,0.8);
		this.autos4 = new Trafico(entorno,carretera4,conejo,kamehameha,0.47);
		this.autos5 = new Trafico(entorno,carretera5,conejo,kamehameha,2);
		this.autos6 = new Trafico(entorno,carretera6,conejo,kamehameha,1.5);
		this.autos7 = new Trafico(entorno,carretera7,conejo,kamehameha,0.7);
		this.autos8 = new Trafico(entorno,carretera8,conejo,kamehameha,0.43);
		
		juegoActivoFueraTick();
		
		
		
		this.entorno.iniciar();
	}

	
	public void tick()
	{
		juegoActivoTick();

	}
	private void juegoActivoFueraTick() {
		conejo.inicarComponentesFueraTick();
		autos1.iniciarComponentesFueraTick(); 
		autos2.iniciarComponentesFueraTick();
		autos3.iniciarComponentesFueraTick();
		autos4.iniciarComponentesFueraTick();
		autos5.iniciarComponentesFueraTick();
		autos6.iniciarComponentesFueraTick();
		autos7.iniciarComponentesFueraTick();
		autos8.iniciarComponentesFueraTick();
		
		kamehameha.iniciarComponentesFueraTick();
	}
	private void juegoActivoTick() {
		if(conejo.getVida()) {
			carretera1.iniciarComponentesEnTick();
			carretera2.iniciarComponentesEnTick();
			carretera3.iniciarComponentesEnTick();
			carretera4.iniciarComponentesEnTick();
			carretera5.iniciarComponentesEnTick();
			carretera6.iniciarComponentesEnTick();
			carretera7.iniciarComponentesEnTick();
			carretera8.iniciarComponentesEnTick();
			conejo.iniciarComponentesEnTick();
			kamehameha.iniciarComponentesEnTick();
			autos1.iniciarComponentesEnTick();
			autos2.iniciarComponentesEnTick();
			autos3.iniciarComponentesEnTick();
			autos4.iniciarComponentesEnTick();
			autos5.iniciarComponentesEnTick();
			autos6.iniciarComponentesEnTick();
			autos7.iniciarComponentesEnTick();
			autos8.iniciarComponentesEnTick();
			
		}
		else {
			gameOver();
		}
	}
	private void gameOver() {
		entorno.cambiarFont("Arial", 100, Color.white);
		entorno.escribirTexto("GAME OVER", entorno.ancho()/8, entorno.alto()/2);
	}
	
}