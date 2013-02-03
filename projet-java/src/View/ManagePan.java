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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @since Classe pour la création du panel gestion de simulation
 * @author david, agathe, alexandre
 */
public class ManagePan {

	private Font title = new Font("Arial", Font.BOLD, 16);
	private Font police = new Font("Arial", Font.PLAIN, 14);

	// champs réglage taille carte
	private JLabel mapSizeLabel = new JLabel("Taille carte :");
	private JTextField heightMap = new JTextField("100");
	private JLabel xSize = new JLabel("x");
	private JTextField widthMap = new JTextField("100");
	private JLabel ppSizeMap = new JLabel("");

	// boutons automatique et manuel
	private JButton automaticButton = new JButton("Automatique");
	private JButton manualButton = new JButton("Manuel");

	// champs vitesse de pas en automatique
	private JLabel speedSimulationLabel = new JLabel("Vitesse de simulation :");
	private JTextField speedSimulationTextField = new JTextField("40");
	private JLabel ppSpeedSimulation = new JLabel("");

	// champs nombre de pas en automatique
	private JLabel numberCycleSimulationLabel = new JLabel("Nombre de pas :");
	private JTextField numberCycleSimulationTextField = new JTextField("50");
	private JLabel ppNumberCycleSimulation = new JLabel("");

	private JButton startButton = new JButton("Démarrer");

	// instance de la classe Window
	private Window window;

	// récupère l'instance de la classe Window
	public ManagePan(final Window window) {
		this.window = window;
	}

	/**
	 * @since initilise un panel gestion de simulation
	 * @return {@link JPanel}
	 */
	public JPanel initManagePan() {
		// création d'un panel principal
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		JPanel panCenter = new JPanel();
		panCenter.setBackground(Color.WHITE);
		panCenter.setBorder(BorderFactory.createTitledBorder(null,
				"Gestions simulations", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, this.title));

		this.heightMap.setPreferredSize(new Dimension(40, 20));
		this.widthMap.setPreferredSize(new Dimension(40, 20));
		this.ppSizeMap.setPreferredSize(new Dimension(30, 20));
		this.manualButton.setPreferredSize(new Dimension(110, 25));
		this.speedSimulationTextField.setPreferredSize(new Dimension(40, 20));
		this.numberCycleSimulationTextField.setPreferredSize(new Dimension(40,
				20));
		this.startButton.setPreferredSize(new Dimension(110, 25));

		this.mapSizeLabel.setFont(this.police);
		this.speedSimulationLabel.setFont(this.police);
		this.numberCycleSimulationLabel.setFont(this.police);

		// ecoute bouton manuel
		this.manualButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				ManagePan.this.speedSimulationTextField.setEnabled(false);
				ManagePan.this.numberCycleSimulationTextField.setEnabled(false);
			}
		});

		// ecoute bouton automatique
		this.automaticButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ManagePan.this.speedSimulationTextField.setEnabled(true);
				ManagePan.this.numberCycleSimulationTextField.setEnabled(true);
			}
		});

		JPanel ppPanel = new JPanel();
		ppPanel.setBackground(Color.WHITE);
		ppPanel.setPreferredSize(new Dimension(290, 15));

		JPanel ppPanel1 = new JPanel();
		ppPanel1.setBackground(Color.WHITE);
		ppPanel1.setPreferredSize(new Dimension(290, 15));

		JPanel ppPanel2 = new JPanel();
		ppPanel2.setBackground(Color.WHITE);
		ppPanel2.setPreferredSize(new Dimension(290, 15));

		JPanel ppPanel3 = new JPanel();
		ppPanel3.setBackground(Color.WHITE);
		ppPanel3.setPreferredSize(new Dimension(15, 15));

		JPanel ppPanel4 = new JPanel();
		ppPanel4.setBackground(Color.WHITE);
		ppPanel4.setPreferredSize(new Dimension(50, 15));

		JPanel ppPanel5 = new JPanel();
		ppPanel5.setBackground(Color.WHITE);
		ppPanel5.setPreferredSize(new Dimension(200, 15));

		JPanel ppPanel6 = new JPanel();
		ppPanel6.setBackground(Color.WHITE);
		ppPanel6.setPreferredSize(new Dimension(200, 5));

		panCenter.add(ppPanel);
		panCenter.add(this.mapSizeLabel);
		panCenter.add(this.heightMap);
		panCenter.add(this.xSize);
		panCenter.add(this.widthMap);
		panCenter.add(this.ppSizeMap);
		panCenter.add(ppPanel1);
		panCenter.add(this.automaticButton);
		panCenter.add(this.manualButton);
		panCenter.add(ppPanel2);
		panCenter.add(this.speedSimulationLabel);
		panCenter.add(this.speedSimulationTextField);
		panCenter.add(ppPanel3);
		panCenter.add(this.ppSpeedSimulation);
		panCenter.add(ppPanel6);
		panCenter.add(this.numberCycleSimulationLabel);
		panCenter.add(this.numberCycleSimulationTextField);
		panCenter.add(this.ppNumberCycleSimulation);
		panCenter.add(ppPanel4);
		panCenter.add(ppPanel5);
		panCenter.add(this.startButton);

		container.add(panCenter, BorderLayout.CENTER);

		return container;
	}
}
