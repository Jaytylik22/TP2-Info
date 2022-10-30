package source;

import java.lang.Math;

public class Ville {

	
	public int numero;
	public double posX;
	public double posY;
	
	
	
	//Constructeurs
	public Ville(){
		
	}
	
	public Ville(int numero, double posX, double posY){
		
		this.numero = numero;
		this.posX = posX;
		this.posY = posY;				
	}
	
	public Ville(Ville ville){
		
		numero = ville.numero;
		posX = ville.posX;
		posY = ville.posY;
	}
	
	
	//accesseurs
	public int getNumero() {
			
			return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	//toString()
	public String toString() {
		return "Ville# " + numero + " (" + posX + ", " + posY + ")";
	}
	
	
	//distanceAvec
	public double distanceAvec(Ville ville) {
		 return Math.sqrt(Math.pow(ville.posX - this.posX, 2) + (Math.pow(ville.posY - this.posY, 2)));
	}
	
}
