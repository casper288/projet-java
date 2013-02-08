/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

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
    // private final JTable table;
    @SuppressWarnings("unused")
    private final Window window;
    private final JTable table;

    /**
     * @throws SQLException
     * 
     */
    public WindowBdd(final Window window) {

	this.window = window;

	this.setTitle("Gestion donn\u00E9es");
	this.setSize(1024, 768);
	this.setLocationRelativeTo(null);
	this.getContentPane().setLayout(new BorderLayout(0, 0));
	final MapModel mapModel = new MapModel(window.getMapPan().getMap());
	// ///////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////

	JPanel panel = new JPanel();
	this.getContentPane().add(panel, BorderLayout.EAST);
	panel.setPreferredSize(new Dimension(300, 0));
	panel.setBackground(Color.LIGHT_GRAY);
	panel.setLayout(new FormLayout(new ColumnSpec[] {
		FormFactory.RELATED_GAP_COLSPEC,
		ColumnSpec.decode("max(0dlu;default)"),
		FormFactory.RELATED_GAP_COLSPEC,
		ColumnSpec.decode("max(137dlu;default)"),
		FormFactory.RELATED_GAP_COLSPEC,
		ColumnSpec.decode("max(12dlu;default)"), }, new RowSpec[] {
		FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
		FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
		FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
		FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
		FormFactory.RELATED_GAP_ROWSPEC,
		RowSpec.decode("max(331dlu;default)"),
		FormFactory.RELATED_GAP_ROWSPEC,
		RowSpec.decode("max(9dlu;default)"),
		FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));
	// ///////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////
	JButton btnNewButton = new JButton("Ecraser la sauvegarde existante");
	btnNewButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent e) {
		int ligneSelectionne = WindowBdd.this.table.getSelectedRow();
		int id = (int) WindowBdd.this.table.getValueAt(
			ligneSelectionne, 0);
		try {
		    mapModel.updateSaveMap(id);
		} catch (SQLException e1) {
		    // TODO Bloc catch généré automatiquement
		    e1.printStackTrace();
		}
		WindowBdd.this.dispose();
	    }
	});
	panel.add(btnNewButton, "4, 4");
	// ///////////////////////////////////////////////////////////////////////////
	JButton btnNewButton_1 = new JButton("Charger");
	btnNewButton_1.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent e) {
		int ligneSelectionne = WindowBdd.this.table.getSelectedRow();
		System.out.println(WindowBdd.this.table.getValueAt(
			ligneSelectionne, 0));

		// WindowBdd.this.dispose();
	    }
	});
	panel.add(btnNewButton_1, "4, 6");
	// ///////////////////////////////////////////////////////////////////////////
	JButton btnNewButton_2 = new JButton("Supprimer");
	btnNewButton_2.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent e) {
		int ligneSelectionne = WindowBdd.this.table.getSelectedRow();
		int id = (int) WindowBdd.this.table.getValueAt(
			ligneSelectionne, 0);
		try {
		    mapModel.deleteMap(id);
		} catch (SQLException e1) {
		    // TODO Bloc catch généré automatiquement
		    e1.printStackTrace();
		}
		WindowBdd.this.dispose();
	    }
	});
	panel.add(btnNewButton_2, "4, 8");
	// ///////////////////////////////////////////////////////////////////////////
	JButton btnNewButton_3 = new JButton("Annuler");
	btnNewButton_3.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent e) {
		WindowBdd.this.dispose();
	    }
	});
	panel.add(btnNewButton_3, "4, 12");
	// ///////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////

	ResultSet resultSet = null;
	try {
	    resultSet = mapModel.returnResultset();
	} catch (SQLException e1) {
	    // TODO Bloc catch généré automatiquement
	    e1.printStackTrace();
	}
	ResultSetTableModel rtm = new ResultSetTableModel(resultSet);
	// ///////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////
	this.table = new JTable(rtm);
	this.table.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(final MouseEvent arg0) {
	    }
	});
	this.table.setShowVerticalLines(true);
	this.table.setShowHorizontalLines(true);
	this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	this.table.setBorder(new EmptyBorder(10, 10, 10, 10));
	this.getContentPane().add(this.table, BorderLayout.CENTER);

    }
}
