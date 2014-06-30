package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	
	private static Connection con;
	private static PreparedStatement stmt;
	
	public static ResultSet executeSql(String sql) {
		try {
			getConnection();
			// Prepara sql para ser executada
			stmt = con.prepareStatement(sql);
			// Executa a sql
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		// Cria conexão
		if (con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/controletransacao", "root", "");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return con;
	}
	
	public void executeInsertTransaction() {
		try {
			con.setAutoCommit(false);
			beforeCommit();
			con.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void beforeCommit() {
		// Lógica executada dentro de uma transação
	}
	
	public static void close() {
		try {
			// Fecha conexão
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.getStatement().close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}