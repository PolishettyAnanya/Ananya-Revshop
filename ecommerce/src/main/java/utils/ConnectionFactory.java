package utils;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static final ConnectionFactory cf= new ConnectionFactory();

		private Properties ps=new Properties();
		ConnectionFactory ()
		{
			try
			{
				ps.load(new FileReader("C:\\revature\\RevShop\\src\\main\\resources\\db.properties"));
			}
			catch(IOException e)
			{
				
				e.printStackTrace();	
			}
		}
		
		public static ConnectionFactory getConnectionFactory() {
			return cf;
		}
		
		public Connection getConnection() {
			
			try {
				//Class.forName("com.mysql.jdbc.Driver") can be ignored
				return DriverManager.getConnection(
						ps.getProperty("url"),
						ps.getProperty("username"),
						ps.getProperty("password")
						);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
			
		}
		
		
		

	}