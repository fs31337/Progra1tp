package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.*;

public class Zanahoria {
	private double x,y,ancho,alto;
	private boolean visible;
	private Entorno entorno;
	private Conejo conejo;
	
	private Image zana;
	
	public Zanahoria(Entorno entorno, Conejo conejo) {
		this.x=0;
		this.y=0;
		this.ancho=20;
		this.alto=20;
		this.visible=false;
		this.entorno=entorno;
		this.conejo=conejo;
		cargarImagenes();
		
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getAncho() {
		return this.ancho;
	}
	public double getAlto() {
		return this.alto;
	}
	public void setVisible(boolean visible) {
		this.visible=visible;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	public void iniciarComponentesEnTick() {
		if(visible) {
			dibujar();
			comerZanahoria();
			avanzar();
		}
	}
	
	private void cargarImagenes() {
		try {
				this.zana = Herramientas.cargarImagen("./resources/carrot.png");
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
	}
	
	private void avanzar() {
		this.y+=0.2;
	}
	public void detener() {
		this.y-=0.2;
	}
	private void dibujar() {
		//Agregar imagen de zanahoria
		//entorno.dibujarCirculo(x, y, alto, Color.ORANGE);
		entorno.dibujarImagen(zana, x, y, 0, 0.6);
	}
	private void comerZanahoria() {
		if(tocaConejo()) {
			conejo.sumarPuntaje(2);
			this.visible=false;
			Herramientas.play("./resources/sonido/zanahoria.wav");
		}
	}
	private boolean tocaConejo() {
		return this.x > conejo.getX() - (this.ancho*2) &&
				this.x < conejo.getX() +(this.ancho*2) &&
				this.y > conejo.getY() - (this.alto*2) &&
				this.y < conejo.getY() + (this.alto*2);
	}
}
