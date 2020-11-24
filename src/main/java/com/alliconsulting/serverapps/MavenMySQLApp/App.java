package com.alliconsulting.serverapps.MavenMySQLApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.ResultSet;

// assume that conn is an already created JDBC connection (see previous examples)
public class App {

	Statement stmt = null;
	ResultSet rs = null;

	Connection conn = null;

	public App() {
		try {
			// conn =
			// DriverManager.getConnection("jdbc:mysql://fittrack-2.chtih7naqeff.us-east-2.rds.amazonaws.com:3306?"
			// + "user=fitTrack&password=Hinteen172016*#&&%$");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/localdb?" + "user=root&password=mc68b09e");

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM person");

			// or alternatively, if you don't know ahead of time that
			// the query will be a SELECT...

			if (stmt.execute("SELECT * FROM person")) {
				rs = stmt.getResultSet();
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
	}

	public static void main(String[] args) {
		App app = new App();
	}

}
