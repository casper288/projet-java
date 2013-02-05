package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.Map.Map;

public class MapPan extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 4624592622103159699L;
    private final Window window;
    private final int height = 20;
    private final int width = 20;

    private final JButton buttonTab[][] = new JButton[this.height + 1][this.width + 1];
    private final JPanel container = new JPanel(new GridLayout(this.height + 1,
	    this.width + 1));

    public MapPan(final Window window) {
	this.window = window;
    }

    public JPanel initMapPan() {
	final Map map = new Map(this.window);
	map.initMap(this.height + 1, this.width + 1);

	this.container.setPreferredSize(new Dimension(700, 680));
	this.container.setBackground(new Color(208, 239, 114));
	this.window.colorPan(208, 239, 114);
	// container.setLayout(new GridLayout(10, 10));
	// container.setBorder(this.getBorder());
	// container.setPreferredSize(new Dimension(680, 690));
	// container.setBackground(Color.white);
	//
	// Border blackline = BorderFactory.createLineBorder(Color.white, 1);
	// for (int i = 0; i < 4900; i++) {
	// JPanel ptest = new JPanel();
	// ptest.setBorder(blackline);
	// container.add(ptest);
	// }
	// container.setBorder(blackline);

	// Ajout des boutons
	for (int i = 1; i < (this.height + 1); i++) {
	    for (int j = 1; j < (this.width + 1); j++) {
		this.buttonTab[i][j] = new JButton(/*
						    * new ImageIcon("toto.gif" )
						    */);
		final int y = i;// variable pour la méthode updateMap de la
				// classe Map
		final int x = j;// variable pour la méthode updateMap de la
				// classe Map

		this.buttonTab[i][j].setBackground(Color.white);

		Border thickBorder = new LineBorder(Color.gray, 1);
		this.buttonTab[i][j].setBorder(thickBorder);

		this.buttonTab[i][j].addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(final ActionEvent e) {
			if (MapPan.this.window.getElementSelect() == "youngPlant") {
			    ((JButton) e.getSource()).setBackground(new Color(
				    199, 236, 85));

			    // System.out.println("YoungPlant!");
			    map.updateMap(y, x, 1);
			    // méthode pour update le tableau int avec un type 1

			} else if (MapPan.this.window.getElementSelect() == "plant") {
			    ((JButton) e.getSource()).setBackground(new Color(
				    33, 173, 75));

			    // System.out.println("plant!");
			    map.updateMap(y, x, 2);
			    // méthode pour update le tableau int avec un type 2

			} else if (MapPan.this.window.getElementSelect() == "tree") {
			    ((JButton) e.getSource()).setBackground(new Color(
				    24, 126, 55));

			    // System.out.println("tree!");
			    map.updateMap(y, x, 3);
			    // méthode pour update le tableau int avec un type 3

			} else if (MapPan.this.window.getElementSelect() == "fire") {
			    ((JButton) e.getSource()).setBackground(Color.RED);

			    // System.out.println("fire!");
			    map.updateMap(y, x, 4);
			    // méthode pour update le tableau int avec un type 4

			} else if (MapPan.this.window.getElementSelect() == "insect") {
			    ((JButton) e.getSource())
				    .setBackground(Color.ORANGE);

			    // System.out.println("insect!");
			    map.updateMap(y, x, 5);
			    // méthode pour update le tableau int avec un type 5

			} else if (MapPan.this.window.getElementSelect() == "cinder") {
			    ((JButton) e.getSource()).setBackground(Color.GRAY);

			    // System.out.println("cinder!");
			    map.updateMap(y, x, 6);
			    // méthode pour update le tableau int avec un type 6

			} else {
			    ((JButton) e.getSource())
				    .setBackground(Color.WHITE);

			    // System.out.println("WHITE!");
			    map.updateMap(y, x, 0);
			    // méthode pour update le tableau int avec un type 0
			}
			// System.out.println("click!");
			map.statsMap();
		    }
		});
		this.container.add(this.buttonTab[i][j]);
	    }
	    // fin for j
	}
	// fin for i

	return this.container;
    }

    public void updateMapPan() {
	this.buttonTab[10][10].setBackground(Color.black);
	// test du bouton "lancer" , cela permet de modifier un element du
	// tableau graphique

	// map.updateMap(10, 10, 0);
	// pour modifier la tableau INT mais il manque
	// l'instanciation sur cet exemple
    }

    public void statsMapPan() {

    }
}
