package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @since Classe pour la création du panel information
 * @author david, agathe, alexandre
 */
public class InfoPan {

	private final Font title = new Font("Arial", Font.BOLD, 16);
	private final Font police = new Font("Arial", Font.PLAIN, 14);

	// bouton en label jeune pousse
	private final JButton youngPlantButton = new JButton();
	private final String numberYoungPlant = "0";
	private final JLabel youngPlantLabel = new JLabel("jeune(s) pousse(s) : "
			+ this.numberYoungPlant);

	// bouton en label arbuste
	private final JButton plantButton = new JButton();
	private final String numberplant = "0";
	private final JLabel plantLabel = new JLabel("arbuste(s) : "
			+ this.numberplant);

	// bouton en label arbre
	private final JButton treeButton = new JButton();
	private final String numberTree = "0";
	private final JLabel treeLabel = new JLabel("arbre(s) : " + this.numberTree);

	// bouton en label vide
	private final JButton voidButton = new JButton();
	private final String numberVoid = "0";
	private final JLabel voidLabel = new JLabel("vide(s) : " + this.numberVoid);

	// bouton en label feu
	private final JButton fireButton = new JButton();
	private final String numberFire = "0";
	private final JLabel fireLabel = new JLabel("arbre(s) en feu(x) : "
			+ this.numberFire);

	// bouton en label cendre
	private final JButton cinderButton = new JButton();
	private final String numberCinder = "0";
	private final JLabel cinderLabel = new JLabel("cendre(s) : "
			+ this.numberCinder);

	// bouton en label insecte
	private final JButton insectButton = new JButton();
	private final String numberInsect = "0";
	private final JLabel insectLabel = new JLabel("arbre(s) infecté(s) : "
			+ this.numberInsect);

	// instance de la classe Window
	private final Window window;

	public InfoPan(final Window window) {
		// récupère l'instance de la classe Window
		this.window = window;
	}

