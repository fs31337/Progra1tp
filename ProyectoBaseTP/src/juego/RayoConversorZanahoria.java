package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import entorno.*;

public class RayoConversorZanahoria {
	private double x,y,ancho,alto;
	private boolean activo;
	private Entorno entorno;
	private Conejo conejo;
	private boolean recarga;
	private Timer tiempoActivo;
	private Timer tiempoRecarga;
	private int cent,seg;
	private Image spell;
	private Image spell1;
	private Image spell2;
	private Image spell3;
	private Image spell4;
	private Image[] rayoconversor;
	
	
	
	
	public RayoConversorZanahoria(Entorno entorno, Conejo conejo) {
		this.x=0;
		this.y=0;
		this.ancho=30;
		this.alto=30;
		this.activo=false;
		this.entorno=entorno;
		this.conejo=conejo;
		//this.zanahoria=zanahoria;
		this.recarga=false;
		this.cent=0;
		this.seg=0;
		cargarImagenes();
		
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
	public boolean getRecarga() {
		return this.recarga;
	}
	public void setActivo(boolean activo) {
		this.activo=activo;
	}
	public void iniciarComponentesEnTick() {
			activar();
	}
	public void iniciarComponentesFueraTick() {
		
	}
	private void tiempoRecarga() {
		tiempoRecarga = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recarga=false;
				tiempoRecarga.stop();
				
			}
		});
		tiempoRecarga.start();
	}
	
	private void cargarImagenes() {
		try {
			this.spell = Herramientas.cargarImagen("./resources/spells/conversorzanahoria.png");
			this.spell1 = Herramientas.cargarImagen("./resources/spells/conversorzanahoria1.png");
			this.spell2 = Herramientas.cargarImagen("./resources/spells/conversorzanahoria2.png");
			this.spell3 = Herramientas.cargarImagen("./resources/spells/conversorzanahoria3.png");
			this.spell4 = Herramientas.cargarImagen("./resources/spells/conversorzanahoria4.png");
			
			}		
		catch (Exception e){
			e.printStackTrace(System.err);
		}
		rayoconversor = new Image[] {spell,spell1,spell2,spell3,spell4};
	}
	
	private void tiempoActivo() {
		tiempoActivo = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				activo=false;
				tiempoActivo.stop();
				
			}
		});
		tiempoActivo.start();
		
	}
	private void dibujar() {
		//entorno.dibujarRectangulo(x, y, ancho, alto, Herramientas.radianes(270), Color.yellow);
		entorno.dibujarImagen(rayoconversor[nRandom()], x, y, 0, 0.04);
	}
	private void posicionar() {
		this.x=conejo.getX();
		this.y=conejo.getY();
	}
	private void activar() {
		if(entorno.sePresiono('r') && recarga==false && activo==false) {
			this.activo=true;
			this.recarga=true;
			tiempoActivo();
			posicionar();
			tiempoRecarga();
			cent=0;
			seg=4;
			Herramientas.play("./resources/sonido/Rayo_Laser.wav");
			
		}
		if(activo==true) {
			this.y-=2;
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
		entorno.escribirTexto("Recarga Rayo Conversor= "+seg, 490, 40);
	}
	
	private int nRandom() {
		int numero = (int) (Math.random() * 5);
		return numero;
	}
	
}
	
