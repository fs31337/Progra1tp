package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.*;
import juego.Carretera.Sentido;

public class Carretera {
	
	enum Sentido {
		DERECHA, IZQUIERDA
	}
	private double x,y,ancho,alto;
	private Sentido sentido;
	private Entorno entorno;
	private Image imagen;
	private Image calle1;
	private Image calle2;
	private Image calle3;
	private Image calle4;
	private Image[] calles;
	
	
	public Carretera(Entorno entorno,Sentido sentido, double y,int imagen) {
		this.entorno=entorno;
		this.x=entorno.ancho()/2;
		this.y=y;
		this.alto=50;
		this.ancho=entorno.ancho();
		this.sentido=sentido;
		cargarImagenes();
		this.imagen = calles[imagen];		
		
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
	
	private void cargarImagenes() {
		try {
				this.calle1 = Herramientas.cargarImagen("./resources/fondo/calle1.png");
				this.calle2 = Herramientas.cargarImagen("./resources/fondo/calle2.png");
				this.calle3 = Herramientas.cargarImagen("./resources/fondo/calle3.png");
				this.calle4 = Herramientas.cargarImagen("./resources/fondo/calle4.png");
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
		calles = new Image [] {calle1,calle2,calle3,calle4};
	}
	private void dibujarCarretera() {
		//entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.blue);
		entorno.dibujarImagen(imagen, x, y, 0, 0.6);
	}
	private void avanzar() {
		y+=0.2;
	}
	public void detener() {
		y-=0.2;
	}
	private void reiniciar() {
		if(y>entorno.alto()+50) {
			y=0;
		}
	}
}
