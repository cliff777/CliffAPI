package com.cliff777.mcapi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.cliff777.mcapi.CliffAPI;

public class Database {
	
	private Connection conn;
	

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Failed to load mysql driver");
			e.printStackTrace();
		}
		
		connect();
	}
	
	private void connect() {
		try {
			conn = DriverManager.getConnection(this.connectionURL());
		} catch (SQLException e) {
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Cannot connect to mysql server...have you entered the mysql server address, username, and password to the config?");
			e.printStackTrace();
		}
	}
	                       
	
	public boolean write(String sql, Object[] args) {
		validateConnection();
		try {
			for(Object o : args) {
				sql.replace("?", "`" + o.toString() + "`");
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private String connectionURL() {
		return "jdbc:mysql://" 
		+ CliffAPI.instance.config.getString(CliffAPI.MYSQL_ADDRESS) + ":"
		+ CliffAPI.instance.config.getString(CliffAPI.MYSQL_PORT) + "/"
		+ CliffAPI.instance.config.getString(CliffAPI.MYSQL_DATABASE) + "?user="
		+ CliffAPI.instance.config.getString(CliffAPI.MYSQL_USER) + "&pass="
		+ CliffAPI.instance.config.getString(CliffAPI.MYSQL_PASSWORD);
	}
	
	private void validateConnection() {
		try {
			if(!this.conn.isValid(5)) {
				connect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Results read(String sql, Object[] args) {
		try {
			for(Object o : args) {
				sql.replace("?", "`" + o.toString() + "`");
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ResultSetMetaData data = resultSet.getMetaData();
			Results results = new Results();
			Object[] objs = new Object[data.getColumnCount()];
			
			while(resultSet.next()) {
				for(int i = 0; i < objs.length; i++) {
					objs[i] = resultSet.getObject(i);
				}
				results.addRow(new Row(objs));
			}
			
			return results;
		}catch (Exception e) {
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error getting results from mySQL with: " + sql);
			e.printStackTrace();
			return null;
		}
	}
}
