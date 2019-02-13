import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class Modele {
	
	static Color[] COULEURS = {Color.yellow, Color.green, Color.blue, Color.magenta, Color.red, Color.orange, Color.white, Color.black};
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
	
	public void archiver(Rangee r){
		this.propositions[this.tentative] = r;
	}
	
	public Etat etatCourant(){
		if(this.tentative < this.N_TENTATIVES) this.etat = Etat.EN_COURS;
		if(this.tentative > this.N_TENTATIVES) this.etat = Etat.PERDU;
		return this.etat;
	}
}
