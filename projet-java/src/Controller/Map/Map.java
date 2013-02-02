package Controller.Map;

import javax.swing.JPanel;

import View.Window;

public class Map implements MapSoft {

	private Window window;

	public Map(final Window window) {
		this.window = window;
	}

	@Override
	public JPanel initMap(final JPanel panWest) {
		this.window.colorPan(208, 239, 114);
		return panWest;
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

}
