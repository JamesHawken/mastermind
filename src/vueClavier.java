import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;

public class vueClavier extends Panel {

	public vueClavier (Modele modele, ActionListener l) {
		
		this.setBackground(Color.darkGray);
		
		if(modele.etat != Modele.Etat.EN_COURS) {
			this.removeAll();
			Label label = new Label("" + modele.etat);
			this.add(label);
		}
		
		for (int i=0; i<Modele.COULEURS.length;i++) {
			Button b= new Button();
			b.setPreferredSize(new Dimension(20, 20));
			b.setBackground(Modele.COULEURS[i]);
			b.addActionListener(l);
			b.setName(Integer.toString(i));
			this.add(b);
		}
		
		
	}
}
