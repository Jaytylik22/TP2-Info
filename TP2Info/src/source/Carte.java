package source;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Jerome
 *
 */
public class Carte{
	
	//
	List<Lien> listeLien=new ArrayList<Lien>();  
	int score;
	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne) {
		
	}
	
	public Carte(Object moteurDistanceMoyenne, List<Lien> section1, List<Lien> section2) {
		
	}
	
	public int getNbLiens() {
		
		return listeLien.size();
	}
	
	public int getScore() {
		
		return score;
	}
	
	public void evalueScore(Boolean afficher) {
		
		//A faire dans la partie 3...
		
	}
	
	public String toString() {
		return "";
	}
	
	public List<Lien> obtientFraction(Boolean duDebut, int indexCoupe){
		
		List<Lien> listTemp=new ArrayList<Lien>();  
		
		if(duDebut == true) {
			
		}
		else {
			
		}
		
		return listTemp;
	}
	
	//Mutateur a faire
	
}