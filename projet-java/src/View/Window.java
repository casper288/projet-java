package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.Map.Map;

public class Window extends JFrame {

	private Font police = new Font("Arial", Font.BOLD, 16);
	private Font police2 = new Font("Arial", Font.PLAIN, 14);

	private String mode = "forest";
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("Fichier");
	private JMenuItem newMapButton = new JMenuItem("Nouvelle Carte");
	private JMenu saveMenu = new JMenu("Sauvegarder");
	private JMenuItem saveBddButton = new JMenuItem("Base de donn�es");
	private JMenuItem saveCsvButton = new JMenuItem("CSV");
	private JMenuItem importButton = new JMenuItem("Importer carte");
	private JMenuItem exitButton = new JMenuItem("Quitter");

	private JMenu modeMenu = new JMenu("Mode simulation");
	private JMenuItem forestModeButton = new JMenuItem("For�t");
	private JMenuItem fireModeButton = new JMenuItem("Feu de for�t");
	private JMenuItem insectModeButton = new JMenuItem("Invasion d'insectes");

	private JMenuItem helpMenu = new JMenuItem("Aide");
	private JMenuItem aboutButton = new JMenuItem("� propos");

	private JPanel panCenter = new JPanel();

	private JPanel panWest = new JPanel();
	final JPanel panEast = new JPanel();
	final JPanel panSouth = new JPanel();
	final JPanel panNorth = new JPanel();

	private Map map = null;

	private static final long serialVersionUID = 1L;

	public Window() {
		this.setTitle("Projet Java");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent(); // initialisation du contenu de la fen�tre
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

		this.map = new Map(Window.this);
		this.panWest = this.map.initMap(this.panWest);

		this.panWest.setPreferredSize(new Dimension(700, 600));

		this.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});

		this.forestModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.colorPan(208, 239, 114);
				Window.this.mode = "forest";

			}
		});

		this.fireModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Window.this.colorPan(255, 176, 176);
				Window.this.mode = "fire";

			}
		});

		this.insectModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.colorPan(255, 220, 98);
				Window.this.mode = "insect";
			}
		});

		this.newMapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Map map = new Map(Window.this);
				Window.this.panWest = map.initMap(Window.this.panWest);
			}
		});

		this.saveBddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Window.this.map.saveMap();
			}
		});

		this.saveCsvButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Window.this.map.exportMap();

			}
		});

		this.importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Window.this.map.importMap();

			}
		});

		this.panCenter.setLayout(new BorderLayout());
		this.panCenter.setPreferredSize(new Dimension(324, 0));

		JPanel panEastNorth = new JPanel();
		panEastNorth.setBackground(Color.WHITE);
		panEastNorth.setPreferredSize(new Dimension(0, 360));
		InfoPan infoPan = new InfoPan(Window.this);
		panEastNorth = infoPan.initInfoPan();

		JPanel panEastCenter = new JPanel();
		panEastCenter.setBackground(Color.WHITE);
		ManagePan managePan = new ManagePan();
		panEastCenter = managePan.initManagePan();

		this.panCenter.add(panEastNorth, BorderLayout.NORTH);
		this.panCenter.add(panEastCenter, BorderLayout.CENTER);

		this.panNorth.setPreferredSize(new Dimension(10, 10));
		this.panEast.setPreferredSize(new Dimension(10, 20));
		this.panSouth.setPreferredSize(new Dimension(10, 10));

		container.add(this.panNorth, BorderLayout.NORTH);
		container.add(this.panWest, BorderLayout.WEST);
		container.add(this.panCenter, BorderLayout.CENTER);
		container.add(this.panEast, BorderLayout.EAST);
		container.add(this.panSouth, BorderLayout.SOUTH);

		this.setContentPane(container);
		this.setJMenuBar(this.menuBar);
	}

	public void colorPan(final int color1, final int color2, final int color3) {
		Window.this.panWest.setBackground(new Color(color1, color2, color3));
		Window.this.panSouth.setBackground(new Color(color1, color2, color3));
		Window.this.panEast.setBackground(new Color(color1, color2, color3));
		Window.this.panNorth.setBackground(new Color(color1, color2, color3));
		Window.this.panCenter.setBackground(new Color(color1, color2, color3));

	}
}