	/**
	 * @since initialise un panel information
	 * @return {@link JPanel}
	 */
	public JPanel initInfoPan() {
		// création d'un panel principal
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		JPanel panCenter = new JPanel();
		panCenter.setBackground(Color.WHITE);
		JPanel panWest = new JPanel();
		panWest.setBackground(Color.white);
		panWest.setPreferredSize(new Dimension(20, 360));

		container.setBackground(Color.WHITE);
		container.setPreferredSize(new Dimension(0, 360));

		container.setBorder(BorderFactory.createTitledBorder(null,
				"Informations", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, this.title));

		JPanel ppPanel = new JPanel();
		ppPanel.setBackground(Color.WHITE);
		ppPanel.setPreferredSize(new Dimension(290, 15));

		this.youngPlantButton.setBackground(new Color(199, 236, 85));
		this.youngPlantButton.setPreferredSize(new Dimension(25, 25));
		this.youngPlantLabel.setPreferredSize(new Dimension(230, 30));
		this.youngPlantLabel.setFont(this.police);

		this.plantButton.setBackground(new Color(33, 173, 75));
		this.plantButton.setPreferredSize(new Dimension(25, 25));
		this.plantLabel.setPreferredSize(new Dimension(230, 30));
		this.plantLabel.setFont(this.police);

		this.treeButton.setBackground(new Color(24, 126, 55));
		this.treeButton.setPreferredSize(new Dimension(25, 25));
		this.treeLabel.setPreferredSize(new Dimension(230, 30));
		this.treeLabel.setFont(this.police);

		this.voidButton.setBackground(Color.WHITE);
		this.voidButton.setPreferredSize(new Dimension(25, 25));
		this.voidLabel.setPreferredSize(new Dimension(230, 30));
		this.voidLabel.setFont(this.police);

		this.fireButton.setBackground(Color.RED);
		this.fireButton.setPreferredSize(new Dimension(25, 25));
		this.fireLabel.setPreferredSize(new Dimension(230, 30));
		this.fireLabel.setFont(this.police);

		this.cinderButton.setBackground(Color.gray);
		this.cinderButton.setPreferredSize(new Dimension(25, 25));
		this.cinderLabel.setPreferredSize(new Dimension(230, 30));
		this.cinderLabel.setFont(this.police);

		this.insectButton.setBackground(Color.ORANGE);
		this.insectButton.setPreferredSize(new Dimension(25, 25));
		this.insectLabel.setPreferredSize(new Dimension(230, 30));
		this.insectLabel.setFont(this.police);

		this.cinderButton.setEnabled(false);

		// ecoute bouton jeune pousse
		this.youngPlantButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(208, 239, 114);
				InfoPan.this.window.setMode("forest");
				InfoPan.this.window.setElementSelect("youngPlant");
			}
		});

		// ecoute bouton arbuste
		this.plantButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(208, 239, 114);
				InfoPan.this.window.setMode("forest");
				InfoPan.this.window.setElementSelect("plant");

			}
		});

		// ecoute bouton arbre
		this.treeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(208, 239, 114);
				InfoPan.this.window.setMode("forest");
				InfoPan.this.window.setElementSelect("tree");

			}
		});

		// ecoute bouton feu
		this.fireButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(255, 176, 176);
				InfoPan.this.window.setMode("fire");
				InfoPan.this.window.setElementSelect("fire");
			}
		});

		// ecoute bouton vide
		this.voidButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.setElementSelect("void");

			}
		});

		// ecoute bouton insecte
		this.insectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(255, 220, 98);
				InfoPan.this.window.setMode("insect");
				InfoPan.this.window.setElementSelect("insect");
			}
		});

		panCenter.add(ppPanel);
		panCenter.add(this.youngPlantButton);
		panCenter.add(this.youngPlantLabel);
		panCenter.add(this.plantButton);
		panCenter.add(this.plantLabel);
		panCenter.add(this.treeButton);
		panCenter.add(this.treeLabel);
		panCenter.add(this.voidButton);
		panCenter.add(this.voidLabel);
		panCenter.add(this.fireButton);
		panCenter.add(this.fireLabel);
		panCenter.add(this.cinderButton);
		panCenter.add(this.cinderLabel);
		panCenter.add(this.insectButton);
		panCenter.add(this.insectLabel);

		container.add(panCenter, BorderLayout.CENTER);
		container.add(panWest, BorderLayout.WEST);

		return container;

	}

	public void setNumberStat(final int[] tab) {
		// méthode de mise a jour des label qui indiquent le nombre
		// d'element sur le tableau, c'est la fonction statsMap qui
		// envoie le nombre d'element via un tableau unidimensionel

		int total = Integer.parseInt(this.window.getManagePan().getSizeMap()
				.getText())
				* Integer.parseInt(this.window.getManagePan().getSizeMap()
						.getText());

		int t1 = (tab[1] * 100) / total;
		int t2 = (tab[2] * 100) / total;
		int t3 = (tab[3] * 100) / total;
		int t4 = (tab[4] * 100) / total;
		int t5 = (tab[5] * 100) / total;
		int t6 = (tab[6] * 100) / total;

		int t0 = (tab[0] * 100) / total;
		if (t0 < 3) {
			t0 = 0;
		}

		this.youngPlantLabel.setText("jeune(s) pousse(s) : "
				+ Integer.toString(t1) + "%");
		this.plantLabel.setText("arbuste(s) : " + Integer.toString(t2) + "%");
		this.treeLabel.setText("arbre(s) : " + Integer.toString(t3) + "%");
		this.fireLabel.setText("arbre(s) en feu(x) : " + Integer.toString(t4)
				+ "%");
		this.insectLabel.setText("arbre(s) infecté(s) : "
				+ Integer.toString(t5) + "%");
		this.cinderLabel.setText("cendre(s) : " + Integer.toString(t6) + "%");
		this.voidLabel.setText("vide(s) : " + Integer.toString(t0) + "%");
	}
}
