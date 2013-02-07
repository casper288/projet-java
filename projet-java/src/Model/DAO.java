package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @see
 * 
 * @author Alex,David
 * 
 */
public class DAO {

    private Connection connection = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://127.0.0.1/jsimforest?user=root&password=";
    private Statement statement = null;

    public DAO() {
	try {
	    Class.forName(this.driver);
	    this.connection = DriverManager
		    .getConnection(this.connectionString);
	    this.statement = this.connection.createStatement();
	} catch (SQLException | ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public ResultSet executeQuery(final String query) throws SQLException {
	ResultSet resultSet;
	resultSet = this.statement.executeQuery(query);
	return resultSet;
    }

    public int executeUpdate(final String query) throws SQLException {
	return this.statement.executeUpdate(query);
    }

    public void closeDAO() throws SQLException {
	this.connection.close();
	this.statement.close();
    }

    public Statement getStatement() {
	return this.statement;
    }

    public void setStatement(final Statement statement) {
	this.statement = statement;
    }

}
