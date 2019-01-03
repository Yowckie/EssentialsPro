package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Gamemode implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Gamemode(Main plugin) {
        Bukkit.getPluginCommand("gamemode").setExecutor(this);
    }

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "§");
		if (cmd.getName().equalsIgnoreCase("gamemode"))
			if(sender instanceof Player){
				Player player = (Player) sender;
		{
		    if(args.length == 0)
		    {
		        player.sendMessage(plugin.prefix + ChatColor.BLUE + "Gamemode " + ChatColor.GREEN + "0" + ChatColor.BLUE + ", " + ChatColor.GREEN + "1 " + ChatColor.BLUE + ", " + ChatColor.GREEN + "2 " + ChatColor.BLUE + "or " + ChatColor.GREEN + "3" + ChatColor.BLUE + ".");
		    }
		    else if(args.length == 1)
		    {
		        if(args[0].equalsIgnoreCase("0"))
		        {
		            player.setGameMode(GameMode.SURVIVAL);
		            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Survival");
		        }
		        else if(args[0].equalsIgnoreCase("1"))
		        {
		            player.setGameMode(GameMode.CREATIVE);
		            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Creative");
		        }
		        else if(args[0].equalsIgnoreCase("2"))
		        {
		        	player.setGameMode(GameMode.ADVENTURE);
		            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Adventure");
		        }
		        else if(args[0].equalsIgnoreCase("3"))
		        {
		        	player.setGameMode(GameMode.SPECTATOR);
		            player.sendMessage(plugin.prefix + ChatColor.BLUE + "GameMode set to" + ChatColor.GREEN + " Spectator");
		        }
		        else
		        {
		            player.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /gamemode [0:1:2:3]");
		            return true;
		        }
		    }
		}
			}
		
			else sender.sendMessage(plugin.prefix + ChatColor.RED + "Error: Command use only in game.");
		
		return true;
	}
}