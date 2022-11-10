package banco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
	  private Connection conexion;
	  private static final String DB_HOST = "localhost";
	  private static final String DB_PORT = "3306";
	  private static final String DB_NAME = "test";
	  private static final String DB_USER = "test";
	  private static final String DB_PASS = "test";
	  
	  public DatabaseConnection() {
		  try {
			  conexion = DriverManager.getConnection("jdbc:mysql://"+ DB_HOST + ":" +DB_PORT + "/" +DB_NAME , DB_USER, DB_PASS );
		  }catch (SQLException e) {
			  e.printStackTrace();
		  }
	  }

	  public Connection getConexion() {
		  return conexion;
	  }
}
