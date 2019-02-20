import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class vueClavier extends Panel implements Observer{

	Modele modele;
	
	public vueClavier (Modele modele, ActionListener l) {
		
		this.modele = modele;
		this.setBackground(Color.darkGray);
		
		for (int i=0; i<Modele.COULEURS.length;i++) {
			Button b= new Button();
			b.setPreferredSize(new Dimension(20, 20));
			b.setBackground(Modele.COULEURS[i]);
			b.addActionListener(l);
			b.setName(Integer.toString(i));
			this.add(b);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.modele.etat == Modele.Etat.GAGNE || this.modele.etat == Modele.Etat.PERDU) {
			this.removeAll();
			Button b= new Button("" + this.modele.etat);
			b.setBackground(Color.LIGHT_GRAY);
			this.add(b);
		}		
	}
}
