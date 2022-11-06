package source;

import java.util.ArrayList;
import java.util.List;

public class Carte{
	
	List<Lien> list=new ArrayList<Lien>();  
	int score;
	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne) {
		
	}
	
	public Carte(Object moteurDistanceMoyenne, List<Lien> section1, List<Lien> section2) {
		
	}
	
	public int getNbLiens() {
		
		return list.size();
	}
	
	public int getScore() {
		
		return score;
	}
	
	public void evalueScore(Boolean afficher) {
		
		//A faire dans la partie 3...
		
	}
	
	public String toString() {
		
	}
	
	public List<Lien> obtientFraction(Boolean duDebut, int indexCoupe){
		
		List<Lien> listTemp=new ArrayList<Lien>();  
		
		if(duDebut == true) {
			
		}
		else {
			
		}
		
		return listTemp;
	}
	
	
}