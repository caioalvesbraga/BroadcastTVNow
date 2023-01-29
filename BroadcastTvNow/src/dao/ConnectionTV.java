package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A classe ConnectionTV é a classe de conexão entre o Banco de Dados e as classes Data Access Object
 * @author Caio Alves Braga
 *
 */
public class ConnectionTV {
	
	/**
	 * Realiza a conexão com o Banco de dados MySQL 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tv?useSSL=false", "root", "2412Lulu.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
