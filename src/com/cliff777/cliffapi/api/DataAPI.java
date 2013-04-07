package com.cliff777.cliffapi.api;

import com.cliff777.cliffapi.database.Database;

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
