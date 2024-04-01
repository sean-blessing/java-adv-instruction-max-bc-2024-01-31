import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectorTestApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		try {
			Connection conn = getConnection();
			System.out.println("Success");
		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Bye");
	}
	
	private static Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/prsjava";
		String username = "prs_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		return connection;
	}

}
