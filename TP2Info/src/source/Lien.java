package source;

/**
 * 
 * @author Jerome
 *
 */
public class Lien {

	
	public Ville villeSource;
	public Ville villeDestination;
	
	
	//Constructeurs
	public Lien(){
		
	}
	
	public Lien(Ville villeSource , Ville villeDestination){
		
		this.villeSource = villeSource;
		this.villeDestination = villeDestination;
	}
	
	public Lien(Lien lien){
		
		villeSource = lien.villeSource;
		villeDestination = lien.villeDestination;
	}
	//Fin des constructeurs
	
	
	//Accesseurs
	//Retourne true, si la ville reçue en paramètre est l’une des deux villes
	//connectées; false, sinon.
	public boolean estMembre(Ville ville) {
		if(ville == villeDestination) {
			return true;
		}
		else if(ville == villeSource) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//Retourne la distance entre les deux villes du lien
	public double getDistance() {
		return villeSource.distanceAvec(villeDestination);
	}
	
	//Retourne une chaîne de caractères qui représente les deux villes
	//connectées sur une seule ligne.
	public String toString() {
		return villeSource.toString() + "------" + this.getDistance()
		+ "------" + villeDestination.toString();
	}
	
	//Retourne une référence à la ville qui complémente la ville reçue en
	//paramètre. Dans le cas où la ville reçue n’est pas membre, la méthode
	//retourne null.
	public Ville getDest(Ville ville) {
		if(ville == villeDestination) {
			return villeSource;
		}
		else if(ville == villeSource) {
			return villeDestination;
		}
		else {
			return null;
		}
	}
	
	
	//Retourne une copie du lien
	public Object clone(){
		
		Lien copyLien = new Lien(this.villeSource, this.villeDestination);
		return copyLien;
	}
	//Fin des accesseurs
	
	//Mutateurs
	//sert à modifier le lien en lui assignant une nouvelle ville selon
	//la position 
	public boolean mute(Ville nouvelleVille, int position) {
		if(estMembre(nouvelleVille) == false) {
			if(position == 0) {
				this.villeSource = nouvelleVille;
				return true;
			}
			else {
				this.villeDestination = nouvelleVille;
				return true;
			}
		}
		else {
			return false;
		}
	}
	
}
