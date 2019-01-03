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

public class Home implements CommandExecutor {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
    public Home(Main plugin) {
        Bukkit.getPluginCommand("home").setExecutor(this);
        Bukkit.getPluginCommand("sethome").setExecutor(this);
        Bukkit.getPluginCommand("delhome").setExecutor(this);
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){   	
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
        Player p = (Player) sender;
        
        if (cmd.getName().equalsIgnoreCase("home")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can go home!");
                return true;
        }
            
            if (args.length == 0) {
                p.sendMessage(plugin.prefix + ChatColor.RED + "Use: /home <Name>");
                return true;
              }
            if (plugin.getplayers().getConfigurationSection(p.getName() + ".homes." + args[0]) == null) {
                    p.sendMessage(plugin.prefix + ChatColor.RED + "Home " + args[0] + " does not exist!");
                    return true;
            }
            World w = Bukkit.getServer().getWorld(plugin.getplayers().getString(p.getName() + ".homes." + args[0] + ".world"));
            double x = plugin.getplayers().getDouble(p.getName() + ".homes." + args[0] + ".x");
            double y = plugin.getplayers().getDouble(p.getName() + ".homes." + args[0] + ".y");
            double z = plugin.getplayers().getDouble(p.getName() + ".homes." + args[0] + ".z");
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(plugin.prefix + ChatColor.BLUE + "Welcome to " + ChatColor.GREEN + args[0] + ChatColor.BLUE + "!");
    }
        if (cmd.getName().equalsIgnoreCase("sethome")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can set a home!");
                return true;
        }
            if (args.length == 0) {
            	p.sendMessage(plugin.prefix + ChatColor.RED + "Use: /sethome <Name>");
                    return true;
            }
            plugin.getplayers().set(p.getName() + ".homes." + args[0] + ".world", p.getLocation().getWorld().getName());
            plugin.getplayers().set(p.getName() + ".homes." + args[0] + ".x", p.getLocation().getX());
            plugin.getplayers().set(p.getName() + ".homes." + args[0] + ".y", p.getLocation().getY());
            plugin.getplayers().set(p.getName() + ".homes." + args[0] + ".z", p.getLocation().getZ());
            plugin.saveYamls();
            p.sendMessage(plugin.prefix + ChatColor.BLUE + "Home " + ChatColor.GREEN + args[0] + ChatColor.BLUE + " set!");
    }
		
        if (cmd.getName().equalsIgnoreCase("delhome")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Only players can delete a home!");
                return true;
        }
            if (args.length == 0) {
            	p.sendMessage(plugin.prefix + ChatColor.RED + "Use: /delhome <Name>");
                    return true;
            }
            if (plugin.getplayers().getConfigurationSection(p.getName() + ".homes." + args[0]) == null) {
                    sender.sendMessage(plugin.prefix + ChatColor.RED + "Home " + args[0] + " does not exist!");
                    return true;
            }
            plugin.getplayers().set(p.getName() + ".homes." + args[0], null);
            plugin.saveYamls();
            sender.sendMessage(plugin.prefix + ChatColor.GREEN + "Removed home " + args[0] + "!");
            
            return true;
            }	
	return false;
}

}
