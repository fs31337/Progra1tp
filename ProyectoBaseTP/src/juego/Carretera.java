package juego;

import java.awt.Color;


import entorno.*;

public class Carretera {
	private double x,y,ancho,alto;
	private String sentido;
	private Entorno entorno;
	public Carretera(Entorno entorno,String sentido, double y) {
		this.entorno=entorno;
		this.x=entorno.ancho()/2;
		this.y=y;
		this.alto=100;
		this.ancho=entorno.ancho();
		this.sentido=sentido;
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
	public String getSentido() {
		return this.sentido;
	}
	public void iniciarComponentesEnTick() {
		dibujarCarretera();
		avanzar();
		reiniciar();
	}
	private void dibujarCarretera() {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.blue);
	}
	private void avanzar() {
		y+=0.5;
	}
	private void reiniciar() {
		if(y>entorno.alto()+50) {
			y=0;
		}
	}
}
