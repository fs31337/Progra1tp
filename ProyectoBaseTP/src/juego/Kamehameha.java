package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

import javax.swing.Timer;

import entorno.*;

public class Kamehameha {
	private double x,y,ancho,alto,angulo;
	private boolean activo;
	private boolean recarga;
	private Entorno entorno;
	private Conejo conejo;
	private int usos;
	private Timer tiempoActivo;
	private Timer tiempoRecarga;
	
	private int cent;
	private int seg;
	public Kamehameha(Entorno entorno,Conejo conejo) {
		this.entorno=entorno;
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
		this.activo=false;
		this.angulo=Herramientas.radianes(270);
		this.conejo=conejo;
		this.usos=5;
		this.cent=0;
		this.seg=0;
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
			mostrarUsos();
	}
	private void tiempoActivo() {
		tiempoActivo=new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activo=false;
				tiempoActivo.stop();
			}
			
		});
		tiempoActivo.start();
	}
	private void tiempoRecarga() {
		tiempoRecarga=new Timer(4000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				recarga=false;
				tiempoRecarga.stop();
			}
			
		});
		tiempoRecarga.start();
	}
	private void posicionar() {
		this.x=conejo.getX();
		this.y=conejo.getY()-(alto/2);
		
	}
	private void activar() {
		
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && activo==false && usos>0 && recarga==false) {
			this.activo=true;
			this.recarga=true;
			this.alto=50;
			usos--;
			tiempoActivo();
			tiempoRecarga();
			cent=0;
			seg=3;
			Herramientas.play("./resources/sonido/kamehameha.wav");
		}
		if(activo==true) {
			this.alto+=1.5;
			dibujar();
		}
		if(recarga==true) {
			cent++;
			if(cent>=100) {
				seg--;
				cent=0;
			}
			escribirRecarga(seg);
		}
	}
	
	private void escribirRecarga(int seg) {
		entorno.cambiarFont("Arial Black", 20, Color.white);
		entorno.escribirTexto("Recarga Kamehameha= "+seg, 490, 60);
	}
	private void dibujar() {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.cyan);
	}
	private void mostrarUsos() {
		entorno.cambiarFont("Arial Black", 20, Color.red);
		entorno.escribirTexto("Kamehameha: "+usos, 300, 20);
	}
	
	
}
