/**
 * 
 */
package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import Model.MapModel;
import Model.ResultSetTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author Musique
 * 
 */
public class WindowBdd extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 6251650535391968723L;
    /**
     * 
     */
    private final JTable table;
    @SuppressWarnings("unused")
    private final Window window;

    /**
     * @throws SQLException
     * 
     */
    public WindowBdd(final Window window) {

	this.window = window;

	this.setTitle("Gestion donn\u00E9es");
	this.setSize(1024, 768);
	this.setLocationRelativeTo(null);
	this.getContentPane().setLayout(
		new FormLayout(new ColumnSpec[] {
			FormFactory.RELATED_GAP_COLSPEC,
			ColumnSpec.decode("default:grow"),
			FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			RowSpec.decode("default:grow"),
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC, }));
	MapModel mapModel = new MapModel(window.getMapPan().getMap());

	ResultSet resultSet = null;

	try {
	    resultSet = mapModel.returnResultset();
	} catch (SQLException e1) {
	    // TODO Bloc catch généré automatiquement
	    e1.printStackTrace();
	}
	ResultSetTableModel rtm = new ResultSetTableModel(resultSet);
	this.table = new JTable(rtm);

	this.table.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
	    }
	});
	this.getContentPane().add(this.table, "2, 2, 1, 9, fill, fill");

	JButton buttonSave = new JButton("Sauvegarder");
	buttonSave.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent arg0) {
		// savebdd();
		// refresh();
	    }
	});
	this.getContentPane().add(buttonSave, "3, 2");

	JButton buttonLoad = new JButton("Charger");
	buttonLoad.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		// loadBdd();
		// refresh();
		// updateMap();
		WindowBdd.this.dispose();
	    }
	});
	this.getContentPane().add(buttonLoad, "3, 4");

	JButton buttonDelete = new JButton("Supprimer");
	buttonDelete.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		// deletebdd();
		// refresh();
		// updateMap();
	    }
	});
	this.getContentPane().add(buttonDelete, "3, 6");

	JButton buttonCancel = new JButton("Annuler");
	buttonCancel.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		WindowBdd.this.dispose();
	    }
	});
	this.getContentPane().add(buttonCancel, "3, 10");
	// TODO Stub du constructeur généré automatiquement*/
    }
}
