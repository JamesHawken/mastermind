import java.awt.Button;
import java.awt.Dimension;
import java.awt.Panel;

public class vueClavier extends Panel {

	public vueClavier () {
		for (int i=0; i<Modele.COULEURS.length;i++) {

			Button b= new Button();
			b.setPreferredSize(new Dimension(20, 20));
			b.setBackground(Modele.COULEURS[i]);
		}



	}
}
