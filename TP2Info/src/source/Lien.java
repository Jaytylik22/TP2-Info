package source;


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
	
	
	//Accesseurs
	//estMembre()
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
	
	//getDistance()
	public double getDistance() {
		return villeSource.distanceAvec(villeDestination);
	}
	
	//toString()
	public String toString() {
		return villeSource.toString() + "------" + this.getDistance() + "------" + villeDestination.toString();
	}
	
	//getDest()
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
	
	
	//clone()
	public Object clone() throws CloneNotSupportedException{
		
		return super.clone();
	}
	
	//Mutateurs
	//mute()
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
