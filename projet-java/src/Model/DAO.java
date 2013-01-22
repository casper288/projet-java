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

	private static Connection connection = null;
	private final String driver = "com.mysql.jdbc.Driver";
	private final String connectionString = "jdbc:mysql://127.0.0.1/statistiquesdb?user=prosit&password=prosit";
	private Statement statement = null;

	public DAO() {
		try {
			Class.forName(this.driver);
			DAO.connection = DriverManager.getConnection(this.connectionString);
			this.statement = DAO.connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(final String query) {

		ResultSet resultSet;

		try {
			resultSet = this.statement.executeQuery(query);
		} catch (SQLException e) {
			return null;
		}

		return resultSet;
	}

}
