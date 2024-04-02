package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BmdbDb {
	
	public static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb2";
		String username = "bmdb_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;
	}

}
