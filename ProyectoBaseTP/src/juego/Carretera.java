package juego;

import java.awt.Color;


import entorno.*;
import juego.Carretera.Sentido;

public class Carretera {
	
	enum Sentido {
		DERECHA, IZQUIERDA
	}
	private double x,y,ancho,alto;
	private Sentido sentido;
	private Entorno entorno;
	public Carretera(Entorno entorno,Sentido sentido, double y) {
		this.entorno=entorno;
		this.x=entorno.ancho()/2;
		this.y=y;
		this.alto=50;
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
	public Sentido getSentido() {
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
		y+=0.2;
	}
	private void reiniciar() {
		if(y>entorno.alto()+50) {
			y=0;
		}
	}
}
