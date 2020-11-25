package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.Timer;

import entorno.*;

public class Conejo {
	public double x,y; //quitar angulo
	public int ancho,alto,velocidad;//quito saltos y puntaje;
	public Image imagenarr;
	public Image imagenizq;
	public Image imagender;
	public Image ultimaImagen;
	
	public Conejo() {
		this.ancho=20;
		this.alto=20;
		this.velocidad=40;	
		cargarImagenes();
	}
	private void cargarImagenes() {
		try {
			this.imagenarr = Herramientas.cargarImagen("./resources/conejo/conejoarr.png");
			this.imagenizq = Herramientas.cargarImagen("./resources/conejo/conejoizq.png");
			this.imagender = Herramientas.cargarImagen("./resources/conejo/conejoder.png");
			this.ultimaImagen=imagenarr;
			}
		catch (Exception e){
			e.printStackTrace(System.err);
		}	
	}	
	

	/*public void inicarComponentesFueraTick() {
		establecerPos();
		}
	}*/	
	
	
	public void dibujarse(Entorno entorno) {
		  entorno.dibujarImagen(ultimaImagen, x, y, 0, 1.5);		
		}

	public void saltar() {
		this.ultimaImagen=imagenarr;
		y-=velocidad;
		}
	
	public void moverIzq() {
		this.ultimaImagen=imagenizq;
		x-=velocidad;
		}
	
	public void moverDer() {
		this.ultimaImagen=imagender;
		x+=velocidad;
		}
			
	
	}

	/*public void moverseNegativo() {
		
			if(entorno.sePresiono('w') || entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				
				y+=velocidad;
				espera=true;
				saltos--;
							
			}
			if(entorno.sePresiono('a') || entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
				
				x+=velocidad;
				espera=true;
				
			}
			if(entorno.sePresiono('d') || entorno.sePresiono(entorno.TECLA_DERECHA)) {
				this.ultimaImagen=imagender;
				x-=velocidad;
				espera=true;
				
			
			
	}
	}*/


