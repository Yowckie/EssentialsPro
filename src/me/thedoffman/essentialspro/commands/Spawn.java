package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Spawn implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Spawn(Main plugin) {
        Bukkit.getPluginCommand("spawn").setExecutor(this);
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
		
            if (cmd.getName().equalsIgnoreCase("spawn")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can go home!");
                    return true;
            }
                
            	if (sender instanceof Player) {
            		Player p = (Player) sender; 
                if (p.getWorld().getSpawnLocation() == null) {
                	
                	String NS = plugin.getlang().getString("Messages.NoSpawn");
                    NS = NS.replaceAll("&", "§");
                    
                        p.sendMessage(plugin.prefix + NS);
                        return false;
                }
                
                String WS = plugin.getlang().getString("Messages.WelcomeSpawn");
                WS = WS.replaceAll("&", "§");
                
                p.teleport(p.getWorld().getSpawnLocation());
                p.sendMessage(plugin.prefix + WS);
        
            	}
            }
			return false;
	}

}
