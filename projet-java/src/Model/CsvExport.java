package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;

import View.Window;
import au.com.bytecode.opencsv.CSVWriter;

public class CsvExport {

    private final Window window;

    public CsvExport(final int tab[], final Window window) throws IOException {
	this.window = window;
	StringWriter sw = new StringWriter();
	CSVWriter writer = new CSVWriter(sw);

	// Write header
	String[] header = { "jeunes-pousses", "arbuste", "arbres", "feu",
		"insectes", "cendres", "vide" };
	writer.writeNext(header);

	float total = Integer.parseInt(this.window.getManagePan().getSizeMap()
		.getText())
		* Integer.parseInt(this.window.getManagePan().getSizeMap()
			.getText());

	float t1 = (tab[1] * 100f) / total;
	float t2 = (tab[2] * 100f) / total;
	float t3 = (tab[3] * 100f) / total;
	float t4 = (tab[4] * 100f) / total;
	float t5 = (tab[5] * 100f) / total;
	float t6 = (tab[6] * 100f) / total;

	float t0 = (tab[0] * 100f) / total;

	String[] data;
	data = new String[] { "" + t1 + "", "" + t2 + "", "" + t3 + "",
		"" + t4 + "", "" + t5 + "", "" + t6 + "", "" + t0 + "" };
	writer.writeNext(data);
	try {
	    writer.close();
	} catch (IOException e) {
	    // TODO Bloc catch généré automatiquement
	    e.printStackTrace();
	}

	System.out.println("Generated CSV : \n");
	System.out.println(sw.toString());
	Calendar Today = Calendar.getInstance();
	String fileName = String.valueOf(Today.get(Calendar.DAY_OF_MONTH))
		+ "-" + String.valueOf(Today.get(Calendar.MONTH)) + "-"
		+ String.valueOf(Today.get(Calendar.YEAR)) + " -- "
		+ String.valueOf(Today.get(Calendar.HOUR_OF_DAY)) + "-"
		+ String.valueOf(Today.get(Calendar.MINUTE)) + "-"
		+ String.valueOf(Today.get(Calendar.SECOND)) + ".csv";
	CSVWriter writers = new CSVWriter(new FileWriter(fileName), ',');
	String[][] entree = {
		{ "jeunes-pousses", "arbuste", "arbres", "feu", "insectes",
			"cendres", "vide" },
		{ "" + t1 + "", "" + t2 + "", "" + t3 + "", "" + t4 + "",
			"" + t5 + "", "" + t6 + "", "" + t0 + "" } };
	for (String elem[] : entree) {
	    writers.writeNext(elem);
	}
	writers.close();
    }

}
