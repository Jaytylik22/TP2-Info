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
	List<Lien> listeLien2=new ArrayList<Lien>(); 
	double score;
	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	Configuration config = new Configuration();
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, Configuration config) {
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		this.config = config;
		
	}
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, List<Lien> section1, List<Lien> section2, Configuration config) {
		
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		this.listeLien = section1;
		this.listeLien2 = section2;
		this.config = config;
	}
	
	public Carte(Carte cartes) {
		this.listeLien = cartes.listeLien;
		this.score = cartes.score;
		this.moteurDistanceMoyenne = cartes.moteurDistanceMoyenne;
	}
	
	public int getNbLiens() {
		
		return listeLien.size();
	}
	
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
	
	public void evalueScore(Boolean afficher) {
		
		ArrayList<Lien> listeLienCopy = new ArrayList<Lien>(listeLien);
		double distanceObtenue = moteurDistanceMoyenne.getDistanceMoyenne(listeLienCopy, false);
		double sommeLongueur = obtenirSommeLongueurs();
		score = distanceObtenue * config.penalite_distance + sommeLongueur * config.penalite_longueur + config.penalite_deconnecte;
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
	
	//Mutateur
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