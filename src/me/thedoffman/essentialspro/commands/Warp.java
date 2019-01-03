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

public class Warp implements CommandExecutor {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
    public Warp(Main plugin) {
        Bukkit.getPluginCommand("warp").setExecutor(this);
        Bukkit.getPluginCommand("setwarp").setExecutor(this);
        Bukkit.getPluginCommand("delwarp").setExecutor(this);
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
		
    	
        Player p = (Player) sender;
        
        if (cmd.getName().equalsIgnoreCase("warp")) {
            if (!p.hasPermission("ep.warp")) {
                p.sendMessage(plugin.prefix + ChatColor.RED + "You do not have permission to use this command!");
                return true;
            }
            if (args.length == 0) {
            	p.sendMessage(plugin.prefix + ChatColor.RED + "Use: /warp <Name>");
                    return true;
            }
            if (plugin.getwarps().getConfigurationSection("warps." + args[0]) == null) {
                    p.sendMessage(ChatColor.RED + "Warp " + args[0] + " does not exist!");
                    return true;
            }
            World w = Bukkit.getServer().getWorld(plugin.getwarps().getString("warps." + args[0] + ".world"));
            double x = plugin.getwarps().getDouble("warps." + args[0] + ".x");
            double y = plugin.getwarps().getDouble("warps." + args[0] + ".y");
            double z = plugin.getwarps().getDouble("warps." + args[0] + ".z");
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(ChatColor.GREEN + "Teleported to " + args[0] + "!");
    }
        if (cmd.getName().equalsIgnoreCase("setwarp")) {
            if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Please specify a name!");
                    return true;
            }
            plugin.getwarps().set("warps." + args[0] + ".world", p.getLocation().getWorld().getName());
            plugin.getwarps().set("warps." + args[0] + ".x", p.getLocation().getX());
            plugin.getwarps().set("warps." + args[0] + ".y", p.getLocation().getY());
            plugin.getwarps().set("warps." + args[0] + ".z", p.getLocation().getZ());
            plugin.saveYamls();
            p.sendMessage(plugin.prefix + ChatColor.GREEN + "Warp " + args[0] + " set!");
    }
		
        if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Please specify a warp name!");
                    return true;
            }
            if (plugin.getwarps().getConfigurationSection("warps." + args[0]) == null) {
                    sender.sendMessage(ChatColor.RED + "Warp " + args[0] + " does not exist!");
                    return true;
            }
            plugin.getwarps().set("warps." + args[0], null);
            plugin.saveYamls();
            sender.sendMessage(ChatColor.GREEN + "Removed warp " + args[0] + "!");
            
            return true;
            }	
	return false;
}

}
