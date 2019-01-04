package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.thedoffman.essentialspro.main.Main;

public class ClearChat implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public ClearChat(Main plugin) {
        Bukkit.getPluginCommand("clearchat").setExecutor(this);
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
			
		if (cmd.getName().equalsIgnoreCase("clearchat")) {
	           int i;
	           for (i = 0; i < 100; i++)
	            Bukkit.broadcastMessage("")
		}
		
		Bukkit.broadcastMessage(plugin.getlang().getString(plugin.prefix + ChatColor.GREEN + "Chat has been cleared!"));
		
		return false;
	}
}
