package com.cliff777.mcapi.database;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.cliff777.mcapi.CliffAPI;

public class Results {
	ArrayList<Row> rows = new ArrayList<Row>();
	int counter = 0;
	
	public boolean hasRows() {
		return counter <= rows.size() - 1;
	}
	
	public Row currentRow() {
		return rows.get(counter);
	}
	
	public void next() {
		counter++;
	}
	
	public void addRow(Row r) {
		rows.add(r);
	}
	
	public Array getArray(int column) {
		if(currentRow().getObject(column) instanceof Array) {
			return (Array) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Array from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
	
	public BigDecimal getBigDecimal(int column) {
		if(currentRow().getObject(column) instanceof BigDecimal) {
			return (BigDecimal) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching BigDecimal from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
	
	public boolean getBoolean(int column) {
		if(currentRow().getObject(column) instanceof Boolean) {
			return (Boolean) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Boolean from row " + counter + " at column " + column + " . Returning false on default...");
			return false;
		}
	}
	
	public byte getByte(int column) {
		if(currentRow().getObject(column) instanceof Byte) {
			return (Byte) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Byte from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}
	
	public Date getDate(int column) {
		if(currentRow().getObject(column) instanceof Date) {
			return (Date) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Date from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
	
	public double getDouble(int column) {
		if(currentRow().getObject(column) instanceof Double) {
			return (Double) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Double from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}
	
	public float getFloat(int column) {
		if(currentRow().getObject(column) instanceof Float) {
			return (Float) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Float from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}
	
	public short getShort(int column) {
		if(currentRow().getObject(column) instanceof Short) {
			return (Short) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Short from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}
	
	public int getInt(int column) {
		if(currentRow().getObject(column) instanceof Integer) {
			return (Integer) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Int from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}
	
	public long getLong(int column) {
		if(currentRow().getObject(column) instanceof Long) {
			return (Long) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Long from row " + counter + " at column " + column + " . Returning 0 on default...");
			return 0;
		}
	}
	
	public String getString(int column) {
		if(currentRow().getObject(column) instanceof String) {
			return (String) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching String from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
	
	public Time getTime(int column) {
		if(currentRow().getObject(column) instanceof Time) {
			return (Time) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Time from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
	
	public Timestamp getTimestamp(int column) {
		if(currentRow().getObject(column) instanceof Timestamp) {
			return (Timestamp) currentRow().getObject(column);
		}else{
			CliffAPI.getAPI().getChatAPI().consoleOut("CliffAPI", "Error fetching Timestamp from row " + counter + " at column " + column + " . Returning null on default...");
			return null;
		}
	}
}

class Row {
	Object[] objects;
	
	public Row(Object[] objects) {
		this.objects = objects;
	}
	
	public Object getObject(int column) {
		return objects[column];
	}
	                           
	
}
