package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MapPan extends JPanel {

	private Window window;
	private int width;
	private int height;

	public MapPan(final Window window) {
		this.window = window;
	}

	public JPanel initMapPan() {

		JPanel container = new JPanel(new GridLayout(70, 70));

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
		// this.window.colorPan(208, 239, 114);
		//
		// // !!!!!!!!!!!!!!!!!!!!!!!!!
		// // !!!création objet map !!!
		// // !!!!!!!!!!!!!!!!!!!!!!!!!
		//
		// Map map = new Map(this.window);
		// // List<List<Element>> elements = map.initMap();
		//
		// // setLayout(new MapPan();

		int Tab[][] = new int[52][52];
		JButton buttonTab[][] = new JButton[52][52];

		container.setLayout(new GridLayout(50, 50));

		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				Tab[i][j] = 0;
			}
		}

		// Ajout des boutons
		for (int i = 1; i < 51; i++) {
			for (int j = 1; j < 51; j++) {
				buttonTab[i][j] = new JButton(/* new ImageIcon("toto.gif" ) */);
				buttonTab[i][j].setPreferredSize(new Dimension(20, 20));
				buttonTab[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						((JButton) e.getSource()).setBackground(Color.GREEN);
						System.out.println("click!");

					}
				});
				container.add(buttonTab[i][j]);
			}// fin for j
		}// fin for i

		return container;
	}
	public void updateMapPan() {

	}
}
