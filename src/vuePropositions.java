import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class vuePropositions extends Canvas{
	
	Rangee[] propositions;
	
	public vuePropositions(Rangee[] propositions) {
		super();
		Dimension dimension=new Dimension(50*Modele.DIFFICULTE+20, 30*(Modele.N_TENTATIVES+1));
		this.setPreferredSize(dimension);
		this.setBackground(Color.gray);
		this.propositions = propositions;
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		//g.drawImage(null, 0, 0, this.getWidth(), this.getHeight(), null);
		super.paint(g);
		
		g.drawRect(0, 0, 50*Modele.DIFFICULTE-40, this.getHeight()-2);
		g.drawRect(1, 1, 50*Modele.DIFFICULTE-40, this.getHeight()-2);
		g.drawRect(50*Modele.DIFFICULTE-40+1, 0, 58, this.getHeight()-2);
		g.drawRect(50*Modele.DIFFICULTE-40, 1, 58, this.getHeight()-2);
		g.drawRoundRect(8,  8, 37*Modele.DIFFICULTE, 31*Modele.N_TENTATIVES, 10, 10);
		
		for(int i = 1; i<=Modele.N_TENTATIVES; i++) {
			g.drawRoundRect(50*Modele.DIFFICULTE-40+5, i*35-20, 50, 18, 5, 5);
			for(int j = 0; j<Modele.DIFFICULTE; j++) {
				g.fillOval(50*Modele.DIFFICULTE-26+j*10, i*35-12, 2, 2);
			}
		}
		
		for(int i = 0; i<Modele.N_TENTATIVES; i++) {
			for(int j = 0; j<Modele.DIFFICULTE; j++) {
				if(this.propositions[i].rangee[j] != null) {
					g.setColor(this.propositions[i].rangee[j]);
					g.fillOval(10+(j*40), (i*35 - 20), 20, 20);
					g.setColor(Color.darkGray);
					g.drawOval(10+(j*40), (i*35 - 20), 20, 20);
				} else {
					g.setColor(Color.black);
					g.fillOval(20+(j*40), 10+(i*35 - 20), 2, 2);
				}
				
				if(this.propositions[i].indiceJeton == Modele.DIFFICULTE && this.propositions[i].resultat[j] != null ) {
					g.setColor(this.propositions[i].resultat[j]);
					g.fillOval(50*Modele.DIFFICULTE-27+j*10, i*35-13, 5, 5);
				}
			}
		}
	}
}
