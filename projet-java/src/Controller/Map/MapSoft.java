package Controller.Map;

import java.util.List;

import javax.swing.JPanel;

public interface MapSoft {
	JPanel updateMap();
	void updateElement();
	void saveMap();
	void exportMap();
	JPanel importMap();
	List<List<Element>> initMap();

}
