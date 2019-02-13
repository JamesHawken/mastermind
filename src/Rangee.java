import java.awt.Color;

public class Rangee {
	
	Color rangee[];
	int taille, indiceJeton;
	Color[] resultat;
	
	public Rangee(int diff){
		
		this.taille = diff;
		this.indiceJeton = 0;
		this.rangee = new Color[diff];
		this.resultat = new Color[diff];
	}
	
	public void equals(Rangee r){
		
		//Premier passage pour determiner les pions bien places
		for(int i = 0; i<this.taille; i++){
			if(this.rangee[i] == r.rangee[i]) this.resultat[i] = Color.black;
		}
		
 		//Deuxième passage pour determiner les pions presents mais mal places
		for(int i = 0; i<this.taille; i++){
			if(this.resultat[i] == Color.black) continue;
			for(int j = 0; j<r.taille; j++){
				if(this.rangee[i] == r.rangee[j] && !this.resultat[j].equals(null)){
					this.resultat[i] = Color.white;
				}
			}
		} 
	}
	
	public boolean estCorrecte(){
		
		int k = 0;
		while(this.resultat[k] == Color.black){
			k++;
		}
		if(k == this.taille) return true;
		return false;
	}
}
