package Controller.Map;

import java.util.Arrays;

import View.Window;

/**
 * @see
 * 
 * @author david
 * 
 */
public class Map implements MapSoft {

	private int height = 0; // hauteur en case et pas en pixel
	private int width = 0; // largeur en case et pas en pixel
	private final int total = this.height * this.width; // Nombre total de case
	private int tab[][];
	private int tabTime[][];
	private final Window window;

	public Map(final Window window) {
		this.window = window;
	}

	public void initMap(final int height, final int width) {
		// Méthode de d'initialisation de la carte int, elle se génère a
		// l'initialisation de la carte mapPan

		this.setHeight(height); // Hauteur pour la variable locale height
		this.setWidth(width); // Largeur pour la variable locale width

		int tableau[][] = new int[height][width]; // On crée un tableau
		this.setTab(tableau); // que l'on va ensuite assigner au tableau tab qui
		// est en local
		int tableauTime[][] = new int[height][width]; // On crée un tableau pour
		// le temps
		this.setTabTime(tableauTime); // que l'on va ensuite assigner au tableau
		// tabTime qui
		// est en local
		for (int i = 1; i < height; i++) { // On construit le tableau en hauteur
			for (int j = 1; j < width; j++) { // puis en largeur
				this.tab[i][j] = 0; // en lui assignant une valeur de 0
			}
		}
		for (int i = height - 1; i < height; i++) { // On construit le tableau
													// en hauteur
			for (int j = 1; j < width; j++) { // puis en largeur
				this.tab[i][j] = 9; // en lui assignant une valeur de 0
			}
		}

		for (int i = 1; i < height; i++) { // On construit le tableau
			// en hauteur
			for (int j = width - 1; j < width; j++) { // puis en largeur
				this.tab[i][j] = 9; // en lui assignant une valeur de 0
			}
		}

		for (int i = 1; i < height; i++) { // On construit le tableau en hauteur
			// Pour temps
			for (int j = 1; j < width; j++) { // puis en largeur
				this.tabTime[i][j] = 0; // en lui assignant une valeur de 0
			}
		}

	}

	@Override
	public void updateMap(final int y, final int x, final int type) {
		// méthode pour mettre a jour la carte int, a chaque clic sur une case
		// de mapPan, cette méthode
		// est appelée avec un type numérique en paramètre

		this.tab[y][x] = type; // on récupère le tableau local, on lui donne une
		// valeur TYPE et les Y et X permettent de se
		// positionner dans le tableau
		this.setTab(this.tab); // on met a jour le tableau local grace a un set
		// sur le tableau local tab

		this.window.getMapPan().updateMapPan(this.tab);
		// appel de la fonction qui va colorier et interagir avec le tableau de
		// bouton

	}

	@Override
	public void updateTime(final int y, final int x, final int type) {
		// méthode pour mettre a jour la carte int, a chaque clic sur une case
		// de mapPan, cette méthode
		// est appelée avec un type numérique en paramètre

		this.tabTime[y][x] = type; // on récupère le tableau local, on lui donne
		// une
		// valeur TYPE et les Y et X permettent de se
		// positionner dans le tableau
		this.setTab(this.tab); // on met a jour le tableau local grace a un set
		// sur le tableau local tab

	}

	@Override
	public void updateElement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveMap() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportMap() {
		// TODO Auto-generated method stub

	}

	@Override
	public void statsMap() {
		// méthode de comptage des elements sur le tableau int
		// grace a un for qui parcoure le tableau et un switch
		// qui incrémente un autre tableau en fonction des paramètres
		// reçus dans le tableau précédent
		int typeTab[] = new int[7];
		int type = 10;
		for (int i = 1; i < this.height; i++) {
			for (int j = 1; j < this.width; j++) {

				type = this.tab[i][j];

				switch (type) {
					case 1 :
						typeTab[1] = typeTab[1] + 1;
						break;
					case 2 :
						typeTab[2] = typeTab[2] + 1;
						break;
					case 3 :
						typeTab[3] = typeTab[3] + 1;
						break;
					case 4 :
						typeTab[4] = typeTab[4] + 1;
						break;
					case 5 :
						typeTab[5] = typeTab[5] + 1;
						break;
					case 6 :
						typeTab[6] = typeTab[6] + 1;
						break;
					case 0 :
						typeTab[0] = typeTab[0] + 1;
						break;
					default :
						break;
				}
				type = 10;
			}

		}
		this.window.getInfoPan().setNumberStat(typeTab);
		// on envoie le tout sur la méthode de mise a jour des
		// labels dans le classe infoPan
	}

	@Override
	public void importMap() {
		// TODO Stub de la méthode généré automatiquement

	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getTotal() {
		return this.total;
	}

	public int[][] getTab() {
		return this.tab;
	}

	public void setTab(final int[][] tableau) {
		this.tab = tableau;
	}

	public int[][] getTabTime() {
		return this.tabTime;
	}

	public void setTabTime(final int[][] tabTime) {
		this.tabTime = tabTime;
	}

	@Override
	public void updateMapOnly() {
		this.window.getMapPan().updateMapPan(this.tab);

	}

	public String getTabOut() {
		String tabtext = Arrays.deepToString(this.tab);
		// sortie du tableau int en string avec les crochets et tout
		return tabtext;
	}

	public String getTabTimeOut() {
		String tabTimetext = Arrays.deepToString(this.tabTime);
		// sortie du tableau int de temps en string avec les crochets et tout
		return tabTimetext;
	}
}
