package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.thedoffman.essentialspro.main.Main;

public class UnBan implements CommandExecutor {
	
    public UnBan(Main plugin) {
        Bukkit.getPluginCommand("unban").setExecutor(this);
    }

	private Main plugin = Main.getPlugin(Main.class);
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
		
        if (cmd.getName().equalsIgnoreCase("unban")) {
            if (args.length == 0) {
                    sender.sendMessage(plugin.prefix + ChatColor.RED + "Please specify a player name!");
                    return true;
            }
            if (plugin.getplayers().getBoolean(args[0] + ".banned") == false) {
                    sender.sendMessage(plugin.prefix + ChatColor.RED + "Player " + args[0] + " is not banned!");
                    return true;
            }
            plugin.getplayers().set(args[0] + ".banned", false);
            plugin.saveYamls();
            sender.sendMessage(plugin.prefix + ChatColor.GREEN + "Unbaned " + args[0] + "!");
            }	
	return true;
	}
}
