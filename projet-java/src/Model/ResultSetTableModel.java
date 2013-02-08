package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ResultSetTableModel(final ResultSet resultSet) {
	this.resultSet = resultSet;

	try {
	    this.resultSetMetaData = resultSet.getMetaData();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public int getColumnCount() {
	try {
	    return this.resultSetMetaData.getColumnCount();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return 0;
	}
    }

    @Override
    public int getRowCount() {
	try {
	    this.resultSet.last();
	    return this.resultSet.getRow();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return 0;
	}
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
	try {
	    this.resultSet.absolute(rowIndex + 1);
	    return this.resultSet.getObject(columnIndex + 1);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public String getColumnName(final int column) {
	try {
	    return this.resultSetMetaData.getColumnName(column + 1);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return "";
	}
    }

    private final ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

}
