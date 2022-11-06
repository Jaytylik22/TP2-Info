package source;

import java.util.ArrayList;
import java.util.List;

public class Noeud{
	
	Ville villeSource;
	List<Ville> listeVille=new ArrayList<Ville>();  
	int distanceDeTete;
	
	
	public Noeud() {
		
	}
	
	public Ville getSource() {
		return listeVille.get(0);
	}
	
	public int getDistanceDeTete() {
		return distanceDeTete;
	}
	
	public int getNiveau() {
		
	}
	
	public String toString() {
		
	}
	
	
	
	
	
}