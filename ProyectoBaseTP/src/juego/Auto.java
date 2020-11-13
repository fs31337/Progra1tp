package juego;

import java.awt.Color;

import entorno.*;

public class Auto {
	private double x,y,angulo,velocidad;
	private int ancho,alto;
	private Entorno entorno;
	private Carretera carretera;
	private Conejo conejo;
	private boolean vida;
	private Kamehameha kamehameha;
	
	public Auto(Entorno entorno,Carretera carretera,Conejo conejo,Kamehameha kamehameha,double velocidad) {
		this.entorno=entorno;
		this.carretera=carretera;
		this.y=0;
		this.x=0;
		this.alto=30;
		this.ancho=30;
		this.conejo=conejo;
		this.velocidad=velocidad;
		this.vida=true;
		this.kamehameha=kamehameha;
	}
	
	public void iniciarComponentesEnTick() {
		if(this.vida) {
			dibujarse();
			avanzar();
			resetear();
			matarConejo();
			destruirAuto();
		}
	}
	public void iniciarComponentesFueraTick() {
		setY();
		setAngulo();
	}
	private void setAngulo() {
		if(carretera.getSentido().equals("derecha")) {
			angulo=Herramientas.radianes(0);
		}
		if(carretera.getSentido().equals("izquierda")) {
			angulo=Herramientas.radianes(180);
		}
	}
	private void setY() {
		this.y=carretera.getY();
	}
	/*private void setX() {
		if(carretera.getSentido().equals("derecha")) {
			x=0;
		}
		if(carretera.getSentido().equals("izquierda")) {
			x=entorno.ancho();
		}
	}*/
	public void setX(double x) {
		this.x=x;
	}
	private void avanzar() {
		y=carretera.getY();
		if(carretera.getSentido().equals("derecha")) {
			x+=velocidad;
		}
		if(carretera.getSentido().equals("izquierda")) {
			x-=velocidad;
		}
	}
	private void resetear() {
		if(x>entorno.ancho()+50) {
			x=0;
		}
		if(x<-50) {
			x=entorno.ancho();
		}
	}
	private void dibujarse() {
		entorno.dibujarTriangulo(x, y, alto, ancho, angulo, Color.green);
	}
	private boolean tocaConejo() {
		return this.x > conejo.getX() - (this.ancho/1.5) &&
				this.x < conejo.getX() +(this.ancho/1.5) &&
				this.y > conejo.getY() - (this.alto/1.5) &&
				this.y < conejo.getY() + (this.alto/1.5);
	}
	private void matarConejo() {
		if(tocaConejo()) {
			conejo.setVida(false);
		}
	}
	private boolean tocaKamehameha() {
		return this.x > kamehameha.getX() - (this.ancho*2) &&
				this.x < kamehameha.getX() +(this.ancho*2) &&
				this.y > kamehameha.getY() - (this.alto*2) &&
				this.y < kamehameha.getY() + (this.alto*2);
	}
	private void destruirAuto() {
		if(tocaKamehameha() && kamehameha.getActivo()) {
			this.vida=false;
			kamehameha.setActivo(false);
			conejo.sumarPuntaje(5);
		}
	}
}
