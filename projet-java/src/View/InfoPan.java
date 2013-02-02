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

public class InfoPan {

	private Font police = new Font("Arial", Font.BOLD, 16);
	private Font police2 = new Font("Arial", Font.PLAIN, 14);

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

	private Window window;

	public InfoPan(final Window window) {
		this.window = window;
	}

	public JPanel initInfoPan() {

		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		JPanel panCenter = new JPanel();
		panCenter.setBackground(Color.WHITE);
		JPanel panWest = new JPanel();
		panWest.setBackground(Color.white);
		panWest.setPreferredSize(new Dimension(30, 360));

		container.setBackground(Color.WHITE);
		container.setPreferredSize(new Dimension(0, 360));

		container.setBorder(BorderFactory.createTitledBorder(null,
				"Informations", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, this.police));

		JPanel ppPanel = new JPanel();
		ppPanel.setBackground(Color.WHITE);
		ppPanel.setPreferredSize(new Dimension(290, 15));

		this.youngPlantButton.setBackground(new Color(199, 236, 85));
		this.youngPlantButton.setPreferredSize(new Dimension(25, 25));
		this.youngPlantLabel.setPreferredSize(new Dimension(230, 30));
		this.youngPlantLabel.setFont(this.police2);

		this.plantButton.setBackground(new Color(33, 173, 75));
		this.plantButton.setPreferredSize(new Dimension(25, 25));
		this.plantLabel.setPreferredSize(new Dimension(230, 30));
		this.plantLabel.setFont(this.police2);

		this.treeButton.setBackground(new Color(24, 126, 55));
		this.treeButton.setPreferredSize(new Dimension(25, 25));
		this.treeLabel.setPreferredSize(new Dimension(230, 30));
		this.treeLabel.setFont(this.police2);

		this.voidButton.setBackground(Color.WHITE);
		this.voidButton.setPreferredSize(new Dimension(25, 25));
		this.voidLabel.setPreferredSize(new Dimension(230, 30));
		this.voidLabel.setFont(this.police2);

		this.fireButton.setBackground(Color.RED);
		this.fireButton.setPreferredSize(new Dimension(25, 25));
		this.fireLabel.setPreferredSize(new Dimension(230, 30));
		this.fireLabel.setFont(this.police2);

		this.cinderButton.setBackground(Color.gray);
		this.cinderButton.setPreferredSize(new Dimension(25, 25));
		this.cinderLabel.setPreferredSize(new Dimension(230, 30));
		this.cinderLabel.setFont(this.police2);

		this.insectButton.setBackground(Color.ORANGE);
		this.insectButton.setPreferredSize(new Dimension(25, 25));
		this.insectLabel.setPreferredSize(new Dimension(230, 30));
		this.insectLabel.setFont(this.police2);

		this.cinderButton.setEnabled(false);

		this.youngPlantButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(208, 239, 114);

			}
		});

		this.plantButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(208, 239, 114);

			}
		});

		this.treeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(208, 239, 114);

			}
		});

		this.fireButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(255, 176, 176);

			}
		});

		this.voidButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.insectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				InfoPan.this.window.colorPan(255, 220, 98);

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
