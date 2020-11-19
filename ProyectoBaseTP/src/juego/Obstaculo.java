package juego;

import java.awt.Color;

import entorno.Entorno;

public class Obstaculo {
	private Entorno entorno;
	private Conejo conejo;
	private Carretera carretera;
	private double x,y,ancho,alto;
	
	public Obstaculo(Entorno entorno, Conejo conejo,Carretera carretera) {
		this.entorno=entorno;
		this.conejo=conejo;
		this.carretera=carretera;
		this.y=0;
		this.alto=5;
		this.ancho=30;
		
	}
	public void iniciarComponentesEnTick() {
		dibujar();
		avanzar();
		colisionConConejo();
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setAncho(double ancho) {
		this.ancho=ancho;
	}
	private void dibujar() {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.gray);
	}
	private void avanzar() {
		this.y=carretera.getY()+27;
	}
	public void detener() {
		this.y-=0.2;
	}
	private void resetear() {
		if(y>entorno.alto()+50) {
			y=-50;
		}
	}
	private boolean tocaConejo() {
		return this.x > conejo.getX() -  (this.ancho/2) &&
				this.x < conejo.getX() + (this.ancho/2) &&
				this.y > conejo.getY() - (this.alto*4) &&
				this.y < conejo.getY() + (this.alto*4);
	}
	private void colisionConConejo() {
		if(tocaConejo()) {
			conejo.moverseNegativo();
		}
	}
}
