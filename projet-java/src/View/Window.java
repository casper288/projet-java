package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.SystemColor;

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

		JPanel panNorth = new JPanel();
		panNorth.setBackground(SystemColor.info);
		panNorth.setPreferredSize(new Dimension(340, 470));

		JPanel panCenter = new JPanel();
		panCenter.setBackground(SystemColor.info);

		container.add(panNorth, BorderLayout.NORTH);
		container.add(panCenter, BorderLayout.CENTER);
		this.setContentPane(container);
	}

}
