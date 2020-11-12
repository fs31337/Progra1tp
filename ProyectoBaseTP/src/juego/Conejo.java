package juego;

import java.awt.Color;

import entorno.*;

public class Conejo {
	private double x,y,angulo;
	private int ancho,alto,velocidad;
	private Entorno entorno;
	private boolean vida;
	
	public Conejo(Entorno entorno) {
		this.entorno=entorno;
		this.ancho=40;
		this.alto=40;
		this.velocidad=20;
		this.angulo=Herramientas.radianes(270);
		this.vida=true;
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
	public void iniciarComponentesEnTick() {
		if(vida==true) {
		dibujarConejo();
		moverse();
		moverAbajo();
		tocaLimite();
		}
	}
	public void inicarComponentesFueraTick() {
		if (vida==true) {
		establecerPos();
		}
	}
	private void moverAbajo() {
		y+=0.3;
	}
	private void tocaLimite() {
		if(this.y>entorno.alto()+30) {
			this.vida=false;
		}
		if(this.x<0) {
			x+=20;
		}
		if(this.x>entorno.ancho()) {
			x-=20;
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
		if(entorno.sePresiono('w')) {
			y-=velocidad;
			angulo=Herramientas.radianes(270);
		}
		if(entorno.sePresiono('a')) {
			x-=velocidad;
			angulo=Herramientas.radianes(180);
		}
		if(entorno.sePresiono('d')) {
			x+=velocidad;
			angulo=Herramientas.radianes(0);
		}
		if(entorno.sePresiono('s')) {
			y+=velocidad;
			angulo=Herramientas.radianes(90);
		}
	}
}
