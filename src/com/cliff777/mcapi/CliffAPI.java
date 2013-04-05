package com.cliff777.mcapi;

import java.io.File;
import java.util.logging.Logger;

import com.cliff777.mcapi.api.ChatAPI;
import com.cliff777.mcapi.api.CliffPlugin;
import com.cliff777.mcapi.api.DataAPI;

public class CliffAPI extends CliffPlugin {
	public static CliffAPI instance;
	public Logger log;
	private static API api;
	public CliffConfig config;
	
	public static final String MYSQL_ADDRESS = "mysql.address";
	public static final String MYSQL_PORT = "mysql.port";
	public static final String MYSQL_USER = "mysql.username";
	public static final String MYSQL_PASSWORD = "mysql.password";
	public static final String MYSQL_DATABASE = "mysql.database";
	
	@Override
	protected void initListeners() {
		
	}

	@Override
	protected void initPlugin() {
		instance = this;
		api = new API();
		log = Logger.getLogger("Minecraft");
	}

	@Override
	protected void initTasks() {

	}

	@Override
	protected void initCommands() {

	}

	@Override
	protected void initDatabase() {

	}
	
	@Override
	protected void initConfig() {
		config = new CliffConfig(getConfig(), this.getDataFolder() + File.separator + "config.yml");
		config.addDefaultValue("mysql.address", "localhost");
		config.addDefaultValue("mysql.port", 3306);
		config.addDefaultValue("mysql.username", "root");
		config.addDefaultValue("mysql.password", "root");
		config.addDefaultValue("mysql.database", "cliff");
	}

	public static API getAPI() {
		return api;
	}

	public class API {

		public API() {
			
		}
		
		public ChatAPI getChatAPI() {
			return new ChatAPI();
		}
		
		public DataAPI getDataAPI() {
			return new DataAPI();
		}
	}
}
