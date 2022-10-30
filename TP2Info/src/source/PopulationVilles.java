package source;
import java.util.Random;


public class PopulationVilles {

	
	public static Ville[] tblVille = new Ville[Constantes.NB_VILLES];
	Random rand = new Random();
	
	//Constructeurs
	public PopulationVilles(Configuration config){
		for(int i = 0; i < config.getNb_villes(); i++) {
			tblVille[i].numero = i;
			tblVille[i].posX = rand.nextDouble(config.getMax_x());
			tblVille[i].posY = rand.nextDouble(config.getMax_y());
		}
		
	}
	
	
	//Accesseurs
	public Ville getVille(int numero) {
		return tblVille[numero];
	}
	
	public int getNbVilles() {
		return tblVille.length;
	}
	
	public String toString() {
		return tblVille.toString();
	}
	
}