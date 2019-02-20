import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class vueClavier extends Panel implements Observer{

	Modele modele;
	Mastermind master;
	
	public vueClavier (Modele modele, ActionListener l, Mastermind master) {
		
		this.modele = modele;
		this.master = master;
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
	
	public void finJeu(String en) {
		this.removeAll();
		Button b= new Button("" + this.modele.etat);
		b.setBackground(Color.LIGHT_GRAY);
		this.add(b);
		
		int tmp[] = {this.master.getWidth(), this.master.getHeight(), this.master.getX(), this.master.getY()};
		this.master.setBounds(tmp[2], tmp[3], tmp[0]+1, tmp[1]);
		this.master.setBounds(tmp[2], tmp[3], tmp[0], tmp[1]);
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
