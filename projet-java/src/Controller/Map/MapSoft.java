package Controller.Map;

public interface MapSoft {
	void updateMap(int y, int x, int type);

	void updateMapOnly();

	void updateTime(int y, int x, int type);

	void statsMap();

	void initMap(final int height, final int width);

}
