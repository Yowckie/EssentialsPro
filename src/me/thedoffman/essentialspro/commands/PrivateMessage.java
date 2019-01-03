package me.thedoffman.essentialspro.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class PrivateMessage implements CommandExecutor {
	
	private static Main plugin = Main.getPlugin(Main.class);
	
    public PrivateMessage(Main plugin) {
        Bukkit.getPluginCommand("pm").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		plugin.prefix = plugin.prefix.replaceAll("&", "\u00A7");
        //Check command
        if (cmd.getName().equalsIgnoreCase("pm"))
        {
            //Check if sender is a player
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                //If there were no args included
                if (args.length == 0) //You may want to check if the length is less than 1. They may just use "/pm Name" then there would be no message
                    p.sendMessage(plugin.prefix + ChatColor.RED + "Syntax: /pm <To> <Message>");
                else
                {
 
                    @SuppressWarnings("deprecation")
					Player target = Bukkit.getPlayer(args[0]);
                    //Check if the target was found online
                    if (target != null)
                    {
                        //Combine all the args into one string
                        String message = "";
                        for (int i = 1; i != args.length; i++)
                            message += args[1] + " "; //You don't want to always grab arg[1]
 
                        target.sendMessage(plugin.prefix + ChatColor.BLUE + sender.getName() + ChatColor.WHITE + " > " + ChatColor.BLUE + "YOU " + ChatColor.WHITE + ": " + ChatColor.GREEN + message);
                    }
                    else
                        sender.sendMessage(plugin.prefix + ChatColor.RED + "ERROR: This player is not connected on the server!");
 
                }
 
            }
            //If the sender is not a player you'll want to tell them why they can't use the command
            else
                sender.sendMessage(plugin.prefix + "You're not a player");
        }
        return true;
    }
}
