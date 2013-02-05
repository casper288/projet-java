package Controller.Map;

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
    @SuppressWarnings("unused")
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

	for (int i = 1; i < height; i++) { // On construit le tableau en hauteur
	    for (int j = 1; j < width; j++) { // puis en largeur
		this.tab[i][j] = 0; // en lui assignant une valeur de 0
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

	/* fonction d'affichage du tableau en mode console */
	// for (int i = 1; i < this.height; i++) {
	// for (int j = 1; j < this.width; j++) {
	// System.out.print(this.tab[i][j] + " ");
	// }
	// System.out.println(" ");
	// }

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
    public void stats() {
	// TODO Stub de la méthode généré automatiquement

    }

    @Override
    public void importMap() {
	// TODO Auto-generated method stub

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

}
