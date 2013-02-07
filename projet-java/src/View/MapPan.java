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

	private static final long serialVersionUID = 4624592622103159699L;
	private final Window window;
	private final int height = 50 + 1;
	private final int width = 50 + 1;
	private Map map = null;
	private final JButton buttonTab[][] = new JButton[this.height + 1][this.width + 1];
	private final JPanel container = new JPanel(new GridLayout(this.height,
			this.width));

	public MapPan(final Window window) {
		this.window = window;
	}

	public JPanel initMapPan() {
		this.map = new Map(this.window);
		this.map.initMap(this.height + 1, this.width + 1);

		this.container.setPreferredSize(new Dimension(700, 680));
		this.container.setBackground(new Color(208, 239, 114));
		this.window.colorPan(208, 239, 114);

		// Ajout des boutons
		for (int i = 1; i < (this.height); i++) {
			for (int j = 1; j < (this.width); j++) {
				this.buttonTab[i][j] = new JButton(/* new ImageIcon("toto.gif") */);
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

							MapPan.this.map.updateMap(y, x, 1);
							// méthode pour update le tableau int avec un type 1

						} else if (MapPan.this.window.getElementSelect() == "plant") {

							MapPan.this.map.updateMap(y, x, 2);
							// méthode pour update le tableau int avec un type 2

						} else if (MapPan.this.window.getElementSelect() == "tree") {

							MapPan.this.map.updateMap(y, x, 3);
							// méthode pour update le tableau int avec un type 3

						} else if (MapPan.this.window.getElementSelect() == "fire") {

							MapPan.this.map.updateMap(y, x, 4);
							// méthode pour update le tableau int avec un type 4

						} else if (MapPan.this.window.getElementSelect() == "insect") {

							MapPan.this.map.updateMap(y, x, 5);
							// méthode pour update le tableau int avec un type 5

						} else if (MapPan.this.window.getElementSelect() == "cinder") {

							MapPan.this.map.updateMap(y, x, 6);
							// méthode pour update le tableau int avec un type 6

						} else {

							MapPan.this.map.updateMap(y, x, 0);
							// méthode pour update le tableau int avec un type 0
						}
						// appel de la fonction de mise a jour du panel a chaque
						// clic
						MapPan.this.map.statsMap();
					}
				});
				this.container.add(this.buttonTab[i][j]);
			}
			// fin for j
		}
		// fin for i

		return this.container;
	}

	public void updateMapPan(final int tabUpdate[][]) {
		// méthode pour récupérer le tableau en int
		// et la lit et assigne une couleur sur le tableau
		// de bouton en fonction du type qui est renseigné
		// sur le tableau de int

		int type = 10;
		for (int i = 1; i < (this.height); i++) {
			for (int j = 1; j < (this.width); j++) {

				type = tabUpdate[i][j];

				switch (type) {
					case 1 :
						// jeune pousse
						this.buttonTab[i][j].setBackground(new Color(199, 236,
								85));
						break;
					case 2 :
						// arbuste
						this.buttonTab[i][j].setBackground(new Color(33, 173,
								75));
						break;
					case 3 :
						// arbre
						this.buttonTab[i][j].setBackground(new Color(24, 126,
								55));
						break;
					case 4 :
						// feu
						this.buttonTab[i][j].setBackground(Color.RED);
						break;
					case 5 :
						// insecte
						this.buttonTab[i][j].setBackground(Color.ORANGE);
						break;
					case 6 :
						// cendre
						this.buttonTab[i][j].setBackground(Color.GRAY);
						break;
					case 0 :
						// vide
						this.buttonTab[i][j].setBackground(Color.WHITE);
						break;
					default :
						break;
				}
				type = 10;// pour réinitialiser la variable
			}
		}
	}

	public Map getMap() {
		return this.map;
	}

	public void statsMapPan() {

	}
}
