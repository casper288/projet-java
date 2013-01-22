package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window() {
		this.setTitle("Projet Java");
		this.setSize(540, 540);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent(); // initialisation du contenu de la fenêtre
	}

	private void initComponent() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		this.setContentPane(container);
	}

}
