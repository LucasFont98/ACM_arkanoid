package codigo;
/*
 * Author: Lucas Font
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{

	//Indicamos la velocidad de la bola en el eje X y el eje Y
	double xVelocidad = 1; 
	double yVelocidad = -1;

	
	public Pelota(double _ancho, double _alto){
		super(_ancho, _alto);
	}

	//Ponemos el tamaño de la bola
	public Pelota(double _ancho, Color _color){
		super(_ancho, _ancho);
		if (_ancho <=0){
			setSize(1, 1);
		}
		setFillColor(_color);
		setFilled(true);
	}
	//Hacemos que se mueva la bola y que detecte los choques
	public void muevete(Arkanoid _arkanoid){
		//Chequea si ha chocado con las paredes izq o derecha
		if (getX() + getWidth() >= _arkanoid.getWidth() - _arkanoid.espacioMenu
				|| getX()<0){
			xVelocidad *= -1; 
		}
		//Chequea si ha chocado con el techo
		if(this.getY() < 0)
		{
			yVelocidad *= -1;
		}
		//En estos parametros le indicamos que cada vez que ocurra el if se cambia la posicion de la bola y restamos una vida
		if(this.getY() >= _arkanoid.getHeight() && Vidas .vidas >=3)
		{
			setLocation(_arkanoid.getWidth()/2, _arkanoid.getHeight()*0.65 - this.getHeight());
			_arkanoid.marcavida.actualizaMarcadorVidas(-1);
		}
		if(this.getY() >= _arkanoid.getHeight() && Vidas .vidas >=2)
		{
			setLocation(_arkanoid.getWidth()/2, _arkanoid.getHeight()*0.80 - this.getHeight());
			_arkanoid.marcavida.actualizaMarcadorVidas(-1);
		}
		if(this.getY() >= _arkanoid.getHeight() && Vidas .vidas >=1)
		{
			setLocation(_arkanoid.getWidth()/2, _arkanoid.getHeight()*0.65 - this.getHeight());
			_arkanoid.marcavida.actualizaMarcadorVidas(-1);
		}
		if(Marcador.puntuacion >349 && Marcador.puntuacion <351) 
		{
			setLocation(_arkanoid.getWidth()/2, _arkanoid.getHeight()*0.65 - this.getHeight());
		}
		//Aqui chequeamos si ha chocado con las esquinas
		if (chequeaColision(getX(), getY(), _arkanoid))//chequeo la esquina superior izquierda
		{
			if (chequeaColision(getX() + getWidth(), getY(), _arkanoid))//chequeo la esquina superior derecha
			{
				if (chequeaColision(getX(), getY() + getHeight(), _arkanoid))//chequeo la esquina inferior izquierda
				{
					if (chequeaColision(getX() + getWidth(), getY() + getHeight(), _arkanoid))//chequeo la esquina inferior derecha
					{

					}
				}
			}
		}


		move(xVelocidad, yVelocidad);
	}

	//Aqui le indicamos si ha chocado con las esquinas de los ladrillos
	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado = true;
		GObject auxiliar;
		auxiliar = _arkanoid.getElementAt(posX, posY);

		if (auxiliar instanceof Ladrillo){
			if (auxiliar.getY() == posY || auxiliar.getY() + auxiliar.getHeight() == posY){
				yVelocidad *= -1;
			}
			else if(auxiliar.getX() == posX || auxiliar.getX() + auxiliar.getWidth() == posX){
				xVelocidad *= -1;
			}
			_arkanoid.remove(auxiliar);
			_arkanoid.marcador.actualizaMarcador(1);
			noHaChocado = false;
		}
		//Aui le decimos si ha chocado con la barra para que rebote
		else if (auxiliar instanceof Barra){

			double centroBola = getX() + getWidth()/2;
			if (centroBola > auxiliar.getX() + auxiliar.getWidth()/3 && 
				centroBola < auxiliar.getX() + 2 * auxiliar.getWidth()/3){
				yVelocidad = -1;
			}
			else {
				yVelocidad = -0.5;
			}
			noHaChocado = false;
		}
		return noHaChocado;

	}
}
