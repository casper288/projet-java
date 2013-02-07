package Controller.Simulation;

import View.Window;

public class SimulationFire extends Thread implements Simulation {

	private int board[][];
	private int board2[][];
	private int boardState[][];

	private int height;
	private int width;
	private Window window;

	public SimulationFire(final Window window) {
		this.window = window;
		this.height = window.getMapPan().getMap().getHeight();// 21
		this.width = window.getMapPan().getMap().getWidth();// 21
		this.board = window.getMapPan().getMap().getTab();// [21][21]
		this.boardState = window.getMapPan().getMap().getTabTime();
	}

	@Override
	public void playSimulation() {
		this.start();

	}

	@Override
	public void run() {

	}

	@Override
	public void stopSimulation() {
		// TODO Auto-generated method stub

	}

	@Override
	public int countNeighbors(final int i, final int j, final int type) {
		// TODO Auto-generated method stub
		return 0;
	}

}
