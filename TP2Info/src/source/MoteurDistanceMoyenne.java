package source;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe implémente le moteur de calcul de distance moyenne entre 2
 *  villes. 
*  Elle est un singleton dont la référence est partagée par toutes les cartes.
 *
 * L'algorithme utilisé consiste à construire, pour chaque ville, un arbre à
 * descendant vers toutes les autres villes en suivant les liens. Les noeuds 
 * contiennent la distance de la tête.
 *
 * Quand l'arbre est terminé, la distance de la tête de tous les noeuds est 
 * transféré dans une matrice de distance. Dans le cas où 2 villes ne sont pas
 * connecté, la matrice de distance garde sa valeur par défaut qui est égal à 
 * 0.0
 *
 * Prendre note que l'arbre est développé de façon itérative et non pas de 
 * façon récursive.
 *
 * Prendre note que les Noeuds de l'arbre sont définit dans une classe locale.
 *
 * Liste des méthodes publiques:
 * 		- MoteurDistanceMoyenne
 * 		- calculDistanceMoyenne
 * 		- getDistanceMoyenne
 * 		- getNbNonConnecte
 *
 * @author Fred Simard | ETS,
 * @révision Pierre Bélisle | ETS,
 * Copyright A2022
 */

/**
 * Constructeur du moteur de calcul de la moyenne entre les villes à relier.
 * 
 */
public class MoteurDistanceMoyenne {

	// La population reçue par le constructeur.
	private PopulationVilles popVilles;

	// 
	private double distanceMoyenne = 0.0;
	private int nbDeconnecte = 0;

	/**
	 * Constructeur par paramètre qui nécessite la population des villes 
	 *  instanciées.
	 * 
	 * @param popVilles, liste des villes
	 */
	public MoteurDistanceMoyenne(PopulationVilles popVilles){
		this.popVilles = popVilles;
	}

	/**
	 * Obtient la distance moyenne calculée.
	 * 
	 * @param listeLiens, liste des liens de la carte
	 * @param afficher, true pour afficher la matrice des distances.
	 * 
	 * @return distance moyenne
	 */
	public double getDistanceMoyenne(ArrayList<Lien> listeLiens, boolean 
			afficher){
		 
		 /*
		  * Stratégie : Calcule la distance moyenne pour la liste de liens 
		  * reçue et 
		  * la retourne.
		  * 
		  * Un arbre est construit ainsi qu'une matrice de sitance et  le 
		  * calcul est finaliser dans une fonction locale.
		  * 
		  * Attention, un appel à cette méthode efface la distance préalablement 
		  * calculée.
		  * 
		  */
		 
		 // Initialise la matrice de distances.
		 double[][] distances = 
				 	 new double[popVilles.getNbVilles()][popVilles.
				 	                                     getNbVilles()];

		 // À partir de la population de villes
		// pour chaque ville...
		for(int i=0;i<popVilles.getNbVilles();i++){

			ArrayList<Noeud> arbre = construireArbre(listeLiens, i, afficher);

			// Remplit la ligne de la matrice de distances.
			for(int j=0;j<arbre.size();j++){
				
				Noeud ceNoeud = arbre.get(j);
				
				// Pour la lisibilité du code.
				int indice = ceNoeud.getSource().getNumero();
				distances[i][indice] = ceNoeud.getDistanceDeTete();
			}

		}

		// Affiche matrice de distances si demandée.
		if(afficher){
			afficherMatriceDistance(distances);
		}

		// Calcule la distance moyenne et détermine s'il y a des
		// noeuds non-connectés.
		return distanceFinale(distances);
	}

	

	/**
	 * Obtient le nombre de villes non connectés.
	 * @return nombre de non-connecté
	 */
	public int getNbNonConnecte(){
		return nbDeconnecte;
	}

