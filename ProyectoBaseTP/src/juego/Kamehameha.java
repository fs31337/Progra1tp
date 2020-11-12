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
	public Kamehameha(Entorno entorno,Conejo conejo) {
		this.entorno=entorno;
		this.x=0;
		this.y=0;
		this.ancho=50;
		this.alto=50;
		this.activo=false;
		this.angulo=Herramientas.radianes(270);
		this.conejo=conejo;
	}
	public void iniciarComponentesFueraTick() {
		tiempoKame();
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
	
		if(entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			this.activo=true;	
		}
		if(activo==true) {
			this.alto+=1.5;
			dibujar();
		}
	}
	private void tiempoKame() {
		Timer tiempo=new Timer();
		TimerTask tarea=new TimerTask() {

			@Override
			public void run() {
				activo=false;
				ancho=50;
				alto=50;
				
			}
		};
		tiempo.schedule(tarea, 0,3000);
		
	}
	
	private void dibujar() {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.cyan);
	}
	
}
