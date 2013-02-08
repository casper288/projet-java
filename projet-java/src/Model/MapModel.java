package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controller.Map.Map;

import com.google.gson.Gson;

/**
 * @see
 * 
 * @author Alex,David
 * 
 */

public class MapModel {
    DAO dao = null;
    private final Map map;

    public MapModel(final Map map) {
	this.dao = new DAO();
	this.map = map;
    }

    public void selectAll() throws SQLException {

	String query = "SELECT * FROM MAP";
	ResultSet resultSet = this.dao.executeQuery(query);
	while (resultSet.next()) {
	    String var = resultSet.getString("ID");
	    String var1 = resultSet.getString("TAB_TYPE");
	    String var2 = resultSet.getString("TAB_TIME");
	    String var3 = resultSet.getString("CUR_DATE");
	    System.out.println(var + " -- " + var1 + " -- " + var2 + " -- "
		    + var3);
	    // simple fonction d'affichage de des donn�es de la table MAP pour
	    // le debug et les test
	}

    }

    public ResultSet returnResultset() throws SQLException {

	String query = "SELECT ID, Cur_Date FROM MAP";
	ResultSet resultSet = this.dao.executeQuery(query);
	return resultSet;
    }

    public void saveMap() throws SQLException {
	SimpleDateFormat formater = null;
	// initialisation de la variable de type Simple date format
	Date aujourdhui = new Date();
	// instance de la date
	formater = new SimpleDateFormat("dd/MM/yy - hh:mm:ss");
	// mise en format de la date
	String tab = this.map.getTabOut();
	// r�cup�ration du tableau int
	String tab1 = this.map.getTabTimeOut();
	// r�cup�ration du tableau int de temps
	String date = formater.format(aujourdhui);// r�cup�ration de la date
	this.dao.executeUpdate("INSERT INTO map (TAB_TYPE,TAB_TIME,CUR_DATE) VALUES ('"
		+ tab + "','" + tab1 + "','" + date + "')");
	// execution de la requete d'insert de la carte en base de donn�es
    }

    public void updateSaveMap(final int id) throws SQLException {
	SimpleDateFormat formater = null;
	// initialisation de la variable de type Simple date format
	Date aujourdhui = new Date();
	// instance de la date
	formater = new SimpleDateFormat("dd/MM/yy - hh:mm:ss");
	// mise en format de la date
	String tab = this.map.getTabOut();
	// r�cup�ration du tableau int
	String tab1 = this.map.getTabTimeOut();
	// r�cup�ration du tableau int de temps
	String date = formater.format(aujourdhui);// r�cup�ration de la date
	this.dao.executeUpdate("UPDATE map SET TAB_TYPE = '" + tab
		+ "',TAB_TIME = '" + tab1 + "' ,CUR_DATE = '" + date
		+ "' WHERE ID = '" + id + "' ;");
	// execution de la requ�te d'update de la carte en base de donn�es
    }

    public void deleteMap(final int id) throws SQLException {
	this.dao.executeUpdate("DELETE FROM map WHERE ID = '" + id + "';");
    }

    public void loadMap(final int id) throws SQLException {
	String query = "SELECT * FROM MAP WHERE ID = '" + id + "'";
	ResultSet resultSet = this.dao.executeQuery(query);
	while (resultSet.next()) {
	    Gson gson = new Gson();
	    int[][] dataMap = gson.fromJson(resultSet.getString("TAB_TYPE"),
		    int[][].class);
	    int[][] dataMapTime = gson.fromJson(
		    resultSet.getString("TAB_TIME"), int[][].class);
	    this.map.setTab(dataMap);
	    this.map.setTabTime(dataMapTime);
	    this.map.updateAllMap();
	}
    }
}
