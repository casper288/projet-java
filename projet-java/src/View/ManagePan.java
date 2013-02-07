package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Controller.Simulation.SimulationForest;

/**
 * @since Classe pour la cr�ation du panel gestion de simulation
 * @author david, agathe, alexandre
 */
public class ManagePan {

	private final Font title = new Font("Arial", Font.BOLD, 16);
	private final Font police = new Font("Arial", Font.PLAIN, 14);

	// champs r�glage taille carte
	private final JLabel mapSizeLabel = new JLabel("Taille carte :");
	private final JTextField heightMap = new JTextField("3");
	private final JLabel xSize = new JLabel("x");
	private final JTextField widthMap = new JTextField("3");
	private final JLabel ppSizeMap = new JLabel("");

	// boutons automatique et manuel
	private final JButton automaticButton = new JButton("Automatique");
	private final JButton manualButton = new JButton("Manuel");

	// champs vitesse de pas en automatique
	private final JLabel speedSimulationLabel = new JLabel(
			"Temps d'un pas en milliseconde :");
	private final JTextField speedSimulationTextField = new JTextField("1");

	public JTextField getSpeedSimulationTextField() {
		return this.speedSimulationTextField;
	}

	private final JLabel ppSpeedSimulation = new JLabel("");

	// champs nombre de pas en automatique
	private final JLabel numberCycleSimulationLabel = new JLabel(
			"Nombre de pas :");
	private final JTextField numberCycleSimulationTextField = new JTextField(
			"10");

	public JTextField getNumberCycleSimulationTextField() {
		return this.numberCycleSimulationTextField;
	}

	private final JLabel ppNumberCycleSimulation = new JLabel("");

	private final JButton startButton = new JButton("D�marrer");
	private final JButton stopButton = new JButton("Stop");

	public JButton getStopButton() {
		return this.stopButton;
	}

	public JButton getStartButton() {
		return this.startButton;
	}

	// instance de la classe Window
	@SuppressWarnings("unused")
	private final Window window;

	// r�cup�re l'instance de la classe Window
	public ManagePan(final Window window) {
		this.window = window;
	}

	/**
	 * @param mapPan
	 * @since initilise un panel gestion de simulation
	 * @return {@link JPanel}
	 */
	public JPanel initManagePan(final MapPan mapPan) {
		// cr�ation d'un panel principal
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
		this.stopButton.setPreferredSize(new Dimension(60, 25));

		this.mapSizeLabel.setFont(this.police);
		this.speedSimulationLabel.setFont(this.police);
		this.numberCycleSimulationLabel.setFont(this.police);

		this.numberCycleSimulationLabel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(final KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(final KeyEvent arg0) {
				String content = ManagePan.this.numberCycleSimulationLabel
						.getText();

				if ("".equals(content)) {
					return;
				}
				if (content.matches("\\d")) {

				} else {
					ManagePan.this.numberCycleSimulationLabel.setText("");
					JOptionPane.showMessageDialog(null, "Numero invalide !",
							"Attention", JOptionPane.WARNING_MESSAGE);
				}

			}

			@Override
			public void keyPressed(final KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// action sur le Field speedSimulationTextField avec regex
		this.speedSimulationTextField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(final KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(final KeyEvent arg0) {
				String content = ManagePan.this.speedSimulationTextField
						.getText();

				if ("".equals(content)) {
					return;
				}
				if (content.matches("\\d{1,4}")) {

				} else {
					ManagePan.this.speedSimulationTextField.setText("");
					JOptionPane.showMessageDialog(null, "Numero invalide !",
							"Attention", JOptionPane.WARNING_MESSAGE);
				}

			}

			@Override
			public void keyPressed(final KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// action sur le field pour changer taille map
		this.heightMap.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(final KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(final KeyEvent arg0) {
				String content = ManagePan.this.heightMap.getText();

				if ("".equals(content)) {
					return;
				}
				if (content.matches("\\d{1,3}")) {

				} else {
					ManagePan.this.heightMap.setText("");
					JOptionPane.showMessageDialog(null, "Numero invalide !",
							"Attention", JOptionPane.WARNING_MESSAGE);
				}

			}

			@Override
			public void keyPressed(final KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// ecoute bouton stop
		this.stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// ecoute bouton manuel
		this.manualButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				ManagePan.this.speedSimulationTextField.setEnabled(false);
				ManagePan.this.numberCycleSimulationTextField.setEnabled(false);
				ManagePan.this.manualButton.setBackground(Color.lightGray);
				ManagePan.this.automaticButton.setBackground(new Color(218,
						230, 242));
				ManagePan.this.numberCycleSimulationTextField.setText("1");
				ManagePan.this.speedSimulationTextField.setText("1");
			}
		});

		// ecoute bouton automatique
		this.automaticButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ManagePan.this.speedSimulationTextField.setEnabled(true);
				ManagePan.this.numberCycleSimulationTextField.setEnabled(true);
				ManagePan.this.automaticButton.setBackground(Color.lightGray);
				ManagePan.this.manualButton.setBackground(new Color(218, 230,
						242));

			}
		});

		this.startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				if (ManagePan.this.window.getMode() == "forest") {
					SimulationForest simulationForest = new SimulationForest(
							ManagePan.this.window);
					simulationForest.playSimulation();
				}
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
		panCenter.add(this.stopButton);

		container.add(panCenter, BorderLayout.CENTER);

		return container;
	}
}
