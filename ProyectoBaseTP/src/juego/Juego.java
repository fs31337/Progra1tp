package juego;


import java.awt.Color;

import javax.sound.sampled.Clip;

import entorno.*;
import juego.Carretera.Sentido;


public class Juego extends InterfaceJuego
{
	
	private Entorno entorno;
	public static final String TITULO ="Boss Rabbit Rabber - Grupo 6 - v1";
	Fondo fondo;
	
	Conejo conejo;
	Carretera carretera1; 
	Carretera carretera2;
	Carretera carretera3;
	Carretera carretera4;
	Carretera carretera5; 
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
	
	static Clip musica;
	
	Zanahorias zanahorias;
	RayoConversorZanahoria rayoConversorZanahoria;
	
	Carretera carreteras[];
	Trafico trafico[];
	
	ZaWarudo zaWarudo;
	
	Obstaculos obstaculos;
	
	private boolean ganaste,perdiste;
	public Juego()
	{
		
		this.entorno = new Entorno(this, TITULO, 800, 600);
		this.fondo = new Fondo(entorno,400);
		
		this.conejo = new Conejo(entorno);
		this.carretera1= new Carretera(entorno,Sentido.DERECHA,-95,0); //Se crea una carretera, la cual pide un sentido y una posicion
		this.carretera2= new Carretera(entorno,Sentido.IZQUIERDA,-35,1);
		this.carretera3= new Carretera(entorno,Sentido.DERECHA,33,2);
		this.carretera4= new Carretera(entorno,Sentido.IZQUIERDA,95,3);
		
		this.carretera5= new Carretera(entorno,Sentido.DERECHA,253,0);
		this.carretera6= new Carretera(entorno,Sentido.IZQUIERDA,315,1);
		this.carretera7= new Carretera(entorno,Sentido.DERECHA,383,2);
		this.carretera8= new Carretera(entorno,Sentido.IZQUIERDA,445,3);
		
		this.kamehameha = new Kamehameha(entorno, conejo);
		
		this.zanahorias=new Zanahorias(entorno, conejo);
		
		this.rayoConversorZanahoria=new RayoConversorZanahoria(entorno, conejo);
		
		this.autos1 = new Trafico(entorno,carretera1,conejo,kamehameha,zanahorias,rayoConversorZanahoria,2); //Se crea un arreglo de autos la cual toma una carretera (con su respectivo sentido), un conejo, y una velocidad
		this.autos2 = new Trafico(entorno,carretera2,conejo,kamehameha,zanahorias,rayoConversorZanahoria,1.1);
		this.autos3 = new Trafico(entorno,carretera3,conejo,kamehameha,zanahorias,rayoConversorZanahoria,0.8);
		this.autos4 = new Trafico(entorno,carretera4,conejo,kamehameha,zanahorias,rayoConversorZanahoria,0.47);
		this.autos5 = new Trafico(entorno,carretera5,conejo,kamehameha,zanahorias,rayoConversorZanahoria,2);
		this.autos6 = new Trafico(entorno,carretera6,conejo,kamehameha,zanahorias,rayoConversorZanahoria,1.5);
		this.autos7 = new Trafico(entorno,carretera7,conejo,kamehameha,zanahorias,rayoConversorZanahoria,0.7);
		this.autos8 = new Trafico(entorno,carretera8,conejo,kamehameha,zanahorias,rayoConversorZanahoria,0.43);
		
		this.carreteras = new Carretera[] {carretera1,carretera2,carretera3,carretera4,carretera5,carretera6,carretera7,carretera8};
		this.trafico = new Trafico[] {autos1,autos2,autos3,autos4,autos5,autos6,autos7,autos8};
		
		this.zaWarudo = new ZaWarudo(entorno, conejo, fondo, carreteras, trafico, zanahorias);
		
		this.obstaculos=new Obstaculos(entorno, conejo,carreteras);
		
		this.ganaste=false;
		this.perdiste=false;
		
		juegoActivoFueraTick();
		//reproducirMusica();
		
		this.entorno.iniciar();
	}
	
	public void tick()
	{
		juegoActivoTick();

	}
	private void juegoActivoFueraTick() 
	{
		conejo.inicarComponentesFueraTick();
		zanahorias.iniciarComponentesFueraTick();
		autos1.iniciarComponentesFueraTick(); 
		autos2.iniciarComponentesFueraTick();
		autos3.iniciarComponentesFueraTick();
		autos4.iniciarComponentesFueraTick();
		autos5.iniciarComponentesFueraTick();
		autos6.iniciarComponentesFueraTick();
		autos7.iniciarComponentesFueraTick();
		autos8.iniciarComponentesFueraTick();
		
		kamehameha.iniciarComponentesFueraTick();
		
		obstaculos.iniciarComponentesFueraTick();
		
		
	}
	private void juegoActivoTick() {
		if(!juegoTerminado()) {
			fondo.iniciarComponentesEnTick();
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
			zanahorias.iniciarComponentesEnTick();
			rayoConversorZanahoria.iniciarComponentesEnTick();
			autos1.iniciarComponentesEnTick();
			autos2.iniciarComponentesEnTick();
			autos3.iniciarComponentesEnTick();
			autos4.iniciarComponentesEnTick();
			autos5.iniciarComponentesEnTick();
			autos6.iniciarComponentesEnTick();
			autos7.iniciarComponentesEnTick();
			autos8.iniciarComponentesEnTick();
			zaWarudo.iniciarComponentesEnTick();
			obstaculos.iniciarComponentesEnTick();
			
		}
		else if (conejo.getPuntaje()>=40) 
		{
			win();
			//detenerMusica();
		}
		else if (!conejo.getVida()){
			gameOver();
			//detenerMusica();
		}
	}	
	private void reproducirMusica() 
	{
		musica=Herramientas.cargarSonido("./resources/sonido/rabbit.wav");
		musica.loop(Clip.LOOP_CONTINUOUSLY);
	}
	private void detenerMusica() 
	{
		musica.stop();
	}
	
	private boolean juegoTerminado() 
	{
		if(!conejo.getVida())
		{
			return true;
		}
		if(conejo.getPuntaje()>=40) 
		{
			return true;
		}
		return false;
	}
	
	
	private void gameOver() 
	{
		if (!perdiste) {
			Herramientas.play("./resources/sonido/game-over.wav");
		}
		this.perdiste=true;
		entorno.cambiarFont("Arial", 100, Color.white);
		entorno.escribirTexto("¡PERDISTE!", entorno.ancho()/8, entorno.alto()/2);
		if(entorno.sePresiono('r'))
		{
			
			new Juego();
		}
	}
	private void win() 
	{
		if(!ganaste) {
			Herramientas.play("./resources/sonido/wins.wav");
		}
		this.ganaste=true;
		entorno.cambiarFont("Arial", 100, Color.white);
		entorno.escribirTexto("¡GANASTE!", entorno.ancho()/8, entorno.alto()/2);
		if(entorno.sePresiono('r'))
		{
			new Juego();
		}
	}
	
}