package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe connexion BDD
 * 
 * @author david
 * @version 1.0
 */
public class DAO {

	private Connection connection = null;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String connectionString = "jdbc:mysql://127.0.0.1/statistiquesdb?user=prosit&password=prosit";
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

}
