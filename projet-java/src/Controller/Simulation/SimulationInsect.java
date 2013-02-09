package Controller.Simulation;

import View.Window;

public class SimulationInsect extends Thread implements Simulation {

	private int board[][];
	private int board2[][];
	private int boardState[][];

	private int height;
	private int width;
	private Window window;
	private boolean stop;

	public SimulationInsect(final Window window) {
		this.window = window;
		this.height = window.getMapPan().getMap().getHeight();// 21
		this.width = window.getMapPan().getMap().getWidth();// 21
		this.board = window.getMapPan().getMap().getTab();// [21][21]
		this.boardState = window.getMapPan().getMap().getTabTime();
		this.board2 = new int[this.height][this.width];
	}

	@Override
	public void playSimulation() {
		this.stop = false;
		this.start();

	}

	@Override
	public void run() {
		try {
			for (int l = 0; l < Integer.parseInt(this.window.getManagePan()
					.getNumberCycleSimulationTextField().getText()); l++) {

				// Exécution de la tâche
				// this.board2 = this.board.clone();
				this.copyTab();

				for (int i = 1; i < (this.height - 1); i++) {

					for (int j = 1; j < (this.width - 1); j++) {

						if (this.board[i][j] == 1) {

							if ((this.countNeighbors(i, j, 5) > 0)
									&& (((Math.random() * (100 - 0)) + 1) <= 75)) {

								this.board2[i][j] = 5;
								continue;
							}
							continue;
						}

						else if ((this.board[i][j] == 2)
								&& (((Math.random() * (100 - 0)) + 1) <= 50)) {

							if (this.countNeighbors(i, j, 5) > 0) {
								this.board2[i][j] = 5;
								continue;
							}
							continue;
						}

						else if ((this.board[i][j] == 3)
								&& (((Math.random() * (100 - 0)) + 1) <= 25)) {

							if (this.countNeighbors(i, j, 5) > 0) {
								this.board2[i][j] = 5;
								continue;
							}
							continue;
						}

						else if (this.board[i][j] == 5) {

							this.board2[i][j] = 0;
							continue;
						}

					}
					if (this.stop == true) {
						break;
					}
				}

				// System.out.println(this.board + " ------- " + this.board2);

				this.board = this.board2.clone();
				this.window.getMapPan().getMap().setTab(this.board);
				this.window.getMapPan().getMap().updateMapOnly();

				int second = Integer.parseInt(this.window.getManagePan()
						.getSpeedSimulationTextField().getText());

				Thread.sleep(second); // En pause pour deux secondes
				this.window.getMapPan().getMap().statsMap();

				if (this.stop == true) {
					break;
				}
			}

		} catch (InterruptedException exception) {
		}

		this.stopSimulation();

	}

	@Override
	public void stopSimulation() {
		this.stop = true;
		this.window.getManagePan().getStartButton().setText("Démarrer");

	}

	@Override
	public int countNeighbors(final int i, final int j, final int type) {
		int numberNeighbors = 0;

		if (this.board[i][j - 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i + 1][j] == type) {
			numberNeighbors++;
		}

		if (this.board[i][j + 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i - 1][j] == type) {
			numberNeighbors++;
		} else {

		}
		return numberNeighbors;

	}

	@Override
	public void copyTab() {
		for (int i = 1; i < (this.height - 1); i++) {

			for (int j = 1; j < (this.width - 1); j++) {

				this.board2[i][j] = this.board[i][j];

			}
		}

	}

}
