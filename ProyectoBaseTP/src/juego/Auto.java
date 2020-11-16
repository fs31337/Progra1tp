package juego;

import java.awt.Color;

import entorno.*;
import juego.Carretera.Sentido;

public class Auto {
	private double x,y,angulo,velocidad;
	private int ancho,alto;
	private Entorno entorno;
	private Carretera carretera;
	private Conejo conejo;
	private boolean vida;
	private Kamehameha kamehameha;
	private Zanahoria zanahoria;
	private RayoConversorZanahoria rayoConversorZanahoria;
	
	public Auto(Entorno entorno,Carretera carretera,Conejo conejo,Kamehameha kamehameha,Zanahoria zanahoria,RayoConversorZanahoria rayoConversorZanahoria,double velocidad) {
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
		this.zanahoria=zanahoria;
		this.rayoConversorZanahoria=rayoConversorZanahoria;
	}
	
	public void iniciarComponentesEnTick() {
		if(this.vida) {
			dibujarse();
			avanzar();
			resetear();
			matarConejo();
			destruirAuto();
			convertirAutoEnZanahoria();
		}
	}
	public void iniciarComponentesFueraTick() {
		setY();
		setAngulo();
	}
	private void setAngulo() {
		if(carretera.getSentido().equals(Sentido.DERECHA)) {
			angulo=Herramientas.radianes(0);
		}
		if(carretera.getSentido().equals(Sentido.IZQUIERDA)) {
			angulo=Herramientas.radianes(180);
		}
	}
	private void setY() {
		this.y=carretera.getY();
	}
	
	public void setX(double x) {
		this.x=x;
	}
	private void avanzar() {
		y=carretera.getY();
		if(carretera.getSentido().equals(Sentido.DERECHA)) {
			x+=velocidad;
		}
		if(carretera.getSentido().equals(Sentido.IZQUIERDA)) {
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
	private boolean tocaRayoConversorZanahoria() {
		return this.x > rayoConversorZanahoria.getX() - (this.ancho*2) &&
				this.x < rayoConversorZanahoria.getX() +(this.ancho*2) &&
				this.y > rayoConversorZanahoria.getY() - (this.alto*2) &&
				this.y < rayoConversorZanahoria.getY() + (this.alto*2);
	}
	private void destruirAuto() {
		if(tocaKamehameha() && kamehameha.getActivo()) {
			this.vida=false;
			kamehameha.setActivo(false);
			conejo.sumarPuntaje(5);
		}
	}
	private void convertirAutoEnZanahoria() {
		if(tocaRayoConversorZanahoria() && rayoConversorZanahoria.getActivo()) {
			rayoConversorZanahoria.setActivo(false);
			zanahoria.setX(this.x);
			zanahoria.setY(this.y);
			zanahoria.setVisible(true);
			this.vida=false;
		}
	}
}
