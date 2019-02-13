import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class Mastermind extends Frame implements WindowListener {
	
	public Mastermind() {
		
		Modele modele = new Modele();
		vuePropositions vp = new vuePropositions(modele.propositions);
		Controleur ctrl = new Controleur(modele, vp);
		vueClavier vc= new vueClavier(modele, ctrl);
		
		
		this.setLayout(new BorderLayout());
		this.add(vc, BorderLayout.SOUTH);
		this.add(vp, BorderLayout.NORTH);

		this.addWindowListener(this);
		this.setTitle("Mastermind");
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
			new Mastermind();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
