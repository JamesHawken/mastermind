import java.awt.Canvas;
import java.awt.Dimension;

public class vuePropositions extends Canvas{
	
	public vuePropositions() {
		super();
		Dimension dimension=new Dimension(200, 200);
		this.setPreferredSize(dimension);
		
		for (int i=0;i<Modele.N_TENTATIVES; i++) {
			Rangee r=new Rangee(Modele.DIFFICULTE);
			
		}
	}
}
