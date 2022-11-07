package source;

import java.lang.Math;

/**
 * 
 * @author Jerome
 *
 */
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
	//Fin des constructeurs
	
	
	//accesseurs de Numero
	public int getNumero() {
			
			return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	Fin des accesseurs
	
	
	//Retourne une chaîne de caractères avec les données de la ville sous forme
	//compacte 
	public String toString() {
		return "Ville# " + numero + " (" + posX + ", " + posY + ")";
	}
	
	
	//calcule la distance avec la ville courante (this) et une autre ville
	public double distanceAvec(Ville ville) {
		 return Math.sqrt(Math.pow(ville.posX - this.posX, 2) + (Math.pow
				 	(ville.posY - this.posY, 2)));
	}
	
}
