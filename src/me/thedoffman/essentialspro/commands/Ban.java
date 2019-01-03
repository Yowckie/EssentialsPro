package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Ban implements CommandExecutor {

	private  Main plugin = Main.getPlugin(Main.class);
	
	
    public Ban(Main plugin) {
        Bukkit.getPluginCommand("ban").setExecutor(this);
    }
    
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
        if (label.equalsIgnoreCase("ban")) {
            if (!sender.hasPermission("ep.ban")) {
                sender.sendMessage(plugin.prefix + ChatColor.RED + "You do not have permission to use that command!");
                return true;
              }
            if (args.length == 0) {
                sender.sendMessage(plugin.prefix + ChatColor.RED +"Please specify a player and reason!");
            } else if (args.length == 1) {
                sender.sendMessage(plugin.prefix + ChatColor.RED +"Please specify a reason!");
            } else {
               
                	
                    StringBuilder x = new StringBuilder();

                    for (int i = 1; i < args.length; i++) {
                        x.append(args[i]+" ");
                    }
                    
                    String banner = sender.getName();

                    if (sender instanceof Player) {
                        banner = sender.getName();
                    } 
                    Player target = Bukkit.getPlayer(args[0]);
                plugin.getplayers().set(args[0] + ".banned", true);
                plugin.getplayers().set(args[0] +".reason", x.toString());
                plugin.getplayers().set(args[0] + ".banner", banner);
                plugin.saveYamls();
                Bukkit.getOfflinePlayer(args[0]).isBanned();
                
                target.kickPlayer(ChatColor.RED + "You have been banned from the server!\nBy: " + banner + "\nReason: " + x.toString());
                Bukkit.broadcastMessage(plugin.prefix + ChatColor.GREEN + args[0] + ChatColor.BLUE + " was banned from the server!");
                sender.sendMessage(plugin.prefix + ChatColor.BLUE+"Successfully banned: "+ ChatColor.GREEN + target);
                    return true;
                }
            }

        return true;
    }
}
