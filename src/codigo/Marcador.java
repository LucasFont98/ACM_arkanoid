package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Author: Lucas Font
 */
public class Marcador extends GRect{

	GLabel texto = new GLabel("");
    static int puntuacion = 0; 
    //Añadimos el marcador indicando el tamaño, la posicion y el color
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.WHITE);
		setColor(Color.WHITE);
		//Aqui indicamos que la puntuacion empieze en 0 y le añadimos tamaño y color
		texto.setLabel("0" + puntuacion);
		texto.setFont(new Font("Arial", Font.BOLD, 18));
	}
	//Indicamos la posicion del texto
	public void dibuja(Arkanoid _arkanoid){
		_arkanoid.add(this, _arkanoid.getWidth() - 50, getY());
		_arkanoid.add(texto, _arkanoid.getWidth() - 50, getY()+30);
		
	}
	//Le decimos que actualize el marcador
	public void actualizaMarcador(int puntos){
		puntuacion += puntos;
		texto.setLabel("" + puntuacion);
	}

}