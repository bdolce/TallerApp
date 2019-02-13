package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String host = "localhost";
	private String port = "3306";
	private String user = "root";
	private String password = "root";
	private String db = "taller";
	private String url = "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password+"&userUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static ConnectionFactory instancia;
	
	private ConnectionFactory() {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static ConnectionFactory getInstancia() {
		if (ConnectionFactory.instancia == null) {
			ConnectionFactory.instancia = new ConnectionFactory();
		}
		return ConnectionFactory.instancia;
	}
	
	private Connection conn;
	private int cantConn = 0;
	public Connection getCon() throws SQLException {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		cantConn++;
		return conn;
	}
	
	public void releaseConn() throws SQLException {
		try {
			cantConn--;
			if(cantConn == 0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}