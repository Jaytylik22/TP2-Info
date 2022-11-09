package source;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Jerome
 *
 */
public class Carte{
	
	
	//Variables de la classe
	List<Lien> listeLien=new ArrayList<Lien>();
	double score;
	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	Configuration config = new Configuration();
	
	//Débuts des constructeurs
	/*Constructeur par paramètre, minimaliste. Reçoit et copie le paramètre
	 * dans l’attribut correspondant. Le constructeur initialise aussi la
	 *  liste vide.
	 */
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, 
				 Configuration config) {
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		this.config = config;
		
	}
	
	/*Constructeur par paramètres. Retient la référence du
	 * moteurDistanceMoyenne. Cette définition s’attarde aussi à l’attribution
	 * d’un contenu de la liste. Cela se fait en prenant les deux listes 
	 * reçues et en les assemblant en une seule.
	 */
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, List<Lien>
				 section1, List<Lien> section2, Configuration config) {
		
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		this.listeLien = section1;
		this.config = config;
	}
	
	//Constructeur par copie
	public Carte(Carte cartes) {
		this.listeLien = cartes.listeLien;
		this.score = cartes.score;
		this.moteurDistanceMoyenne = cartes.moteurDistanceMoyenne;
	}
	//Fin des constructeurs
	
	
	//Début des accesseurs
	//Retourne le nombre de liens de la carte.
	public int getNbLiens() {
		
		return listeLien.size();
	}
	
	//Retourne le score.
	public double getScore() {
		
		return score;
	}
	
	//: Il s’agit d’additionner les longueurs de la liste de liens et de
	//retourner la somme.
	public double obtenirSommeLongueurs() {
		int sommeLongueur = 0;
		
		for(int i = 0; i < listeLien.size(); i++) {
			sommeLongueur += listeLien.get(i).getDistance();
		}
		
		return sommeLongueur;
	}
	
	/*Il s’agit de calculer le score obtenu par la multiplication de la 
	 * distance obtenue du moteurDistanceMoyenne par la pénalité de distance
	 *  + la somme des longueurs multipliée par la péna--lité de longueur + la
	 *   pénalité déconnecte.
	 */
	public void evalueScore() {
		
		ArrayList<Lien> listeLienCopy = new ArrayList<Lien>(listeLien);
		double distanceObtenue = moteurDistanceMoyenne.getDistanceMoyenne(
				listeLienCopy, false);
		double sommeLongueur = obtenirSommeLongueurs();
		score = distanceObtenue * config.penalite_distance + sommeLongueur * 
				config.penalite_longueur + config.penalite_deconnecte;
	}
	
	/*Créer et retourne une chaîne de caractères enfilant tous les liens de 
	 * la carte, à raison d’un lien par ligne. Après avoir enfilé tous les 
	 * liens, ajouter le score.
	 */
	public String toString() {
		return listeLien.toString() + "-----Score : " + score;
	}
	
	/*Cette méthode retourne la copie d’une fraction de la liste de liens.
	 *  Il y a deux comportements possibles: 
	 */
	public List<Lien> obtientFraction(Boolean duDebut, int indexCoupe){
		
		List<Lien> listTemp=new ArrayList<Lien>();  
		
		if(duDebut == true) {
			for(int i = 0; i <= indexCoupe; i++) {
				listTemp.add(listeLien.get(i));
			}
		}
		else {
			for(int i = listeLien.size(); i >= indexCoupe; i--) {
				listTemp.add(listeLien.get(i));
			}
		}
		
		return listTemp;
	}
	//Fin des acccesseurs
	
	//Début des Mutateurs
	//Enlève le lien l’indice donné.
	public List<Lien> enleverLien(int indice){
		listeLien.remove(indice);
		return listeLien;
	}
	
	//Ajoute le lien à la fin.
	public void ajouterLien(Lien ceLien) {
		listeLien.add(ceLien);
	}
	//Fin des mutateurs
	
}