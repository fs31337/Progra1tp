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
	
	public Auto(Entorno entorno,Carretera carretera,Conejo conejo,double velocidad) {
		this.entorno=entorno;
		this.carretera=carretera;
		this.y=0;
		this.x=0;
		this.alto=50;
		this.ancho=50;
		this.conejo=conejo;
		this.velocidad=velocidad;
		this.vida=true;
		
	}
	
	public void iniciarComponentesEnTick() {
		if(vida==true) {
			dibujarse();
			avanzar();
			resetear();
			matarConejo();
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
		return this.x > conejo.getX() - this.ancho &&
				this.x < conejo.getX() +this.ancho &&
				this.y > conejo.getY() - this.alto &&
				this.y < conejo.getY() + this.alto;
	}
	private void matarConejo() {
		if(tocaConejo()) {
			conejo.setVida(false);
		}
	}
}
