package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @since Classe de la fenêtre principale dans laquelle on instance le menu et
 *        des panel dans un panel général.
 * @see colorPan()
 * @author david, agathe, alexandre
 */
public class Window extends JFrame {

	// sauvegarde du mode sélectionné.
	private String mode = "forest";
	private String elementSelect = "youngPlant";

	// menu du programme
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

	private JPanel panCenter = new JPanel();
	private JPanel panWest = new JPanel();
	private JPanel panEast = new JPanel();
	private JPanel panSouth = new JPanel();
	private JPanel panNorth = new JPanel();
	private JPanel panWestCenter = new JPanel();

	private MapPan mapPan = null;

	private static final long serialVersionUID = 1L;

	public Window() {
		this.setTitle("Simulateur de vie d'une forêt");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent(); // initialisation du contenu de la fenêtre
	}

	private void initComponent() {
		// container principal
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		// organisation de mon menu
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

		// Création panel map
		this.mapPan = new MapPan(Window.this);
		this.panWestCenter = this.mapPan.initMapPan();
		this.panWest.add(this.panWestCenter, BorderLayout.NORTH);

		// Écoute du bouton quitter
		this.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});

		// Écoute du bouton mode forêt
		this.forestModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.colorPan(208, 239, 114);
				Window.this.setMode("forest");
				Window.this.setElementSelect("young");

			}
		});

		// Écoute du bouton mode feu de forêt
		this.fireModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Window.this.colorPan(255, 176, 176);
				Window.this.setMode("fire");
				Window.this.setElementSelect("fire");

			}
		});

		// Écoute du bouton mode insectes
		this.insectModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.colorPan(255, 220, 98);
				Window.this.setMode("insect");
			}
		});

		// Écoute du bouton nouvelle map
		this.newMapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.panWestCenter = Window.this.mapPan.initMapPan();

			}
		});

		// Écoute du bouton sauvegarder BDD
		this.saveBddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {

			}
		});

		// Écoute du bouton Export CSV
		this.saveCsvButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

			}
		});

		// Écoute du bouton import BDD
		this.importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

			}
		});

		this.panCenter.setLayout(new BorderLayout());
		// this.panCenter.setPreferredSize(new Dimension(0, 0));

		// Création du panel informations
		JPanel panCenterNorth = new JPanel();
		panCenterNorth.setBackground(Color.WHITE);
		InfoPan infoPan = new InfoPan(Window.this);
		panCenterNorth = infoPan.initInfoPan();

		// Création panel gestion simulation
		JPanel panCenterCenter = new JPanel();
		panCenterCenter.setBackground(Color.WHITE);
		ManagePan managePan = new ManagePan(Window.this);
		panCenterCenter = managePan.initManagePan(this.mapPan);

		// ajout des panels dans le panelCenter
		this.panCenter.add(panCenterNorth, BorderLayout.NORTH);
		this.panCenter.add(panCenterCenter, BorderLayout.CENTER);

		// taille des panels
		this.panNorth.setPreferredSize(new Dimension(10, 10));
		this.panEast.setPreferredSize(new Dimension(10, 20));
		this.panSouth.setPreferredSize(new Dimension(10, 10));

		// ajout des panels dans le panel principal
		container.add(this.panNorth, BorderLayout.NORTH);
		container.add(this.panWest, BorderLayout.WEST);
		container.add(this.panCenter, BorderLayout.CENTER);
		container.add(this.panEast, BorderLayout.EAST);
		container.add(this.panSouth, BorderLayout.SOUTH);

		this.setContentPane(container);
		this.setJMenuBar(this.menuBar);
	}

	/**
	 * @since méthode permettant de changer la couleur de la fenêtre du
	 *        programme
	 * @param color1
	 * @param color2
	 * @param color3
	 */
	public void colorPan(final int color1, final int color2, final int color3) {
		Window.this.panWest.setBackground(new Color(color1, color2, color3));
		Window.this.panSouth.setBackground(new Color(color1, color2, color3));
		Window.this.panEast.setBackground(new Color(color1, color2, color3));
		Window.this.panNorth.setBackground(new Color(color1, color2, color3));
		Window.this.panCenter.setBackground(new Color(color1, color2, color3));
		Window.this.panWestCenter.setBackground(new Color(color1, color2,
				color3));
	}

	/**
	 * @since méthode pour récupérer le mode (forest, fire, insect)
	 * @return {@link String}
	 */
	public String getMode() {
		return this.mode;
	}

	/**
	 * @since méthode pour changer le mode (forest, fire, insect)
	 * @param mode
	 */
	public void setMode(final String mode) {
		this.mode = mode;
	}

	public String getElementSelect() {
		return this.elementSelect;
	}

	public void setElementSelect(final String elementSelect) {
		this.elementSelect = elementSelect;
	}

}
