package source;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jerome
 *
 */
public class Noeud{
	
	Ville villeSource;
	List<Ville> listeVilleConnecter=new ArrayList<Ville>();  
	int distanceDeTete;
	
	public Noeud(Ville villeSource/*, List<Ville> listeVilleConnecter*/) {
		this.villeSource = villeSource;
		//this.listeVilleConnecter = listeVilleConnecter;
	}
	
	public Ville getSource() {
		return listeVilleConnecter.get(0);
	}
	
	public int getDistanceDeTete() {
		return distanceDeTete;
	}
	
	public int getNiveau() {
		return 0;
	}
	
	public String toString() {
		return "";
	}
	
	
	
	
	
}