package com.cliff777.mcapi.api;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.cliff777.mcapi.CliffAPI;

public class ChatAPI {
	
	public void consoleOut(String plugin, String msg) {
		CliffAPI.instance.log.info("[" + plugin + "] " + msg);
	}
	
	public void playerOut(Player p, String plugin, String msg) {
		if(msg.contains("<black>")) msg.replaceAll("<black>", ChatColor.BLACK.toString());
		if(msg.contains("<darkblue>")) msg.replaceAll("<darkblue>", ChatColor.DARK_BLUE.toString());
		if(msg.contains("<darkgreen>")) msg.replaceAll("<darkgreen>", ChatColor.DARK_GREEN.toString());
		if(msg.contains("<darkaqua>")) msg.replaceAll("<darkaqua>", ChatColor.DARK_AQUA.toString());
		if(msg.contains("<darkred>")) msg.replaceAll("<darkred>", ChatColor.DARK_RED.toString());
		if(msg.contains("<purple>")) msg.replaceAll("<purple>", ChatColor.DARK_PURPLE.toString());
		if(msg.contains("<gold>")) msg.replaceAll("<gold>", ChatColor.GOLD.toString());
		if(msg.contains("<gray>")) msg.replaceAll("<grap>", ChatColor.GRAY.toString());
		if(msg.contains("<darkgrey>")) msg.replaceAll("<darkgrey>", ChatColor.DARK_GRAY.toString());
		if(msg.contains("<blue>")) msg.replaceAll("<blue>", ChatColor.BLUE.toString());
		if(msg.contains("<green>")) msg.replaceAll("<green>", ChatColor.GREEN.toString());
		if(msg.contains("<aqua>")) msg.replaceAll("<aqua>", ChatColor.AQUA.toString());
		if(msg.contains("<red>")) msg.replaceAll("<red>", ChatColor.RED.toString());
		if(msg.contains("<lightpurple>")) msg.replaceAll("<lightpurple>", ChatColor.LIGHT_PURPLE.toString());
		if(msg.contains("<yellow>")) msg.replaceAll("<yellow>", ChatColor.YELLOW.toString());
		if(msg.contains("<white>")) msg.replaceAll("<while>", ChatColor.WHITE.toString());
		
		p.sendMessage("[" + plugin + "] " + msg);
	}

}
