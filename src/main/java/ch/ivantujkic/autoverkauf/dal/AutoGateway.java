package ch.ivantujkic.autoverkauf.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.ivantujkic.autoverkauf.model.Auto;

public class AutoGateway {

	private Connection connection;

	public AutoGateway(Connection connection) {
		this.connection = connection;
	}

	public void createAuto(Auto auto) throws SQLException {
		String idStatement = "SELECT MAX(autoid)+1 AS newid FROM car_information";
		Statement statment = connection.createStatement();
		ResultSet rstId = statment.executeQuery(idStatement);
		rstId.next();
		auto.setId(rstId.getInt("newid"));
		statment.close();

        String sql = 
        "INSERT INTO car_information (autoid, automarke, automodell, jahrgang, occassion, distanz, anz_sitzplaetze, farbe, preis, rabatt)" +
        " values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		perpareAutoStatement(auto, preparedStatement);

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	
	
	public Auto readAuto(int autoid) throws SQLException {
		String sql = "SELECT autoid, automarke, automodell, jahrgang, occassion, distanz, anz_sitzplaetze, farbe, preis, rabatt" +
				" FROM car_information WHERE autoid = " + autoid;
		return getAutoListFromQuery(sql).get(0);
	}

	public List<Auto> readAutos() throws SQLException {
		String sql = "SELECT autoid, automarke, automodell, jahrgang, occassion, distanz, anz_sitzplaetze, farbe, preis, rabatt" +
				" FROM car_information ORDER BY autoid";
		return getAutoListFromQuery(sql);
	}
	
	public void updateAuto(Auto auto) throws SQLException {
        String sql = "UPDATE car_information set autoid=?, automarke=?, automodell=?, jahrgang=?, occassion=?, distanz=?, anz_sitzplaetze=?" + 
        "farbe=?, preis=?, rabatt=? WHERE autoid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		perpareAutoStatement(auto, preparedStatement);
		
		// Add ID for WHERE-Clause
		preparedStatement.setInt(10, auto.getId());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public void deleteAuto(Auto auto) throws SQLException {
		String sql = "DELETE FROM car_information where autoid=" + auto.getId();
		Statement statment = connection.createStatement();
		statment.executeUpdate(sql);
		statment.close();
	}
	
	private void perpareAutoStatement(Auto auto, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setInt(1, auto.getId());
		preparedStatement.setString(2, auto.getAutomarke());
		preparedStatement.setString(3, auto.getAutomodell());
		preparedStatement.setInt(4, auto.getJahrgang());
		if (auto.isOccassion()) {
			preparedStatement.setInt(5, 1);
		} else {
			preparedStatement.setInt(5, 0);
        }
		preparedStatement.setInt(6, auto.getDistanz());
		preparedStatement.setInt(7, auto.getAnzahlSitzplaetze());
        preparedStatement.setString(8, auto.getFarbe());
        preparedStatement.setInt(9, auto.getPreis());
        preparedStatement.setInt(10, auto.getRabatt());
        
	}

	private List<Auto> getAutoListFromQuery(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<Auto> autoList = new ArrayList<Auto>();
		while (resultSet.next()) {
			Auto a = new Auto();
			a.setId(resultSet.getInt("autoid"));
			a.setAutomarke(resultSet.getString("automarke"));
			a.setAutomodell(resultSet.getString("automodell"));
            a.setJahrgang(resultSet.getInt("jahrgang"));
            if (resultSet.getInt("occassion") == 1) {
				a.setOccassion(true);
			} else {
				a.setOccassion(false);
			}
            a.setDistanz(resultSet.getInt("distanz"));
            a.setDistanz(resultSet.getInt("anz_sitzplaetze"));
            a.setFarbe(resultSet.getString("farbe"));
            a.setPreis(resultSet.getInt("preis"));
            a.setRabatt(resultSet.getInt("rabatt"));
			autoList.add(a);
		}
		statement.close();
		return autoList;
	}

}
