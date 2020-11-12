package juego;


import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Conejo Conejo;
	Auto[] autos;
	Auto[] autos2;
	Auto[] autos3;
	Auto[] autos4;
	
	// Variables y métodos propios de cada grupo
	// ...

	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		this.Conejo = new Conejo(400,450,20);
		
		this.autos = new Auto[5];
		this.autos2 = new Auto[5];
		this.autos3 = new Auto[5];
		this.autos4 = new Auto[5];
		
		Random rnd = new Random();
		
		for (int i=0;i < this.autos.length;i++) {
			int x = rnd.nextInt(this.entorno.ancho() - 20);
			this.autos[i] = new Auto(x,300);
			}
		for (int i=0;i < this.autos2.length;i++) {
			int x = rnd.nextInt(this.entorno.ancho() - 20);
			this.autos2[i] = new Auto(x,100);
			}
		for (int i=0;i < this.autos3.length;i++) {
			int x = rnd.nextInt(this.entorno.ancho() - 20);
			this.autos3[i] = new Auto(x,200);
			}
		for (int i=0;i < this.autos4.length;i++) {
			int x = rnd.nextInt(this.entorno.ancho() - 20);
			this.autos4[i] = new Auto(x,400);
			}

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		dibujandoConejo();
		dibujandoAutos();
		this.Conejo.caerse();
		
		
	}
	
	void dibujandoConejo() {
		Conejo.dibujarse(this.entorno);
		
		if (this.entorno.sePresiono(this.entorno.TECLA_ARRIBA))
		{
			this.Conejo.saltar();
		}
		if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA))
		{
			this.Conejo.moverDer();
		}
		if (this.entorno.sePresiono(this.entorno.TECLA_IZQUIERDA))
		{
			this.Conejo.moverIzq();
		}
		if (this.Conejo.y>=600) {
			
		}
	}
	
	boolean llegoAlFondo(Auto autos) {
		return autos.y > this.entorno.alto();
	}
	
	boolean llegoALaDerecha(Auto autos) {
		return autos.x > this.entorno.ancho();
	}
	
	void dibujandoAutos() {
		for (int i = 0; i < this.autos.length; i++) {
			if (this.autos[i] != null) {
				this.autos[i].dibujarse(this.entorno);
				this.autos[i].avanzar();
				
				if (llegoALaDerecha(this.autos[i])){	
					this.autos[i].caerse();
					this.autos[i].x = 0;
				}
				
				if (llegoAlFondo(this.autos[i])) {
					this.autos[i].y = 300;
				}
			}
		}
		for (int i = 0; i < this.autos2.length; i++) {
			if (this.autos2[i] != null) {
				this.autos2[i].dibujarse(this.entorno);
				this.autos2[i].avanzar();
				
				if (llegoALaDerecha(this.autos2[i])){	
					this.autos2[i].caerse();
					this.autos2[i].x = 0;
				}
				
				if (llegoAlFondo(this.autos[i])) {
					this.autos2[i].y = 300;
				}
			}
		}
		for (int i = 0; i < this.autos3.length; i++) {
			if (this.autos3[i] != null) {
				this.autos3[i].dibujarse(this.entorno);
				this.autos3[i].avanzar();
				
				if (llegoALaDerecha(this.autos3[i])){	
					this.autos3[i].caerse();
					this.autos3[i].x = 0;
				}
				
				if (llegoAlFondo(this.autos3[i])) {
					this.autos3[i].y = 300;
				}
			}
		}
		for (int i = 0; i < this.autos4.length; i++) {
			if (this.autos4[i] != null) {
				this.autos4[i].dibujarse(this.entorno);
				this.autos4[i].avanzar();
				
				if (llegoALaDerecha(this.autos4[i])){	
					this.autos4[i].caerse();
					this.autos4[i].x = 0;
				}
				
				if (llegoAlFondo(this.autos4[i])) {
					this.autos4[i].y = 300;
				}
			}
		}
	}
	
	
	
	
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
