package juego;

import java.awt.Color;

import entorno.Entorno;

public class Conejo {
	
	 double x;
	 double y;
	 int diametro;
	 double salto = 15;
	 double cae = 10;
	
	 Conejo(double x, double y, int diametro )
	 {
		this.x = x;
		this.y = y;
		this.diametro = diametro;
	 }
	 
	 void dibujarse(Entorno entorno)
	 {
		entorno.dibujarCirculo(this.x, this.y, this.diametro , Color.white);			
	 }
	
	 void saltar()
	{
		this.y = this.y - this.salto;
	}
	 
	void caerse() 
	{
		this.y = this.y + cae ;
	}
	
	void moverDer()
	{
		this.x = this.x + 20;
	}
	
	void moverIzq()
	{
		this.x = this.x - 20;
	}
	
	
	
	
}
