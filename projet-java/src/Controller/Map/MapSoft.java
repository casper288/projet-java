package Controller.Map;

import javax.swing.JPanel;

public interface MapSoft {
    void updateMap(int y, int x, int type);

    void updateElement();

    void saveMap();

    void exportMap();

    JPanel importMap();

}
