package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/*
 *Author: Lucas Font 
 */
public class Barra extends GRect{

	//Indicamos el tamaño de la barra
	public Barra(double width, double height, Color _color) {
		super(width, height);
		setFilled(true);
		setFillColor(_color);
		
	}
	//Indicamos en que posicion debe estar la barra
	public void mueveBarra(int posX, int anchoPantalla){
		if (posX + getWidth() < anchoPantalla ){
			setLocation(posX, getY());
		}
	}
	
	

}