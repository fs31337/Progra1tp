package juego;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import entorno.*;

public class Kamehameha {
	private double x,y,ancho,alto,angulo;
	private boolean activo;
	private Entorno entorno;
	private Conejo conejo;
	private int usos;
	public Kamehameha(Entorno entorno,Conejo conejo) {
		this.entorno=entorno;
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
		this.activo=false;
		this.angulo=Herramientas.radianes(270);
		this.conejo=conejo;
		this.usos=0;
	}
	public void setActivo(boolean activo) {
		this.activo=activo;
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
	public boolean getActivo() {
		return this.activo;
	}
	
	public void iniciarComponentesFueraTick() {
		
	}
	public void iniciarComponentesEnTick() {
		
			activar();
			posicionar();
		
	}
	private void posicionar() {
		this.x=conejo.getX();
		this.y=conejo.getY()-(alto/2);
		
	}
	private void activar() {
	
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && activo==false && usos<3) {
			this.activo=true;
			this.alto=50;
			usos++;
		}
		if(activo==true) {
			this.alto+=1.5;
			dibujar();
		}
	}
	
	
	private void dibujar() {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.cyan);
	}
	
	
}
