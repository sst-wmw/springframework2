package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class BaseDao {
	
	private static Connection conexao;
	private static PreparedStatement statement;
	
	public static Connection getConnection() {
		// Cria conexão
		if (conexao == null) {
			try {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/controletransacao", "root", "");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return conexao;
	}
	
	public static ResultSet executeSql(String sql) {
		try {
			getConnection();
			// Prepara sql para ser executada
			statement = conexao.prepareStatement(sql);
			// Executa a sql
			statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
			return statement.getGeneratedKeys();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void beforeInsert() throws SQLException {
		conexao.setAutoCommit(false);
	}
	
	public void doInsert(Object obj) {}
	
	private void afterInsert() throws SQLException {
		conexao.commit();
	}
	
	public void executeInsertTransaction(Object obj) {
		try {
			getConnection();
			beforeInsert();
			doInsert(obj);
			afterInsert();
		} catch (SQLException e) {
			try {
				// Da rollback na transação caso aconteça algum erro.
				conexao.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(e);
		}
	}

	public static void close() {
		try {
			// Fecha conexão
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void close(ResultSet resultSet) {
		try {
			resultSet.getStatement().close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}