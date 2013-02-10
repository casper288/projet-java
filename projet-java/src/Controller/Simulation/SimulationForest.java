package Controller.Simulation;

import View.Window;

public class SimulationForest extends Thread implements Simulation {

	private int board[][];
	private int board2[][];
	private int boardState[][];

	private int height;
	private int width;
	private boolean stop;
	private Window window;

	public SimulationForest(final Window window) {
		this.window = window;
		this.height = window.getMapPan().getMap().getHeight();// 21
		this.width = window.getMapPan().getMap().getWidth();// 21
		this.board = window.getMapPan().getMap().getTab();// [21][21]
		this.boardState = window.getMapPan().getMap().getTabTime();
		this.board2 = new int[this.height][this.width];
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
					if (this.stop == true) {
						break;
					}
				}

				// System.out.println(this.board + " ------- " + this.board2);

				this.copyTab2();

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
		this.stop = false;
		this.start();

	}

	@Override
	public void stopSimulation() {
		this.stop = true;
		this.window.getManagePan().getStartButton().setText("Démarrer");
	}

	@Override
	public void copyTab() {

		for (int i = 1; i < (this.height - 1); i++) {

			for (int j = 1; j < (this.width - 1); j++) {

				this.board2[i][j] = this.board[i][j];

			}
		}

	}

	public void copyTab2() {

		for (int i = 1; i < (this.height - 1); i++) {

			for (int j = 1; j < (this.width - 1); j++) {

				this.board[i][j] = this.board2[i][j];

			}
		}

	}

}
