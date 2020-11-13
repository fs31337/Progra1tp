package juego;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import entorno.*;

public class Conejo {
	private double x,y,angulo;
	private int ancho,alto,velocidad,puntaje,saltos;
	private Entorno entorno;
	private boolean vida;
	private boolean espera;
	
	public Conejo(Entorno entorno) {
		this.entorno=entorno;
		this.ancho=20;
		this.alto=20;
		this.velocidad=40;
		this.angulo=Herramientas.radianes(270);
		this.vida=true;
		this.espera=false;
		this.puntaje=0;
		this.saltos=0;
	}
	public void sumarPuntaje(int puntaje) {
		this.puntaje+=puntaje;
	}
	public void sumarPuntaje() {
		if(this.y>100) {
			this.puntaje++;
		}
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getAngulo() {
		return this.angulo;
	}
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getVelocidad() {
		return this.velocidad;
	}
	public boolean getVida() {
		return this.vida;
	}
	public void setVida(boolean vida) {
		this.vida=vida;
	}
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public void iniciarComponentesEnTick() {
		if(vida==true) {
		dibujarConejo();
		moverse();
		moverAbajo();
		tocaLimite();
		mostarPuntaje();
		}
	}
	public void inicarComponentesFueraTick() {
		if (vida==true) {
		establecerPos();
		tiempoEspera();
		}
	}
	private void moverAbajo() {
		y+=0.2;
	}
	private void tocaLimite() {
		if(this.y>entorno.alto()+30) {
			this.vida=false;
		}
		if(this.x<0) {
			x+=velocidad;
		}
		if(this.x>entorno.ancho()) {
			x-=velocidad;
		}
		if(this.y<100) {
			y+=velocidad;
		}
	}
	private void establecerPos() {
		x=entorno.ancho()/2;
		y=(entorno.alto()/2)+200;
	}
	
	private void dibujarConejo() {
		entorno.dibujarTriangulo(x, y, alto, ancho, angulo, Color.red);
	}
	private void moverse() {
		if(!espera) {
			if(entorno.sePresiono('w') || entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				y-=velocidad;
				angulo=Herramientas.radianes(270);
				espera=true;
				saltos++;
				sumarPuntaje();
			}
			if(entorno.sePresiono('a') || entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
				x-=velocidad;
				angulo=Herramientas.radianes(180);
				espera=true;
			}
			if(entorno.sePresiono('d') || entorno.sePresiono(entorno.TECLA_DERECHA)) {
				x+=velocidad;
				angulo=Herramientas.radianes(0);
				espera=true;
			}
			
	}
	}
	private void tiempoEspera() {
		Timer tiempo=new Timer();
		TimerTask tarea=new TimerTask() {

			@Override
			public void run() {
				espera=false;
				
			}
			
		};
		tiempo.schedule(tarea, 0,300);
	}
	private void mostarPuntaje() {
		entorno.cambiarFont("Arial Black", 20, Color.white);
		entorno.escribirTexto("Puntos: "+puntaje, 20, 20);
		entorno.escribirTexto("Saltos: "+saltos, 175, 20);
	}
}
