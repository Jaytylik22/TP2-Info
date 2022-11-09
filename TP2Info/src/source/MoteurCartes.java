package source;

import java.util.List;

/**
 * Cette classe Implemente le moteur de gestions de la population de cartes 
 * candidates

 * 
 * Liste des méthodes publiques: 
 *     - MoteurCartes, constructeur par paramètre
 *     - reduitLaPopulation, opération qui réduit la population à NB_CARTES_
 *     BASES
 *     - elargieLaPopulation, opération qui elargie la population à NB_CARTES_
 *     MAX
 *     - evalueLesScores, calcul les scores des cartes
 *     - afficheMeilleurSolution, affiche la meilleur solution
 *     - afficheMeilleurScore, affiche le meilleur score
 *     - toString, représentation de l'objet en chaine de caractères
 *     
 * Cette classe utilise votre liste chaînée, il se peut que vous devient ajuster 
 * la signature des méthodes selon votre classe.
 *
 * @author Fred Simard | ETS, 
 * @version Automne 2022
 */

import java.util.Random;
import java.util.Vector;

public class MoteurCartes {

	private PopulationVilles popVilles;
	private Vector<Carte> cartes; // à remplacer par collection Java
	private MoteurDistanceMoyenne moteurDistanceMoyenne;
	
	
	Configuration config;
	
	/**
	 * Constructeur par paramètre
	 * 
	 * @param popVilles, la population de villes
	 */
	public MoteurCartes(PopulationVilles popVilles, Configuration config){
		
		this.popVilles = popVilles;
		this.config = config;
		
		moteurDistanceMoyenne = new MoteurDistanceMoyenne(popVilles);
		cartes = new Vector<Carte>(config.getNb_cartes_base());
	}
	

	/**
	 * reduit la population de carte en ne gardant que les CONFIGURATION.NB_
	 * CARTES_BASES
	 * ayant le plus bas score (minimization). Cette méthode opère sur les 
	 * champs de la classe
	 */
	public void reduitLaPopulation(){
	
		
		//un nouveau vecteur vide qui ne contiendra que les meilleures cartes
		Vector<Carte> bestCartes = null;
		
		//Ajouter-y la première carte de la liste actuelle
		bestCartes.add(cartes.firstElement());
		
		//Boucler tant qu'il reste des cartes à traiter dans le vecteur de 
		//cartes.
		for(int i = 1; i < cartes.capacity(); i++) {
			
			//Obtenir la prochaine carte.
			Carte carteTemp = new Carte(cartes.elementAt(i));
			
			//Vérifier si elle est à placer au début selon le score 
			if(bestCartes.elementAt(0).score < cartes.elementAt(i).score){
				bestCartes.add(0, carteTemp);
			}
			//Sinon vérifier si elle est à placer à la fin.
			else if(bestCartes.elementAt(0).score > cartes.elementAt(i).score){
				bestCartes.add(carteTemp);
			}
			//Sinon trouver la position d’insertion et l’ajouter.
			else {
				for(int j = 0; j < cartes.capacity(); j++) {
					if(bestCartes.elementAt(j).score < cartes.elementAt(i).
							score){
						bestCartes.add(j, carteTemp);
					}
				}
			}
			
			//Vérifier si on a trop de cartes, si c'est le cas, enlever la 
            //dernière de la liste.
			if(bestCartes.capacity() > 60){
				bestCartes.remove(0);
			}
		}
		
		//remplacer le vecteur de cartes par le nouveau qui a 
        //été réduit.
		cartes = bestCartes;
	}

	/**
	 * elargie la population de carte en générant de nouvelles cartes qui sont
	 *  des mix de cartes
	 * existantes. Cette méthode opère sur les champs de la classe.
	 */
	public void elargieLaPopulation(){

		// elargie la population en générant de nouveaux individus, qui 
		//combinent les gênes des parents.
		
		// calcul la somme des scores de tous les parents
		double sommeScore = 0.0;
		
		for(int i=0;i<cartes.size();i++){
			sommeScore += cartes.get(i).getScore();
		}
		
		int nbCartesMax = config.getNb_cartes_max();
		int nbCartesBase = config.getNb_cartes_base();
		
		// pour tous les individues à générer
		for(int i=0;i<(nbCartesMax-nbCartesBase);i++){
			
			// selectionne 2 coupes de parents aléatoirement
			List<Lien> section1 = obtientUneCoupe(sommeScore);
			List<Lien> section2 = obtientUneCoupe(sommeScore);
			
			// assemble et ajoute le nouvel individu
			cartes.add(new Carte(moteurDistanceMoyenne, section1, section2, 
					config));
		}
	
	}

