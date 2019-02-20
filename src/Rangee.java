import java.awt.Color;

public class Rangee {
	
	Color rangee[];
	int taille, indiceJeton;
	Color[] resultat;
	
	public Rangee(int diff) {
		
		this.taille = diff;
		this.indiceJeton = 0;
		this.rangee = new Color[diff];
		this.resultat = new Color[diff];
	}
	
	public void equals(Rangee r) {
		
		//First loop to determine which color tokens are correctly placed.
		for(int i = 0; i<this.taille; i++){
			if(this.rangee[i] == r.rangee[i]) this.resultat[i] = Color.black;
		}
		
 		//Second loop to seek out misplaced tokens.
		int[] alreadyFound = new int[4];
		for(int i = 0; i<this.taille; i++) {
			if(this.resultat[i] == Color.black) continue;
			for(int j = 0; j<r.taille; j++){
				if(this.rangee[i] == r.rangee[j] && this.resultat[j]==null && alreadyFound[j]==0) {
					this.resultat[i] = Color.white;
					alreadyFound[j] = 1;
					break;
				}
			}
		}
		
		/*Sorting out the resulting array for display convenience. Using the all mighty
		 * Dutch flag algorithm. 
		 */
		int n = 0, b = 0, nl = this.taille-1;
		Color t;
		while(nl >= b) {
			if(this.resultat[b] == Color.white) b++;
			else if(this.resultat[b] == Color.black) {
				t = this.resultat[n]; 
				this.resultat[n] = this.resultat[b]; 
				this.resultat[b] = t;
				n++; b++;
			} else {
				t = this.resultat[b]; 
				this.resultat[b] = this.resultat[nl]; 
				this.resultat[nl] = t;
				nl--;
			}
		}
	}
	
	public boolean estCorrecte() {
		
		int k = 0;
		while(this.resultat[k] == Color.black && k<3) {
			k++;
		}
		return k == this.taille-1;
	}

	public void ajouterJeton(Color c) {
		
		this.rangee[indiceJeton] = c;
		indiceJeton++;
	}
}
