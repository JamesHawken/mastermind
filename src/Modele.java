import java.awt.Color;
import java.util.Random;

public class Modele {
	
	Color[] COULEURS = {Color.yellow, Color.green, Color.blue, Color.magenta, Color.red, Color.orange, Color.white, Color.black};
	int N_TENTATIVES, DIFFICULTE;
	enum Etat {EN_COURS, GAGNE, PERDU};
	
	Etat etat;
	Rangee combinaison;
	Rangee propositions[];
	int tentative;
	
	//public Modele() {}
	
	public Modele(int diff, int tentatives){
		this.DIFFICULTE = diff;
		this.N_TENTATIVES = tentatives;
		this.etat = Etat.EN_COURS;
		this.tentative = 1;
		this.combinaison = new Rangee(diff);
		
		Random rand = new Random();
		
		for(int k = 0; k<diff; k++){
			combinaison.rangee[k] = COULEURS[rand.nextInt(COULEURS.length)];
		}
	}
	public static void main(String[] args) {
		Modele mod = new Modele(5, 10);
		System.out.println(mod.combinaison.rangee[0]);
	}
}
