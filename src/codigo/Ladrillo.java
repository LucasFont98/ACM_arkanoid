package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/*
 * Author: Lucas Font
 */
public class Ladrillo extends GRect{

	//Creamos la clase ladrillo e indicamos el tamaño de cada ladrillo
	public Ladrillo(double x, double y, double width, double height, Color _color) {
		super(x, y, width, height);
		setFilled(true);
		setFillColor(_color);
	}

}