package br.com.wmw.springframework.connection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MySQLDataSource implements DataSource {

	  static {
		  try {
			new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }

	  protected String description = "MySQL Data Source";

	  protected String serverName;

	  protected int portNumber;

	  protected String databaseName;

	  public MySQLDataSource(String sid) {
		    setDatabaseName(sid);
		  }

	  public MySQLDataSource(String host, int port, String sid) {
	    setServerName(host);
	    setPortNumber(port);
	    setDatabaseName(sid);
	  }

	  public String getDescription() {
	    return description;
	  }

	  public void setDescription(String desc) {
	    description = desc;
	  }

	  public String getServerName() {
	    return serverName;
	  }

	  public void setServerName(String name) {
	    serverName = name;
	  }

	  public int getPortNumber() {
	    return portNumber;
	  }

	  public void setPortNumber(int port) {
	    portNumber = port;
	  }

	  public String getDatabaseName() {
	    return databaseName;
	  }

	  public void setDatabaseName(String name) {
	    databaseName = name;
	  }

	  public Connection getConnection() throws SQLException {
	    return getConnection("root", "sql");
	  }

	  public Connection getConnection(String userid, String password) throws SQLException {
		  String url = String.format("jdbc:mysql://%s:%s/%s", serverName, portNumber, databaseName);
		  return DriverManager.getConnection(url, userid, password);
	  }

	  public int getLoginTimeout() throws SQLException {
	    return DriverManager.getLoginTimeout();
	  }

	  public PrintWriter getLogWriter() throws SQLException {
	    return DriverManager.getLogWriter();
	  }

	  public void setLoginTimeout(int timeout) throws SQLException {
	    DriverManager.setLoginTimeout(timeout);
	  }

	  public void setLogWriter(PrintWriter writer) throws SQLException {
	    DriverManager.setLogWriter(writer);
	  }

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return Logger.getLogger(this.getClass().getSimpleName());
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	}
