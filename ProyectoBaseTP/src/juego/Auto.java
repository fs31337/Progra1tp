package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

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
	private Zanahorias zanahorias;
	private RayoConversorZanahoria rayoConversorZanahoria;
	private Image imagen;
	private Image auto1;
	private Image auto2;
	private Image auto3;
	private Image auto4;
	private Image auto5;
	private Image[] autos;

	
	public Auto(Entorno entorno,Carretera carretera,Conejo conejo,Kamehameha kamehameha,Zanahorias zanahorias,RayoConversorZanahoria rayoConversorZanahoria,double velocidad) {
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
		this.zanahorias=zanahorias;
		this.rayoConversorZanahoria=rayoConversorZanahoria;
		cargarImagenes();
		this.imagen = autos[nRandom()];
		
		
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
	
	private void cargarImagenes() {
		try {
			this.auto1 = Herramientas.cargarImagen("./resources/cars/red.png");
			this.auto2 = Herramientas.cargarImagen("./resources/cars/lightblue.png");
			this.auto3 = Herramientas.cargarImagen("./resources/cars/yellow.png");
			this.auto4 = Herramientas.cargarImagen("./resources/cars/pink.png");
			this.auto5 = Herramientas.cargarImagen("./resources/cars/green.png");
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
		autos = new Image[] {auto1,auto2,auto3,auto4,auto5};
	}
	public void setVida(boolean vida) {
		this.vida=vida;
	}
	public void iniciarComponentesFueraTick() {
		setY();
		setAngulo();
	}
	private void setAngulo() {
		if(carretera.getSentido().equals(Sentido.DERECHA)) {
			angulo=Herramientas.radianes(90);
		}
		if(carretera.getSentido().equals(Sentido.IZQUIERDA)) {
			angulo=Herramientas.radianes(270);
		}
	}
	private void setY() {
		this.y=carretera.getY();
	}
	
	public void setX(double x) {
		this.x=x;
	}
	public double getY() {
		return this.y;
	}
	public double getX() {
		return this.x;
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
	public void detener() {
		y=carretera.getY();
		if(carretera.getSentido().equals(Sentido.DERECHA)) {
			x-=velocidad;
		}
		if(carretera.getSentido().equals(Sentido.IZQUIERDA)) {
			x+=velocidad;
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
	
	private int nRandom() {
		int numero = (int) (Math.random() * 5);
		return numero;
	}
	
	private void dibujarse() {
		//entorno.dibujarTriangulo(x, y, alto, ancho, angulo, Color.green);
		entorno.dibujarImagen(imagen, x, y, angulo, 0.6);
	}
	
	private boolean tocaConejo() {
		return this.x > conejo.getX() - (this.ancho/0.9) &&
				this.x < conejo.getX() +(this.ancho/0.9) &&
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
			zanahorias.getZanahorias()[Zanahorias.contZanahorias].setX(this.x);
			zanahorias.getZanahorias()[Zanahorias.contZanahorias].setY(this.y);
			zanahorias.getZanahorias()[Zanahorias.contZanahorias].setVisible(true);
			Zanahorias.contZanahorias++;
			if(Zanahorias.contZanahorias>=4) {
				Zanahorias.contZanahorias=0;
			}
			this.vida=false;
		}
	}
}
