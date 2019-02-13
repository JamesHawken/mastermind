import java.awt.Color;
import java.util.Observable;
import java.util.Random;

public class Modele extends Observable {
	
	static Color[] COULEURS = {Color.yellow, Color.green, Color.blue, Color.magenta, Color.red, Color.orange, Color.white, Color.black};
	/*Graphic are based on non-depending, hard-coded variables. Changing the 2 following int
	 * may drastically worsen global appearance to user.
	 */
	static int N_TENTATIVES = 10;
	static int DIFFICULTE = 4;
	
	enum Etat {EN_COURS, GAGNE, PERDU};
	
	public Etat etat;
	public Rangee combinaison;
	public Rangee propositions[];
	public int tentative;
	
	public Modele() {
		this.etat = Etat.EN_COURS;
		this.tentative = 1;
		this.combinaison = new Rangee(Modele.DIFFICULTE);
		this.propositions = new Rangee[Modele.N_TENTATIVES];

		Random rand = new Random();

		for(int k = 0; k<Modele.DIFFICULTE; k++){
			this.combinaison.rangee[k] = COULEURS[rand.nextInt(COULEURS.length)];
		}
		
		for(int k = 0; k<Modele.N_TENTATIVES; k++) {
			this.propositions[k] = new Rangee(Modele.DIFFICULTE);
		}
	}
	
	/*public Modele(int diff, int tentatives){
		this.DIFFICULTE = diff;
		this.N_TENTATIVES = tentatives;
		this.etat = Etat.EN_COURS;
		this.tentative = 1;
		this.combinaison = new Rangee(diff);
		
		Random rand = new Random();
		
		for(int k = 0; k<diff; k++){
			combinaison.rangee[k] = COULEURS[rand.nextInt(COULEURS.length)];
		}
	}*/
	
	public void archiver(Rangee r){
		this.propositions[this.tentative] = r;
		this.tentative++;
		this.setChanged();
		this.notifyObservers(this.propositions);
	}
	
	public void etatCourant(){
		
		if(this.tentative < Modele.N_TENTATIVES) this.etat = Etat.EN_COURS;
		if(this.tentative > Modele.N_TENTATIVES) this.etat = Etat.PERDU;
		this.setChanged();
		this.notifyObservers(this.etat);
	}

}
