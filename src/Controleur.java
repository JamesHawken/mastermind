import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controleur implements ActionListener, ItemListener {

	Modele modele;
	vuePropositions vp;
	
	public Controleur(Modele m, vuePropositions vp) {
		this.modele = m;
		this.vp = vp;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof java.awt.Button) {
			if(this.modele.tentative == Modele.N_TENTATIVES) {
				modele.etatCourant();
			} else {
				this.modele.propositions[modele.tentative].ajouterJeton(Modele.COULEURS[Integer.parseInt((((Component) e.getSource()).getName()))]);;
				//System.out.println((((Component) e.getSource()).getName()));
				if(this.modele.propositions[modele.tentative].indiceJeton==Modele.DIFFICULTE) {
					this.modele.propositions[modele.tentative].equals(this.modele.combinaison);
					this.modele.tentative++;
				}
			}
			vp.repaint();
		} 
	}

}
