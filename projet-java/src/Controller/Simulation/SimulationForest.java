package Controller.Simulation;

import View.Window;

public class SimulationForest implements Simulation {

	private int board[][];
	private int board2[][];
	private int boardState[][];

	private int height;
	private int width;
	private Window window;

	public SimulationForest(final Window window) {
		this.window = window;
		this.height = window.getMapPan().getMap().getHeight();
		this.width = window.getMapPan().getMap().getWidth();
		this.board = window.getMapPan().getMap().getTab();
		this.boardState = window.getMapPan().getMap().getTabTime();
	}

	@Override
	public void playSimulation() {

		this.board2 = this.board;

		for (int i = 1; i < this.height; i++) {

			for (int j = 1; j < this.width; j++) {

				if (this.board[i][j] == 0) {

					if (this.countNeighbors(i, j, 3) >= 2) {
						this.board2[i][j] = 1;
					}
					if (this.countNeighbors(i, j, 2) >= 3) {
						this.board2[i][j] = 1;
					}
					if ((this.countNeighbors(i, j, 3) >= 1)
							&& (this.countNeighbors(i, j, 2) >= 2)) {
						this.board2[i][j] = 1;
					}

					else {
						System.out.println("Je suis vide");
					}
				}

				else if (this.board[i][j] == 1) {
					int numberTree = this.countNeighbors(i, j, 3);
					int numberPlant = this.countNeighbors(i, j, 2);

					if ((numberTree + numberPlant) <= 3) {
						this.board2[i][j] = 2;
					}
				}

				else if (this.board[i][j] == 2) {

					if (this.boardState[i][j] == 0) {
						this.boardState[i][j]++;
					} else if (this.boardState[i][j] == 1) {
						// this.tableauEtat[i][j]--;
						this.board2[i][j] = 3;
					}
				}

				this.board = this.board2;
			}
		}

		this.window.getMapPan().getMap().setTab(this.board);
		this.window.getMapPan().getMap().updateMapOnly();
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
		}
		return numberNeighbors;

	}
}
