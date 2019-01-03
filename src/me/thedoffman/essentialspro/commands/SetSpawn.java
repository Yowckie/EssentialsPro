package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class SetSpawn implements CommandExecutor{
	 
	private Main plugin = Main.getPlugin(Main.class);
	
    public SetSpawn(Main plugin) {
        Bukkit.getPluginCommand("setspawn").setExecutor(this);
    }

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
		
    if (cmd.getName().equalsIgnoreCase("setspawn")) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can set spawn!");
            return true;
    }
    }
        
        if (sender instanceof Player) {
        	
            String Spawn = plugin.getlang().getString("Messages.SpawnSet");
            Spawn = Spawn.replaceAll("&", "\u00A7");
            
        	Player p = (Player) sender;	
        	World world = p.getWorld();
        	Location loc = p.getLocation();
        	world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
        p.sendMessage(plugin.prefix + Spawn);
        
} 
	return false;

}

}
