package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Conejo Conejo;
	
	// Variables y m�todos propios de cada grupo
	// ...

	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		this.Conejo = new Conejo(400,450,20);

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el m�todo tick() ser� ejecutado en cada instante y 
	 * por lo tanto es el m�todo m�s importante de esta clase. Aqu� se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		dibujandoConejo();

	}
	
	void dibujandoConejo() {
		Conejo.dibujarse(this.entorno);
		this.Conejo.caerse();
		
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
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
