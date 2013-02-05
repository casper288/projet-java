package Controller.Map;

public interface MapSoft {
	void updateMap(int y, int x, int type);

	void updateMapOnly();

	void updateTime(int y, int x, int type);

	void updateElement();

	void saveMap();

	void exportMap();

	void statsMap();

	void importMap();

}
