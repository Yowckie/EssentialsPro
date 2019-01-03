package me.thedoffman.essentialspro.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Broadcast implements CommandExecutor {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
    public Broadcast(Main plugin) {
        Bukkit.getPluginCommand("broadcast").setExecutor(this);
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
		
		if (cmd.getName().equalsIgnoreCase("broadcast") && sender instanceof Player) {
			
		    if (args.length == 0) {
		    	 sender.sendMessage(plugin.prefix + ChatColor.RED + " You must have a message to broadcast, silly!");
		    }
			
		    if (args.length > 0) {
			    String broadcast = "";
			    for (String message : args) {
			        broadcast = (broadcast + message + " ");
			    }
			    Bukkit.getServer().broadcastMessage(ChatColor.DARK_BLUE + "[" + ChatColor.GREEN + "Broadcast" + ChatColor.DARK_BLUE + "] " + ChatColor.GRAY + broadcast);
			 }
		}
		return false;
	}
}
