package Controller.Map;

import javax.swing.JPanel;

public interface MapSoft {
	JPanel updateMap();
	void updateElement();
	void saveMap();
	void exportMap();
	JPanel importMap();
	JPanel initMap(JPanel panWest);

}
