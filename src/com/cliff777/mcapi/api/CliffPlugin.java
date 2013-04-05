package com.cliff777.mcapi.api;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CliffPlugin extends JavaPlugin {

	
	public void onEnable() {
		initPlugin();
		initDatabase();
		initTasks();
		initCommands();
		initListeners();
		initConfig();
	}
	
	public void onDisable() {
		
	}
	
	protected abstract void initListeners();
	
	protected abstract void initPlugin();
	
	protected abstract void initTasks();
	
	protected abstract void initCommands();
	
	protected abstract void initDatabase();	
	
	protected abstract void initConfig();
	
	
	
	
	public class CliffConfig {
		public FileConfiguration config;
		private File saveFile;
		
		public CliffConfig(FileConfiguration config, String saveLocation) {
			this.config = config;
			this.saveFile = new File(saveLocation);
		}
		
		public void saveConfig() {
			try {
				config.save(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void addDefaultValue(String path, Object value) {
			if(!config.contains(path)) {
				config.set(path, value);
			}
		}
		
		public FileConfiguration getConfig() {
			return config;
		}
		
		public String getString(String path) {
			if(config.contains(path)) {
				return config.getString(path);
			}
			return null;
		}
		
	}
}