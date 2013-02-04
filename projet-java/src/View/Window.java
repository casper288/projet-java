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
 * @since Classe de la fen�tre principale dans laquelle on instance le menu et
 *        des panel dans un panel g�n�ral.
 * @see colorPan()
 * @author david, agathe, alexandre
 */
public class Window extends JFrame {

	// sauvegarde du mode s�lectionn�.
	private String mode = "forest";

	// menu du programme
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu fileMenu = new JMenu("Fichier");
	private final JMenuItem newMapButton = new JMenuItem("Nouvelle Carte");
	private final JMenu saveMenu = new JMenu("Sauvegarder");
	private final JMenuItem saveBddButton = new JMenuItem("Base de donn�es");
	private final JMenuItem saveCsvButton = new JMenuItem("CSV");
	private final JMenuItem importButton = new JMenuItem("Importer carte");
	private final JMenuItem exitButton = new JMenuItem("Quitter");
	private final JMenu modeMenu = new JMenu("Mode simulation");
	private final JMenuItem forestModeButton = new JMenuItem("For�t");
	private final JMenuItem fireModeButton = new JMenuItem("Feu de for�t");
	private final JMenuItem insectModeButton = new JMenuItem(
			"Invasion d'insectes");

	private final JMenuItem helpMenu = new JMenuItem("Aide");
	private final JMenuItem aboutButton = new JMenuItem("� propos");

	private final JPanel panCenter = new JPanel();
	private JPanel panWest = new JPanel();
	private final JPanel panEast = new JPanel();
	private final JPanel panSouth = new JPanel();
	private final JPanel panNorth = new JPanel();

	private MapPan mapPan = null;

	private static final long serialVersionUID = 1L;

	public Window() {
		this.setTitle("Simulateur de vie d'une for�t");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent(); // initialisation du contenu de la fen�tre
	}

	private void initComponent() {
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

		// Cr�ation panel map
		JPanel panWestCenter = new JPanel();
		MapPan mapPan = new MapPan(Window.this);
		panWestCenter = mapPan.initMapPan();

		this.panWest.add(panWestCenter, BorderLayout.NORTH);
		this.panWest.setPreferredSize(new Dimension(700, 600));

		// �coute du bouton quitter
		this.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});

		// �coute du bouton mode for�t
		this.forestModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.colorPan(208, 239, 114);
				Window.this.setMode("forest");

			}
		});

		// �coute du bouton mode feu de for�t
		this.fireModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Window.this.colorPan(255, 176, 176);
				Window.this.setMode("fire");

			}
		});

		// �coute du bouton mode insectes
		this.insectModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.colorPan(255, 220, 98);
				Window.this.setMode("insect");
			}
		});

		// �coute du bouton nouvelle map
		this.newMapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				MapPan mapPan = new MapPan(Window.this);
				Window.this.panWest = mapPan.initMapPan();
			}
		});

		// �coute du bouton sauvegarder BDD
		this.saveBddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {

			}
		});

		// �coute du bouton Export CSV
		this.saveCsvButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

			}
		});

		// �coute du bouton import BDD
		this.importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

			}
		});

		this.panCenter.setLayout(new BorderLayout());
		this.panCenter.setPreferredSize(new Dimension(0, 0));

		// Cr�ation du panel informations
		JPanel panCenterNorth = new JPanel();
		panCenterNorth.setBackground(Color.WHITE);
		InfoPan infoPan = new InfoPan(Window.this);
		panCenterNorth = infoPan.initInfoPan();

		// Cr�ation panel gestion simulation
		JPanel panCenterCenter = new JPanel();
		panCenterCenter.setBackground(Color.WHITE);
		ManagePan managePan = new ManagePan(Window.this);
		panCenterCenter = managePan.initManagePan();

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
	 * @since m�thode permettant de changer la couleur de la fen�tre du
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

	}

	/**
	 * @since m�thode pour r�cup�rer le mode (forest, fire, insect)
	 * @return {@link String}
	 */
	public String getMode() {
		return this.mode;
	}

	/**
	 * @since m�thode pour changer le mode (forest, fire, insect)
	 * @param mode
	 */
	public void setMode(final String mode) {
		this.mode = mode;
	}
}
