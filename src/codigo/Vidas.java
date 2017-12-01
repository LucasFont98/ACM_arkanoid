package codigo;
import java.awt.Color;
import java.awt.Font;
import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Author: Lucas Font
 */

public class Vidas extends GRect {
	//Indicamos que empieze la partida con 3 vidas
	GLabel textovida = new GLabel("");
	static int vidas = 3;
	//Colocamos la posicion de las vidas e indicamos el color y el tamaño
	public Vidas(double width, double height) 
	{
		super(width, height);
		setFilled(true);
		setFillColor(Color.WHITE);
		textovida.setLabel("Vidas: " + vidas);
		textovida.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
	//Indicamos que actualize las vidas
	public void actualizaMarcadorVidas(int vida)
	{
		vidas += vida;
		textovida.setLabel("Vidas: " + vidas);
	}
	
}