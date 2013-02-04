package Controller.Map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LinearGradientPaint;
import java.awt.Point;

import javax.swing.JPanel;

public class Element extends JPanel {

	private int type = 0;
	private Color couleurBorder = Color.GRAY;

	public Element(final int type) {
		this.type = type;
		this.setLayout(new GridLayout(1, 0));
		this.setSize(32, 32);
		this.setPreferredSize(new Dimension(48, 48));
	}
	@Override
	public void paintComponent(final Graphics g) {
		Graphics2D g2d = ((Graphics2D) g);

		g2d.setPaint(new LinearGradientPaint(new Point(0, 0), new Point(this
				.getWidth(), this.getHeight()), new float[]{0.0f, 1.0f},
				new Color[]{Color.LIGHT_GRAY, Color.WHITE}));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		g2d.setColor(this.couleurBorder);
		g2d.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
	}

	public int getType() {
		return this.type;
	}

	public void setType(final int type) {
		this.type = type;
	}
}
