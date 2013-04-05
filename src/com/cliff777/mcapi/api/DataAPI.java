package com.cliff777.mcapi.api;

import com.cliff777.mcapi.database.Database;

public class DataAPI {
	
	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Database getMySQL() {
		return new Database();
	}

}
