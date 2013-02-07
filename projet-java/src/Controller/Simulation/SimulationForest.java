package Controller.Simulation;

import View.Window;

public class SimulationForest extends Thread implements Simulation {

	private int board[][];
	private int board2[][];
	private int boardState[][];

	private int height;
	private int width;

	private Window window;

	public SimulationForest(final Window window) {
		this.window = window;
		this.height = window.getMapPan().getMap().getHeight();// 21
		this.width = window.getMapPan().getMap().getWidth();// 21
		this.board = window.getMapPan().getMap().getTab();// [21][21]
		this.boardState = window.getMapPan().getMap().getTabTime();
	}

	@Override
	public void run() {

		this.window.getManagePan().getStartButton().setEnabled(false);
		try {

			for (int l = 0; l < Integer.parseInt(this.window.getManagePan()
					.getNumberCycleSimulationTextField().getText()); l++) {

				// Exécution de la tâche
				this.board2 = this.board;

				for (int i = 1; i < (this.height - 1); i++) {

					for (int j = 1; j < (this.width - 1); j++) {

						if (this.board[i][j] == 0) {

							if (this.countNeighbors(i, j, 3) >= 2) {
								this.board2[i][j] = 1;
								continue;
							}
							if (this.countNeighbors(i, j, 2) >= 3) {
								this.board2[i][j] = 1;
								continue;
							}
							if ((this.countNeighbors(i, j, 3) >= 1)
									&& (this.countNeighbors(i, j, 2) >= 2)) {
								this.board2[i][j] = 1;
								continue;
							}

							else {
								// System.out.println("Je suis vide");
							}
							continue;
						}

						else if (this.board[i][j] == 1) {
							int numberTree = this.countNeighbors(i, j, 3);
							int numberPlant = this.countNeighbors(i, j, 2);

							if ((numberTree + numberPlant) <= 3) {
								this.board2[i][j] = 2;
								continue;
							}
							continue;
						}

						else if (this.board[i][j] == 2) {

							if (this.boardState[i][j] == 0) {
								this.boardState[i][j]++;
								continue;
							} else if (this.boardState[i][j] == 1) {
								this.boardState[i][j]--;
								this.board2[i][j] = 3;
								continue;
							}
							continue;
						}

					}
				}

				this.board = this.board2;
				this.window.getMapPan().getMap().setTab(this.board);
				this.window.getMapPan().getMap().updateMapOnly();

				int second = Integer.parseInt(this.window.getManagePan()
						.getSpeedSimulationTextField().getText());

				Thread.sleep(second); // En pause pour deux secondes
				this.window.getMapPan().getMap().statsMap();
			}

		} catch (InterruptedException exception) {
		}
		this.window.getManagePan().getStartButton().setEnabled(true);

	}

	public int countNeighbors(final int i, final int j, final int type) {

		int numberNeighbors = 0;

		if (this.board[i - 1][j - 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i][j - 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i + 1][j - 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i + 1][j] == type) {
			numberNeighbors++;
		}

		if (this.board[i + 1][j + 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i][j + 1] == type) {
			numberNeighbors++;
		}

		if (this.board[i - 1][j + 1] == type) {
			numberNeighbors++;
		}
		if (this.board[i - 1][j] == type) {
			numberNeighbors++;
		} else {

		}
		return numberNeighbors;

	}

	@Override
	public void playSimulation() {

		this.start();

	}

	public void stopSimulation() {

	}

}
