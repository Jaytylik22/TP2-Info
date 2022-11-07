package source;

/**
 * 
 * @author Jerome
 *
 */
public class Configuration {
	
	//Attributs de la classe Configuration
	public double pourcentage_mutation;
	public double pourcentage_retrait;
	
	public double max_x;
	public double max_y;
	
	public double penalite_longueur;
	public double penalite_distance;
	public int penalite_deconnecte;
	
	public int nb_villes;
	public int nb_iterations;

	public int nb_cartes_base;
	public int nb_cartes_max;
	
	
	//Initialise tous les attributs à leur valeur constante associée du module
	//Constantes
	public Configuration() {
		
		pourcentage_mutation = Constantes.POURCENTAGE_MUTATION;
		pourcentage_retrait = Constantes.POURCENTAGE_RETRAIT;
		
		max_x = Constantes.MAX_X;
		max_y = Constantes.MAX_Y;
		
		penalite_longueur = Constantes.PENALITE_LONGUEUR;
		penalite_distance = Constantes.PENALITE_DISTANCE;
		penalite_deconnecte = Constantes.PENALITE_DECONNECTE;
		
		nb_villes = Constantes.NB_VILLES;
		nb_iterations = Constantes.NB_ITERATIONS;

		nb_cartes_base = Constantes.NB_CARTES_BASE;
		nb_cartes_max = Constantes.NB_CARTES_MAX;
	}
	
	//Accesseur Get et Set pour tout les attributs
	public double getPourcentage_mutation() {
		return pourcentage_mutation;
	}
	
	public void setPourcentage_mutation(double set) {
		pourcentage_mutation = set;
	}
	
	public double getPourcentage_retrait() {
		return pourcentage_retrait;
	}
	
	public void setPourcentage_retrait(double set) {
		pourcentage_retrait = set;
	}
	
	public double getMax_x() {
		return max_x;
	}
	
	public void setMax_x(double set) {
		max_x = set;
	}
	
	public double getMax_y() {
		return max_y;
	}
	
	public void setMax_y(double set) {
		max_y = set;
	}
	
	public double getPenalite_longueur() {
		return penalite_longueur;
	}
	
	public void setPenalite_longueur(double set) {
		penalite_longueur = set;
	}
	
	public double getPenalite_distance() {
		return penalite_distance;
	}
	
	public void setPenalite_distance(double set) {
		penalite_distance = set;
	}
	
	public int getPenalite_deconnecte() {
		return penalite_deconnecte;
	}
	
	public void setPenalite_deconnecte(int set) {
		penalite_deconnecte = set;
	}
	
	public int getNb_villes() {
		return nb_villes;
	}
	
	public void setNb_villes(int set) {
		nb_villes = set;
	}
	
	public int getNb_iterations() {
		return nb_iterations;
	}
	
	public void setNb_iterations(int set) {
		nb_iterations = set;
	}
	
	public int getNb_cartes_base() {
		return nb_cartes_base;
	}
	
	public void setNb_cartes_bases(int set) {
		nb_cartes_base = set;
	}
	
	public int getNb_cartes_max() {
		return nb_cartes_max;
	}
	
	public void setNb_cartes_max(int set) {
		nb_cartes_max = set;
	}
	//fin des accesseurs
	
	
}
