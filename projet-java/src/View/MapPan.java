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

public class MapPan extends JPanel {

	private Window window;
	private int width;
	private int height;
	private JButton buttonTab[][] = new JButton[51][51];

	public MapPan(final Window window) {
		this.window = window;
	}

	public JPanel initMapPan() {

		JPanel container = new JPanel(new GridLayout(50, 50));
		container.setPreferredSize(new Dimension(700, 680));

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

		//
		// // !!!!!!!!!!!!!!!!!!!!!!!!!
		// // !!!création objet map !!!
		// // !!!!!!!!!!!!!!!!!!!!!!!!!
		//
		// Map map = new Map(this.window);
		// // List<List<Element>> elements = map.initMap();
		//
		// // setLayout(new MapPan();

		// int Tab[][] = new int[52][52];

		// for (int i = 0; i < 52; i++) {
		// for (int j = 0; j < 52; j++) {
		// Tab[i][j] = 0;
		// }
		// }

		// Ajout des boutons
		for (int i = 1; i < 51; i++) {
			for (int j = 1; j < 51; j++) {
				this.buttonTab[i][j] = new JButton(/*
													 * new ImageIcon("toto.gif"
													 * )
													 */);

				this.buttonTab[i][j].setBackground(Color.white);

				Border thickBorder = new LineBorder(Color.gray, 1);
				this.buttonTab[i][j].setBorder(thickBorder);

				this.buttonTab[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						if (MapPan.this.window.getElementSelect() == "youngPlant") {
							((JButton) e.getSource()).setBackground(new Color(
									199, 236, 85));
						} else if (MapPan.this.window.getElementSelect() == "plant") {
							((JButton) e.getSource()).setBackground(new Color(
									33, 173, 75));
						} else if (MapPan.this.window.getElementSelect() == "tree") {
							((JButton) e.getSource()).setBackground(new Color(
									24, 126, 55));
						} else if (MapPan.this.window.getElementSelect() == "fire") {
							((JButton) e.getSource()).setBackground(Color.RED);
						} else if (MapPan.this.window.getElementSelect() == "insect") {
							((JButton) e.getSource())
									.setBackground(Color.ORANGE);
						} else {
							((JButton) e.getSource())
									.setBackground(Color.WHITE);
						}

						System.out.println("click!");

					}
				});
				container.add(this.buttonTab[i][j]);
			}// fin for j
		}// fin for i

		return container;
	}
	public void updateMapPan() {
		this.buttonTab[10][10].setBackground(Color.black);
	}
}
