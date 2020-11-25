package juego;

import java.util.ArrayList;
import java.util.Random;

import entorno.Entorno;

public class Obstaculos {
	Entorno entorno;
	Carretera carreteras[];
	Obstaculo obstaculos[];
	ArrayList<Carretera> listaCarreteras;
	Conejo conejo;
	int cantCarreteras;
	
	public Obstaculos(Entorno entorno, Conejo conejo, Carretera carreteras[]) {
		this.entorno=entorno;
		this.conejo=conejo;
		this.carreteras=carreteras;
		this.obstaculos=new Obstaculo[5];
		listaCarreteras=new ArrayList<Carretera>();
		this.cantCarreteras=7;
	}
	private void listarCarreteras() {
		for(Carretera carretera:carreteras) {
			listaCarreteras.add(carretera);
		}
	}
	private void crearObstaculos() {
		int random=0;
		for(int i=0;i<obstaculos.length;i++) {
			Obstaculo obstaculo=new Obstaculo(entorno,conejo,listaCarreteras.get(random=nRandom()));
			obstaculo.setX(xRandom());
			obstaculo.setAncho(anchoRandom());
			eliminarElemento(random);
			cantCarreteras--;
			obstaculos[i]=obstaculo;
		}
	}
	private int nRandom() {
		int numero = (int) (Math.random() * cantCarreteras);
		return numero;
	}
	private int xRandom() {
		int numero = (int) (Math.random() * 800);
		return numero;
	}
	private int anchoRandom() {
		int numero = (int) (Math.random() * 300)+50;
		return numero;
	}
	private void eliminarElemento(int i) {
		listaCarreteras.remove(i);
	}
	public void iniciarComponentesEnTick() {
		for(Obstaculo obstaculo:this.obstaculos) {
			obstaculo.iniciarComponentesEnTick();
		}
	}
	public void iniciarComponentesFueraTick() {
		listarCarreteras();
		crearObstaculos();
	}
}
