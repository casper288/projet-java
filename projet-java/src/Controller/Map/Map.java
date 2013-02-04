package Controller.Map;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import View.Window;

/**
 * @see
 * 
 * @author david
 * 
 */
public class Map implements MapSoft {

	private int height = 0;// en case et pas en pixel

	private int width = 0;
	private int total = this.height * this.width;
	private List<List<Element>> elements;

	private Window window;

	public Map(final Window window) {
		this.window = window;
	}

	@Override
	public List<List<Element>> initMap() {
		this.setHeight(100);
		this.setWidth(100);
		this.elements = new ArrayList<List<Element>>();
		for (int i = 0; i < this.width; i++) {
			List<Element> ligne = new ArrayList<Element>();
			for (int j = 0; j < this.height; j++) {
				Element e = new Element(0);
				ligne.add(e);
				// add(e);
			}
			this.elements.add(ligne);
		}
		return this.elements;

	}
	@Override
	public JPanel updateMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateElement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveMap() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportMap() {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel importMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getTotal() {
		return this.total;
	}

	public List<List<Element>> getElements() {
		return this.elements;
	}

	public void setElements(final List<List<Element>> elements) {
		this.elements = elements;
	}

}
