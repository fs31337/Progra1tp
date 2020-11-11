package juego;

import java.awt.Color;

import entorno.Entorno;

public class Auto {
	 double x;
	 double y;
	 int diametro;
	 double velocidad = 5;
	 double angulo = 0;

	 Auto(double x, double y)
	 {
		this.x = x;
		this.y = y;
		
	 }
	 
	 void dibujarse(Entorno entorno)
	 {		
		entorno.dibujarRectangulo(x, y, 50, 30, angulo, Color.GREEN);
	 }
	 
	 void avanzar() 
	 {
		 this.x = this.x + velocidad;
	 }
	 
	 void caerse() {
		 this.y = this.y + 10;
	 }





}
