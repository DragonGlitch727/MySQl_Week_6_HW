import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		
		private final static String URL = "jdbc:mysql://localhost:3306/patients";
		private final static String USERNAME = "root";
		private final static String PASSWORD = "root";
		private static Connection connection;
		
		public static Connection getConnection() {
			if (connection == null) {
				try {
					connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					System.out.println("Connected");
				} catch (SQLException e) {
					System.out.println("Failed to connect to the database.");
					e.printStackTrace();
				}
			}
			return connection;
	}

}