	/**
	 * Construit l'arbre pour la ville i
	 *
	 * @param listeLiens, La liste des liens de la carte.
	 * @param i, Indice de la ville, pour laquelle on développe l'arbre.
	 * @return La liste de noeuds, contenant l'arbre.
	 */
	private ArrayList<Noeud> construireArbre(ArrayList<Lien> listeLiens, 
			                                  int indice,
			                                  boolean afficher){

		// Mettre vos deux liste ici (arbre et liste de sources).
		//Initialiser les 2 listes vides(arbre et liste de sources)
		ArrayList<Noeud> arbre=new ArrayList<Noeud>();
		ArrayList<Ville> listeSources=new ArrayList<Ville>();  
				
		//Créer un Noeud correspondant a la ville dont l'indice est recu en
		//parametre et ajouter ce noeud a l'arbre ainsi qu'a la liste des 
		//sources
		Noeud noeud = new Noeud(popVilles.tblVille[indice]);
				
		//Parcourir les noeuds de l'arbre et les développer
		for(int i = 0; i < arbre.size(); i++) {
			developperNoeud(arbre, listeSources, listeLiens, indice);
		}
				
		//Afficher l'arbre si le parametre booléen == true;
		if( afficher == true) {
			afficherArbre(arbre);
		}

		return arbre;

	}

	/**
	 * Développe un noeud de l'arbre. Les noeud suivant sont développés à partir 
	 * des liens existants entre la ville source et ses destinations. Seule les
	 * villes pas encore dans l'arbre sont développés.
	 *
	 * @param arbre, Référence à la liste de tous les noeuds.
	 * @param listeSource, Référence à la liste des sources déjà développées.
	 * @param listeLiens, Liste de tous les liens.
	 * @param prochainNoeud, Index du noeud à développer.
	 */
	private void developperNoeud(ArrayList<Noeud> arbre,
			                    ArrayList<Ville> listeSource,
			                    ArrayList<Lien> listeLiens,
			                    int noeudADevelopper){

        // Compléter ici
		
		//Obtenir le noeud courant associé a l'indice dans l'arbre
		Noeud noeud = arbre.get(noeudADevelopper);
		
		//Obtenir la ville qui est dans ce noeud
		Ville villeSource = noeud.getSource();
		
		//Tant qu'il y a des liens de la liste de liens qui sont non traités
		for(int i = 0; i < listeLiens.size(); i++) {
		
			//Obtenir le lien de la liste de liens a la position courante
			Lien lienTemp = listeLiens.get(i);
			//Si la ville courante est membre du lien
			if(lienTemp.estMembre(villeSource) == true){
				
				//Si la ville destination ne fait pas partie de la liste
				//des sources
				if(listeSource.contains(lienTemp.getDest(villeSource)) == true){
					
					//Ajouter un noeud correspondant a la destination dans 
					//l'arbre et dans la liste de sources
					Noeud noeudDestination = new Noeud(lienTemp.getDest
							(villeSource));
					arbre.add(noeudDestination);
					listeSource.add(lienTemp.getDest(villeSource));
				}
			}
		}
	}


	/**
	 * Finalise les calculs en calculant la distance moyenne sur la matrice des 
	 * distances et en comptant le nombre de villes non-connectées.
	 * 
	 * @param distances, matrice de distances
	 */
	private double distanceFinale(double distances[][]){

		distanceMoyenne = 0.0;
		nbDeconnecte = 0;

		// Fait la somme des distance de la matrice triangulaire.
		for(int i=1;i<distances.length;i++){
			
			for(int j=0;j<i;j++){

				// Compte les villes non connectées.
				if(distances[i][j]!=0.0){
					
					distanceMoyenne+=distances[i][j];
					
				}else{
					
					nbDeconnecte += 1;
				}
			}
		}

		// Calcule de la moyenne en divisant par le nombre d'éléments (n^2)/2.
		return distanceMoyenne /= 
						(distances.length*distances.length -distances.length)/2;
	}


	/**
	 * Affiche l'arbre (utilisé en debug).
	 * @param arbre, arbre de connections
	 */
	private void afficherArbre(ArrayList<Noeud> arbre){

		for(int i=0;i<arbre.size();i++){
			
			Noeud ceNoeud = arbre.get(i);
			System.out.println("");
			System.out.println("Noeud: " + i);
			System.out.println(ceNoeud.toString());
		}

	}

	/**
	 * Affiche la matrice de distances.
	 * 
	 * @param distances, matrice de distances.
	 */
	private void afficherMatriceDistance(double distances[][]){

		for(int i=0;i<distances.length;i++){
			
			for(int j=0;j<i;j++){
				
				System.out.printf("%5.3f\t",distances[i][j]);
			}
			
			System.out.println("");
		}

	}
}
