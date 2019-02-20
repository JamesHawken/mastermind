import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

public class Controleur implements ContainerListener, ActionListener, ItemListener, Observer{

	Modele modele;
	vuePropositions vp;
	
	public Controleur(Modele m, vuePropositions vp, Mastermind master) {
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
				if(this.modele.propositions[modele.tentative].estCorrecte()) this.modele.etat = Modele.Etat.GAGNE;
				this.modele.etatCourant();
			} else {
				this.modele.propositions[modele.tentative].ajouterJeton(Modele.COULEURS[Integer.parseInt((((Component) e.getSource()).getName()))]);;
				//System.out.println((((Component) e.getSource()).getName()));
				if(this.modele.propositions[modele.tentative].indiceJeton==Modele.DIFFICULTE) {
					this.modele.propositions[modele.tentative].equals(this.modele.combinaison);
					if(this.modele.propositions[modele.tentative].estCorrecte()) this.modele.etat = Modele.Etat.GAGNE;
					this.modele.tentative++;
					this.modele.etatCourant();
				}
			}
			vp.repaint();
		} 
	}

	@Override
	public void update(Observable arg0, Object arg1) {
				this.vc.finJeu(this.modele.etat);
	}

	@Override
	public void componentAdded(ContainerEvent arg0) {
		arg0.getSource();
		
	}

	@Override
	public void componentRemoved(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
