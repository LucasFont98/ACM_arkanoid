package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Autor: Lucas Font
 * 
 * El Arkanoid pero orientado a objetos
 */
//hay que arreglar el rebote con ladrillos, rebote con el cursor progresivo y un sistema de partida con vidas, mas niveles y bonus
public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(10, Color.BLACK);
	Barra barra1 = new Barra(400, 15, Color.BLUE);
	int anchoLadrillo = 25;
	int altoLadrillo = 15;
	int espacioMenu = 200;

	//Añadimos el sistema de marcador y el sistema de ganar y perder

	Marcador marcador = new Marcador(20, 40);
	Vidas marcavida = new Vidas (120,40);
	GLabel perder = new GLabel ("GAME OVER");
	GLabel ganar = new GLabel ("YOU WIN :)");

	
	public void init(){
		//Añadimos el tamaño del juego y colocamos el nivel 1
		addMouseListeners();
		setSize(600, 600); 
		GRect lateral = new GRect(3, getHeight());
		lateral.setFilled(true);
		dibujaNivel01();
		//Aqui ponemos la pelota la barra y el marcador de vidas
		add(lateral, getWidth() - espacioMenu - lateral.getWidth() - pelota1.getWidth(), 0);
		add(pelota1, 0, getHeight()*0.60 - pelota1.getHeight());
		add(barra1, 0 , getHeight()*0.80);
		add(marcavida.textovida, getWidth() - 92 , getHeight() - 550);
		marcador.dibuja(this);
	}

	public void run(){ 
		//Mientras haya vidas  la pelota se movera en el nivel 1 
		while(Vidas.vidas >= 1 && Vidas.vidas <= 3)
		{
			//la pelota se mueve a la velocidad seleccionada, mientras el marcador este menor que 106 y mayor que 104
			pelota1.muevete(this);
			pause(0); 
			if(Marcador.puntuacion >104 && Marcador.puntuacion <106)
			{
				//volvemos a colocar la pelota en caso de que se vaya para abajo y si pasamos de nivel añadimos el nivel 2
				pelota1.setLocation(getHeight()/2, getHeight()/2); 
				dibujaNivel02(); 
				setBackground(Color.WHITE); 
				//Si seguimos teniendo vidas se movera la pelota en el nivel 2 a la velocidad indicada y dependiendo del marcador ganaras el juego
				while(Vidas.vidas >= 1 && Vidas.vidas <= 3)
				{
					pelota1.muevete(this);
					pause(0);
					if(Marcador.puntuacion >244 && Marcador.puntuacion <246)
					{
						pelota1.setLocation(getHeight()/2, getHeight()/2);
						add(ganar, 150, 200);
					}
				}
			}	
		}
		//Si te quedas sin vidas saldra el texto del perdedor
		if(Vidas.vidas <= 0)
		{
			add(perder, 150, 200);
		}
	}
	//Aqui indicamos que la barra se mueva con el movimiento del raton
	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth()-espacioMenu);
	}
	//Creamos el nivel 1 indicando la posicion de los ladrillos
	private void dibujaNivel01(){
		int numLadrillos = 14; 
		for (int j=0; j < numLadrillos; j++){
			for(int i=j; i < numLadrillos; i++){
				Ladrillo miLadrillo =
						new Ladrillo(anchoLadrillo*i - anchoLadrillo*j/2,
								altoLadrillo*j,
								anchoLadrillo, 
								altoLadrillo, 
								Color.GREEN);

				add(miLadrillo);
				pause(3);
			}
		}
	}
	//Creamos el nivel 2 indicando la posicion de los ladrillos
	private void dibujaNivel02(){

		int numeroLadrillos2 =14;
		for(int j=0; j<10 ;j++){
			for(int i=0; i< numeroLadrillos2; i++){
				Ladrillo miLadrillo = new Ladrillo(anchoLadrillo*i,
						altoLadrillo*j,
						anchoLadrillo,
						altoLadrillo,
						Color.GREEN);
				add(miLadrillo);
				pause(3);
			}
		}

	}
	}






