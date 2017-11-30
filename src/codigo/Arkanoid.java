package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Autor: Jorge Cisneros
 * 
 * El Arkanoid pero orientado a objetos
 */
//hay que arreglar el rebote con ladrillos, rebote con el cursor progresivo y un sistema de partida con vidas, mas niveles y bonus
public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(10, Color.BLACK);
	//Pelota pelota2 = new Pelota(30, Color.BLUE);
	Barra barra1 = new Barra(400, 15, Color.BLUE);
	int anchoLadrillo = 25;
	int altoLadrillo = 15;
	int espacioMenu = 200;

	//el sistema del marcador

	Marcador marcador = new Marcador(20, 40);
	Vidas marcavida = new Vidas (120,40);
	GLabel perder = new GLabel ("Game Over!");
	GLabel ganar = new GLabel ("You Win :)!");

	public void init(){
		addMouseListeners();
		setSize(600, 600); 
		GRect lateral = new GRect(3, getHeight());
		lateral.setFilled(true);
		dibujaNivel01();
		
		add(lateral, getWidth() - espacioMenu - lateral.getWidth() - pelota1.getWidth(), 0);
		add(pelota1, 0, getHeight()*0.60 - pelota1.getHeight());
		add(barra1, 0 , getHeight()*0.80);
		add(marcavida.textovida, getWidth() - 92 , getHeight() - 550);
		marcador.dibuja(this);
	}

	public void run(){ 
		//while (true){
			//pelota1.muevete(this);
			//pause(5);
		while(Vidas.vidas >= 1 && Vidas.vidas <= 3)//Mientras suceda lo que indica el while se hara
		{
			pelota1.muevete(this);
			pause(0); //Especifica la velocidad
			if(Marcador.puntuacion >104 && Marcador.puntuacion <106)//Si sucede lo que indica el if ocurrira lo del interior 
			{
				pelota1.setLocation(getHeight()/2, getHeight()/2); //Colocamos de nuevo la pelota al cambiar de nivel
				dibujaNivel02(); //Dibujamos el nivel 2
				setBackground(Color.WHITE); //Cambiamos el color de fondo 
				while(Vidas.vidas >= 1 && Vidas.vidas <= 3)//Si sucede lo que indica el if ocurrira lo del interior 
				{
					pelota1.muevete(this);
					pause(0);
					if(Marcador.puntuacion >244 && Marcador.puntuacion <246)//Si sucede lo que indica el if ocurrira lo del interior
					{
						pelota1.setLocation(getHeight()/2, getHeight()/2);
						add(ganar, getWidth()/2.5, getHeight()/2);//Aparecera un texto en el lugar indicado
					}
				}
			}	
		}
		if(Vidas.vidas <= 0)//Si sucede lo que indica el if ocurrira lo del interior
		{
			add(perder, getWidth()/2.5, getHeight()/2);//Aparecera un texto en el lugar indicado
		}
	}

	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth()-espacioMenu);
	}

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






