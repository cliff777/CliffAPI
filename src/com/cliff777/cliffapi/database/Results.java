package com.cliff777.cliffapi.database;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import com.cliff777.cliffapi.CliffAPI;

public class Results {
	ArrayList<Row> rows = new ArrayList<Row>();
	int counter = -1;

	public boolean hasRows() {
		counter++;
		return counter <= rows.size() - 1;
	}

	public Row currentRow() {
		return rows.get(counter);
	}

	public void addRow(Row r) {
		rows.add(r);
	}

	public Array getArray(String column) {
		if(currentRow().getObject(column) instanceof Array) {
			return (Array) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Array from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}

	public BigDecimal getBigDecimal(String column) {
		if(currentRow().getObject(column) instanceof BigDecimal) {
			return (BigDecimal) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching BigDecimal from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}

	public boolean getBoolean(String column) {
		if(currentRow().getObject(column) instanceof Boolean) {
			return (Boolean) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Boolean from row " + counter + " at column " + column + " . Returning false on default...");
			return false;
		}
	}

	public byte getByte(String column) {
		if(currentRow().getObject(column) instanceof Byte) {
			return (Byte) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Byte from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}

	public Date getDate(String column) {
		if(currentRow().getObject(column) instanceof Date) {
			return (Date) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Date from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}

	public double getDouble(String column) {
		if(currentRow().getObject(column) instanceof Double) {
			return (Double) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Double from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}

	public float getFloat(String column) {
		if(currentRow().getObject(column) instanceof Float) {
			return (Float) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Float from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}

	public short getShort(String column) {
		if(currentRow().getObject(column) instanceof Short) {
			return (Short) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Short from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}

	public int getInt(String column) {
		if(currentRow().getObject(column) instanceof Integer) {
			return (Integer) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Int from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}

	public long getLong(String column) {
		if(currentRow().getObject(column) instanceof Long) {
			return (Long) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Long from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}

	public String getString(String column) {
		if(currentRow().getObject(column) instanceof String) {
			return (String) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching String from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}

	public Time getTime(String column) {
		if(currentRow().getObject(column) instanceof Time) {
			return (Time) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Time from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}

	public Timestamp getTimestamp(String column) {
		if(currentRow().getObject(column) instanceof Timestamp) {
			return (Timestamp) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Timestamp from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
}

class Row {
	HashMap<String, Object> objects;

	public Row(HashMap<String, Object> objects) {
		this.objects = objects;
	}

	public Object getObject(String column) {
		if(objects.containsKey(column)) {
			return objects.get(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Could not find column named: " + column);
			return null;
		}
	}


}
