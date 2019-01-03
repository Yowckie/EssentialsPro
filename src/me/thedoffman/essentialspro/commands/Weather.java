package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Weather implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
    public Weather(Main plugin) {
        Bukkit.getPluginCommand("weather").setExecutor(this);
    }

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
		
		if (cmd.getName().equalsIgnoreCase("weather"))
			if(sender instanceof Player){
				Player player = (Player) sender;
		{
		    if(args.length == 0)
		    {
		    	player.sendMessage(plugin.prefix + ChatColor.RED + "usage: /weather [clear:rain]");
		    }
		    else if(args.length == 1)
		    {
		        if(args[0].equalsIgnoreCase("clear"))
		        {
		            Bukkit.getWorld("world").setStorm(false);
		            player.sendMessage(plugin.prefix + ChatColor.GRAY + "Weather set to" + ChatColor.DARK_GREEN + " Clear");
		        }
		        else if(args[0].equalsIgnoreCase("rain"))
		        {
		            Bukkit.getWorld("world").setStorm(true);
		            player.sendMessage(plugin.prefix + ChatColor.GRAY + "Time set to" + ChatColor.DARK_GREEN + " Rain");
		        }
		        else
		        {
		            player.sendMessage(plugin.prefix + ChatColor.RED + "usage: /weather [clear:rain]");
		            return true;
		        }
		    }
		}
			}
		return true;

}
}

