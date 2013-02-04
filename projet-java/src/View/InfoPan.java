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

	private Font title = new Font("Arial", Font.BOLD, 16);
	private Font police = new Font("Arial", Font.PLAIN, 14);

	// bouton en label jeune pousse
	private JButton youngPlantButton = new JButton();
	private String numberYoungPlant = "0";
	private JLabel youngPlantLabel = new JLabel("jeune(s) pousse(s) : "
			+ this.numberYoungPlant);

	// bouton en label arbuste
	private JButton plantButton = new JButton();
	private String numberplant = "0";
	private JLabel plantLabel = new JLabel("arbuste(s) : " + this.numberplant);

	// bouton en label arbre
	private JButton treeButton = new JButton();
	private String numberTree = "0";
	private JLabel treeLabel = new JLabel("arbre(s) : " + this.numberTree);

	// bouton en label vide
	private JButton voidButton = new JButton();
	private String numberVoid = "0";
	private JLabel voidLabel = new JLabel("vide(s) : " + this.numberVoid);

	// bouton en label feu
	private JButton fireButton = new JButton();
	private String numberFire = "0";
	private JLabel fireLabel = new JLabel("arbre(s) en feu(x) : "
			+ this.numberFire);

	// bouton en label cendre
	private JButton cinderButton = new JButton();
	private String numberCinder = "0";
	private JLabel cinderLabel = new JLabel("cendre(s) : " + this.numberCinder);

	// bouton en label insecte
	private JButton insectButton = new JButton();
	private String numberInsect = "0";
	private JLabel insectLabel = new JLabel("arbre(s) infecté(s) : "
			+ this.numberInsect);

	// instance de la classe Window
	private Window window;

	public InfoPan(final Window window) {
		// récupère l'instance de la classe Window
		this.window = window;
	}

	/**
	 * @since initilise un panel information
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
}
