package ch.ivantujkic.autoverkauf.dal;

import java.sql.*;

public class ConnectionUtil {

	public Connection getAConnection() throws SQLException {

		// Passwort eingeben!
		return DriverManager.getConnection(
                "jdbc:mysql://localhost/carsales?user=root&password=[PASSWORD]&useUnicode=true&characterEncoding=UTF-8");
	}

}
