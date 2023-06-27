package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	private JdbcUtil() {
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream("src\\in\\ineuron\\util\\properties\\application.properties");

		Properties pro = new Properties();
		pro.load(fis);

		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