	/**
	 * Obtient une section de carte selectionné au hasard parmis la liste de 
	 * cartes
	 * en proportion de leur score.
	 * 
	 * NOTE: la technique employé est de donner plus de poids aux cartes de 
	 * bases ayant les plus mauvais
	 * 		 score. Cette approche augmente le mélange des éléments et aide à 
	 * sortir des minimum locaux
	 * 
	 * NOTE: la technique tend également à favoriser les solutions courtes en 
	 * applicant un retrait de liens
	 * 
	 * @param sommeScore somme des scores de la population de cartes
	 * @return une section de carte (ListeDChainee)
	 */
	private List<Lien> obtientUneCoupe(double sommeScore){
		Random rand = new Random();

		int i=0;
		double nbAlea = rand.nextDouble()*sommeScore;
		double accumulationScore = 0;
		Carte courante = null;
		
		int nbCartesBase = config.getNb_cartes_base();
		
		// selectionne l'individu en proportion du score
		while(i<nbCartesBase && accumulationScore<=nbAlea){
			
			courante = cartes.get(i);
			accumulationScore += courante.getScore();
			
			i++;
		}
		System.out.println(courante.getNbLiens());
		
		// obtient une fraction de l'individu
		List<Lien> section = courante.obtientFraction(rand.nextBoolean(), 
				                           rand.nextInt(courante.getNbLiens()));

		// applique une mutation si nécessaire
		if(rand.nextDouble() < config.getPourcentage_mutation()){
			int indexLien = rand.nextInt(section.size());
			
			((Lien)section.get(indexLien)).mute(popVilles
					           .getVille(rand.nextInt(popVilles.getNbVilles())), 
					           rand.nextInt(2));
		}

		// retire un lien pour favoriser solution courtes
		if(rand.nextDouble() < config.getPourcentage_retrait()){
			int indexLien = rand.nextInt(section.size());
			section.remove(indexLien);
		}
		
		return section;
		
	}
	
	/**
	 * Calcul les scores des cartes
	 */
	public void evalueLesScores(){

		for(int i = 0; i < cartes.size(); i++) {
			cartes.get(i).evalueScore();
		}
	}
	
	/**
	 * Affiche la meilleur solution
	 */
	public Carte getMeilleurSolution(){
		return cartes.get(0);
	}

	/**
	 * Affiche le meilleur score
	 */
	public void afficheMeilleurScore(){
		System.out.println("Meilleur score: " + cartes.get(0).getScore());
		
	}
	
	/**
	 * Retourne une représentation chaine de caractère de l'objet
	 * 
	 *  @return Chaine de caractère représentant l'objet
	 */
	public String toString(){
    	
		String str = new String();
    	str += "Liste des Cartes\n";
    	
    	// affiche toutes les cartes
    	for(int i=0;i<cartes.size();i++){
    		str += "Carte: " + i + "------------------------------------";
    		str += cartes.get(i).toString();
    		str += "\n";
    	}
    	return str;
	}


	public void setPopulation(PopulationVilles popVilles) {
		
		//Variable que le prof a oublier qui est nécéssaire
		Random rand = new Random();
	
		// Évite pls appels à l'accesseur.
		int nbCartesBase = config.getNb_cartes_base();

		// population de cartes
		cartes =
				new Vector<Carte>(nbCartesBase);

		// instancie un moteur de distance moyenne
		moteurDistanceMoyenne = new MoteurDistanceMoyenne(popVilles);
		this.popVilles = popVilles;

		// crée la population de cartes initiales
		for(int i=0; i < nbCartesBase; i++){

			// crée une nouvelle carte
			Carte temp = new Carte(moteurDistanceMoyenne, config);

			// selectionne 2 villes différentes au hasard
			for(int j=0;j<popVilles.getNbVilles()/2;j++){
				Ville villeA = popVilles.getVille(rand.nextInt(popVilles.
						getNbVilles()));
				Ville villeB = popVilles.getVille(rand.nextInt(popVilles.
						getNbVilles()));

				while(villeA == villeB){
					villeB = popVilles.getVille(rand.nextInt(popVilles.
							getNbVilles()));
				}

				temp.ajouterLien(new Lien(villeA,villeB));
			}

			// ajoute la carte à la liste
			cartes.addElement(temp);
		}

	}
	
}
