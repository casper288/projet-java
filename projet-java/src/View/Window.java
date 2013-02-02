package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("Fichier");
	private JMenuItem newMapButton = new JMenuItem("Nouvelle Carte");
	private JMenu saveMenu = new JMenu("Sauvegarder");
	private JMenuItem saveBddButton = new JMenuItem("Base de données");
	private JMenuItem saveCsvButton = new JMenuItem("CSV");
	private JMenuItem importButton = new JMenuItem("Importer carte");
	private JMenuItem exitButton = new JMenuItem("Quitter");

	private JMenu modeMenu = new JMenu("Mode simulation");
	private JMenuItem forestModeButton = new JMenuItem("Forêt");
	private JMenuItem fireModeButton = new JMenuItem("Feu de forêt");
	private JMenuItem insectModeButton = new JMenuItem("Invasion d'insectes");

	private JMenuItem helpMenu = new JMenuItem("Aide");
	private JMenuItem aboutButton = new JMenuItem("À propos");

	private JButton youngPlantButton = new JButton();
	private String numberYoungPlant = "0";
	private JLabel youngPlantLabel = new JLabel("jeune(s) pousse(s) : "
			+ this.numberYoungPlant);

	private JButton plantButton = new JButton();
	private String numberplant = "0";
	private JLabel plantLabel = new JLabel("arbuste(s) : " + this.numberplant);

	private JButton treeButton = new JButton();
	private String numberTree = "0";
	private JLabel treeLabel = new JLabel("arbre(s) : " + this.numberTree);

	private JButton voidButton = new JButton();
	private String numberVoid = "0";
	private JLabel voidLabel = new JLabel("vide(s) : " + this.numberVoid);

	private JButton fireButton = new JButton();
	private String numberFire = "0";
	private JLabel fireLabel = new JLabel("arbre(s) en feu(x) : "
			+ this.numberFire);

	private JButton cinderButton = new JButton();
	private String numberCinder = "0";
	private JLabel cinderLabel = new JLabel("cendre(s) : " + this.numberCinder);

	private JButton insectButton = new JButton();
	private String numberInsect = "0";
	private JLabel insectLabel = new JLabel("arbre(s) infecté(s) : "
			+ this.numberTree);

	private JLabel mapSizeLabel = new JLabel("Taille carte :");
	private JTextField heightMap = new JTextField("100");
	private JLabel xSize = new JLabel("x");
	private JTextField widthMap = new JTextField("100");
	private JLabel ppSizeMap = new JLabel("");

	private JButton automaticButton = new JButton("Automatique");
	private JButton manualButton = new JButton("Manuel");

	private JLabel speedSimulationLabel = new JLabel("Vitesse de simulation :");
	private JTextField speedSimulationTextField = new JTextField("40");
	private JLabel ppSpeedSimulation = new JLabel("");

	private JLabel numberCycleSimulationLabel = new JLabel("Nombre de pas :");
	private JTextField numberCycleSimulationTextField = new JTextField("50");
	private JLabel ppNumberCycleSimulation = new JLabel("");

	private JButton startButton = new JButton("Démarrer");

	private static final long serialVersionUID = 1L;

	public Window() {
		this.setTitle("Projet Java");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent(); // initialisation du contenu de la fenêtre
	}

	private void initComponent() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		this.saveMenu.add(this.saveBddButton);
		this.saveMenu.add(this.saveCsvButton);
		this.modeMenu.add(this.forestModeButton);
		this.modeMenu.add(this.fireModeButton);
		this.modeMenu.add(this.insectModeButton);
		this.fileMenu.add(this.newMapButton);
		this.fileMenu.add(this.saveMenu);
		this.fileMenu.add(this.importButton);
		this.fileMenu.add(this.exitButton);
		this.menuBar.add(this.fileMenu);
		this.menuBar.add(this.modeMenu);

		JPanel panCenter = new JPanel();
		panCenter.setBackground(Color.WHITE);

		JPanel panEast = new JPanel();
		panEast.setLayout(new BorderLayout());
		panEast.setBackground(Color.gray);
		panEast.setPreferredSize(new Dimension(324, 0));

		JPanel panEastNorth = new JPanel();
		panEastNorth.setBackground(Color.WHITE);
		panEastNorth.setPreferredSize(new Dimension(0, 360));
		panEastNorth
				.setBorder(BorderFactory.createTitledBorder("Informations"));

		this.youngPlantButton.setBackground(Color.green);
		this.youngPlantButton.setPreferredSize(new Dimension(15, 15));
		this.youngPlantLabel.setPreferredSize(new Dimension(270, 20));
		this.plantButton.setBackground(Color.GREEN);
		this.plantButton.setPreferredSize(new Dimension(15, 15));
		this.plantLabel.setPreferredSize(new Dimension(270, 20));
		this.treeButton.setBackground(Color.GREEN);
		this.treeButton.setPreferredSize(new Dimension(15, 15));
		this.treeLabel.setPreferredSize(new Dimension(270, 20));
		this.voidButton.setBackground(Color.WHITE);
		this.voidButton.setPreferredSize(new Dimension(15, 15));
		this.voidLabel.setPreferredSize(new Dimension(270, 20));
		this.fireButton.setBackground(Color.RED);
		this.fireButton.setPreferredSize(new Dimension(15, 15));
		this.fireLabel.setPreferredSize(new Dimension(270, 20));
		this.cinderButton.setBackground(Color.gray);
		this.cinderButton.setPreferredSize(new Dimension(15, 15));
		this.cinderLabel.setPreferredSize(new Dimension(270, 20));
		this.insectButton.setBackground(Color.ORANGE);
		this.insectButton.setPreferredSize(new Dimension(15, 15));
		this.insectLabel.setPreferredSize(new Dimension(270, 20));

		panEastNorth.add(this.youngPlantButton);
		panEastNorth.add(this.youngPlantLabel);
		panEastNorth.add(this.plantButton);
		panEastNorth.add(this.plantLabel);
		panEastNorth.add(this.treeButton);
		panEastNorth.add(this.treeLabel);
		panEastNorth.add(this.voidButton);
		panEastNorth.add(this.voidLabel);
		panEastNorth.add(this.fireButton);
		panEastNorth.add(this.fireLabel);
		panEastNorth.add(this.cinderButton);
		panEastNorth.add(this.cinderLabel);
		panEastNorth.add(this.insectButton);
		panEastNorth.add(this.insectLabel);

		JPanel panEastCenter = new JPanel();
		panEastCenter.setBackground(Color.WHITE);
		panEastCenter.setBorder(BorderFactory
				.createTitledBorder("Gestion simulation"));

		this.heightMap.setPreferredSize(new Dimension(40, 20));
		this.widthMap.setPreferredSize(new Dimension(40, 20));
		this.plantLabel.setPreferredSize(new Dimension(270, 20));
		this.ppSizeMap.setPreferredSize(new Dimension(30, 20));

		panEastCenter.add(this.mapSizeLabel);
		panEastCenter.add(this.heightMap);
		panEastCenter.add(this.xSize);
		panEastCenter.add(this.widthMap);
		panEastCenter.add(this.ppSizeMap);
		panEastCenter.add(this.automaticButton);
		panEastCenter.add(this.manualButton);
		panEastCenter.add(this.speedSimulationLabel);
		panEastCenter.add(this.speedSimulationTextField);
		panEastCenter.add(this.ppSpeedSimulation);
		panEastCenter.add(this.numberCycleSimulationLabel);
		panEastCenter.add(this.numberCycleSimulationTextField);
		panEastCenter.add(this.ppNumberCycleSimulation);
		panEastCenter.add(this.startButton);

		panEast.add(panEastNorth, BorderLayout.NORTH);
		panEast.add(panEastCenter, BorderLayout.CENTER);

		container.add(panCenter, BorderLayout.CENTER);
		container.add(panEast, BorderLayout.EAST);

		this.setContentPane(container);
		this.setJMenuBar(this.menuBar);
	}

}
