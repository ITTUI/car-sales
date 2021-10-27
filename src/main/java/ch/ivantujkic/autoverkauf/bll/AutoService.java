package ch.ivantujkic.autoverkauf.bll;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ch.ivantujkic.autoverkauf.dal.ConnectionUtil;
import ch.ivantujkic.autoverkauf.dal.AutoGateway;
import ch.ivantujkic.autoverkauf.model.Auto;

public class AutoService implements AutoCloseable {

	private Connection connection;

	public AutoService() throws Exception {
		try {
			// Connection erzeugen
			ConnectionUtil connectionUtil = new ConnectionUtil();
			connection = connectionUtil.getAConnection();
		} catch (SQLException e) {
			throw new Exception("Problem for Setting up the Connection to the Database!",
					e);
		}
	}

	@Override
	public void close() throws Exception {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new Exception("Problem with Closing the Connection to the Database!",
					e);
		}
	}

	/**
	 * Sinnbefreite Business-Logik-Methode die verschiedene Manipulationen an
	 * der Auto-Tabelle innerhalb einer Transaktion vornimmt
	 */
	public void AutoOperationen() throws Exception {

		try {
			connection.setAutoCommit(false);
			AutoGateway autoGw = new AutoGateway(connection);

			/**
			 * Auto mit ID ? auslesen
			 */	
			// Auto autoFind = autoGw.readAuto(1);
			// System.out.println("Auto mit ID " + autoFind.getId() + " auslesen...");
			// System.out.println(autoFind + "\n");

			/**
			 * Neues Auto erfassen
			 */
			// System.out.println("Neues Auto in Datenbank schreiben");
			// Auto a1 = new Auto();
			// a1.setId(1);
			// Auto auto1 = new Auto("Citreon", "C1", 1999, true, 170000, 4, "grau", 7000, 500);
			// autoGw.createAuto(auto1);
			// System.out.println("Neues Auto wurde erstellt. ID: " + auto1.getId());
			// auto1 = autoGw.readAuto(auto1.getId());
			// System.out.println(auto1);


			/**
			 * Autos auslesen
			 */
			System.out.println("Alle Autos auslesen...\n");
			List<Auto> autos = autoGw.readAutos();
			for (Auto auto : autos) {
				System.out.println(auto);
			}
			System.out.println();
			
			
			/**
			 * Autos löschen/entfernen
			 */
			// Auto autoDel = autoGw.readAuto(2);
			// autoGw.deleteAuto(autoDel);
			// System.out.println("Auto " + autoDel.getId() + " wurde gelöscht!");

			connection.commit();

		} catch (SQLException e) {
			// Transaktion verwerfen
			try {
				connection.rollback();
			} catch (SQLException e2) {
				throw new Exception("Rollback failed!", e);
			}
			throw new Exception("Transaction failed!", e);
		}

	}

}
