package Controller.Simulation;

public interface Simulation {

	public void playSimulation();

	public void stopSimulation();

	public int countNeighbors(final int i, final int j, final int type);

	public void copyTab();

}
