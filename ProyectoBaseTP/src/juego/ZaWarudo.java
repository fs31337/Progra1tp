package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.Timer;

import entorno.*;

public class ZaWarudo {
	private Entorno entorno;
	private Conejo conejo;
	private Carretera carreteras[];
	private Trafico trafico[];
	private Zanahorias zanahorias;
	private boolean activo;
	private int usos;
	private Timer tiempoActivo;
	private int cent,seg;
	Clip tictac;
	public ZaWarudo(Entorno entorno, Conejo conejo, Carretera carreteras[],Trafico trafico[], Zanahorias zanahorias) {
		this.entorno=entorno;
		this.conejo=conejo;
		this.carreteras=carreteras;
		this.trafico=trafico;
		this.zanahorias=zanahorias;
		this.activo=false;
		this.usos=2;
		this.cent=0;
		this.seg=0;
		this.tictac=Herramientas.cargarSonido("./resources/sonido/tictac.wav");
	
	}
	public void iniciarComponentesEnTick() {
		detenerElTiempo();
	}
	private void detenerElTiempo() {
		if(entorno.sePresiono('z') && activo==false && usos>0) {
			activo=true;
			usos--;
			seg=10;
			cent=0;
			tiempoActivo();
			Herramientas.play("./resources/sonido/zaWarudo.wav");
			tictac.loop(Clip.LOOP_CONTINUOUSLY);
			
		}
		if(activo==true) {
			cent++;
			if(cent>=100) {
				seg--;
				cent=0;
			}
			detenerTodo();
			
		}
	}
	private void detenerTodo() {
		conejo.moverArriba();
		detenerCarreteras();
		detenerTrafico();
		zanahorias.detenerZanahorias();
		escribirTiempoActivo();
	}
	private void escribirTiempoActivo() {
		entorno.cambiarFont("Arial Black", 20, Color.yellow);
		entorno.escribirTexto("Za Warudo: "+seg, 490, 20);
	}
	private void detenerCarreteras() {
		for(Carretera carretera:carreteras) {
			carretera.detener();
		}
	}
	private void detenerTrafico(){
		for(Trafico trafico:this.trafico) {
			trafico.detenerTrafico();
		}
	}
	private void tiempoActivo() {
		tiempoActivo=new Timer(11000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				activo=false;
				tictac.stop();
				tiempoActivo.stop();
				
			}
		});
		tiempoActivo.start();
	}
}
