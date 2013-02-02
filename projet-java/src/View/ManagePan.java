package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ManagePan {

	private Font police = new Font("Arial", Font.BOLD, 16);
	private Font police2 = new Font("Arial", Font.PLAIN, 14);

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

	public ManagePan() {

	}

	public JPanel initManagePan() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		JPanel panCenter = new JPanel();
		panCenter.setBackground(Color.WHITE);
		panCenter.setBorder(BorderFactory.createTitledBorder(null,
				"Gestions simulations", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, this.police));

		this.heightMap.setPreferredSize(new Dimension(40, 20));
		this.widthMap.setPreferredSize(new Dimension(40, 20));
		this.ppSizeMap.setPreferredSize(new Dimension(30, 20));

		this.mapSizeLabel.setFont(this.police2);
		this.speedSimulationLabel.setFont(this.police2);
		this.numberCycleSimulationLabel.setFont(this.police2);

		JPanel ppPanel = new JPanel();
		ppPanel.setBackground(Color.WHITE);
		ppPanel.setPreferredSize(new Dimension(290, 15));

		panCenter.add(ppPanel);
		panCenter.add(this.mapSizeLabel);
		panCenter.add(this.heightMap);
		panCenter.add(this.xSize);
		panCenter.add(this.widthMap);
		panCenter.add(this.ppSizeMap);
		panCenter.add(this.automaticButton);
		panCenter.add(this.manualButton);
		panCenter.add(this.speedSimulationLabel);
		panCenter.add(this.speedSimulationTextField);
		panCenter.add(this.ppSpeedSimulation);
		panCenter.add(this.numberCycleSimulationLabel);
		panCenter.add(this.numberCycleSimulationTextField);
		panCenter.add(this.ppNumberCycleSimulation);
		panCenter.add(this.startButton);

		container.add(panCenter, BorderLayout.CENTER);

		return container;

	}

}
