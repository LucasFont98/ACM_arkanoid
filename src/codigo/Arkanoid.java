package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

/*
 * Autor: Jorge Cisneros
 * 
 * El Arkanoid pero orientado a objetos
 */

public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(7, Color.GREEN);
	//Pelota pelota2 = new Pelota(30, Color.BLUE);
	Barra barra1 = new Barra(60, 15, Color.RED);
    int anchoLadrillo = 25;
    int altoLadrillo = 15;
	
	public void init(){
		addMouseListeners();
		setSize(400, 600);
		 add(pelota1, 0, getHeight()*0.60 - pelota1.getHeight());
		//add(pelota2, 0, getHeight()*0.70 - pelota2.getHeight());
		add(barra1, 0 , getHeight()*0.80);
		
	}
	
	public void run(){
		dibujaNivel01();
		while (true){
			pelota1.muevete(this);
			//pelota2.muevete(this);
			barra1.mueveBarra((int)pelota1.getX(), getWidth());
			pause(2);
		}
		
	}
	
	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth());
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
						     Color.PINK);
				
				add(miLadrillo);
				pause(7);
			}
		}
	}
}











