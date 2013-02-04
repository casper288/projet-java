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
	private JButton buttonTab[][] = new JButton[101][101];

	public MapPan(final Window window) {
		this.window = window;
	}

	public JPanel initMapPan() {

		JPanel container = new JPanel(new GridLayout(100, 100));
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
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
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
						((JButton) e.getSource()).setBackground(Color.GREEN);
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
