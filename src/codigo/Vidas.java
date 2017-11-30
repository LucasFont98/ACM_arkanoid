package codigo;
import java.awt.Color;
import java.awt.Font;
import acm.graphics.GLabel;
import acm.graphics.GRect;
public class Vidas extends GRect {
	GLabel textovida = new GLabel("");
	static int vidas = 3;
	public Vidas(double width, double height) 
	{
		super(width, height);
		setFilled(true);
		setFillColor(Color.WHITE);
		textovida.setLabel("Vidas: " + vidas);
		textovida.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
	public void actualizaMarcadorVidas(int vida)
	{
		vidas += vida;
		textovida.setLabel("Vidas: " + vidas);
	}
	
}