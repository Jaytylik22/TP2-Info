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
	
	//constructeur par copie d’attributs.
	public Noeud(Ville villeSource/*, List<Ville> listeVilleConnecter*/) {
		this.villeSource = villeSource;
		//this.listeVilleConnecter = listeVilleConnecter;
	}
	
	//obtient la ville du nœud.
	public Ville getSource() {
		return listeVilleConnecter.get(0);
	}
	
	//obtient la distance depuis la tête.
	public int getDistanceDeTete() {
		return distanceDeTete;
	}
	
	//obtient le niveau de l'arbre ou se trouve le nœud.
	public int getNiveau() {
		return distanceDeTete;
	}
	
	//obtient une représentation en chaine de caractères du nœud.
	public String toString() {
		return villeSource.toString() + "------" + distanceDeTete;
		
		
	}
	
	
	
	
	
}