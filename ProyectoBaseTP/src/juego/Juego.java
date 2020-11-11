package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Conejo Conejo;
	Auto Auto;
	// Variables y métodos propios de cada grupo
	// ...

	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		this.Conejo = new Conejo(400,450,20);
		this.Auto = new Auto(0,300);

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
		//pruebo Movimiento de auto
		dibujandoAuto();
		
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
	
	void dibujandoAuto() {
		Auto.dibujarse(this.entorno);
		this.Auto.avanzar();
		
		if(this.Auto.x>=800) {
			this.Auto.x=0;
			this.Auto.caerse();
			this.Conejo.caerse();
		}
		
		if(this.Auto.y>=600) {
			this.Auto.y=300;
		}
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
