package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PrsDbApp {

	public static void main(String[] args) {
		//String connectionUrl = "jdbc:sqlserver://localhost;databaseName=PRSDB;user=PrsUser;password=sesame;encrypt=false;";
		//String connectionUrl = "jdbc:sqlserver://artOfTesting.com/testDB","userName","password");
		//String connectionUrl = "jdbc:sqlserver://SEAN-STUDIO-LAP;database=PRSDB;Integrated Security=True;TrustServerCertificate=True;";
		String connectionUrl = "jdbc:sqlserver://localhost;databaseName=PRSDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		try {
			System.out.println("trying connection");
			//Connection conn = DriverManager.getConnection("jdbc:sqlserver://SEAN-STUDIO-LAP/PRSDB","PrsUser","sesame");
			Connection con = DriverManager.getConnection(connectionUrl);
			System.out.println("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
