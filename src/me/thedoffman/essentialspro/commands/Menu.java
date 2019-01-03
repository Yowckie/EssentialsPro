package me.thedoffman.essentialspro.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thedoffman.essentialspro.main.Main;

public class Menu implements CommandExecutor {
	
    public Menu(Main plugin) {
        Bukkit.getPluginCommand("essentialspro").setExecutor(this);
    }

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("essentialspro")){
            player.sendMessage(ChatColor.GREEN + "--------------[" + ChatColor.BLUE + "EssentialsPro Command List" + ChatColor.GREEN + "]--------------");
            player.sendMessage("");
            player.sendMessage(ChatColor.GREEN + "/heal - " + ChatColor.BLUE + "Heal yourself or another player.");
            player.sendMessage(ChatColor.GREEN + "/feed - " + ChatColor.BLUE + "Feed yourself or another player.");
            player.sendMessage(ChatColor.GREEN + "/clearchat - " + ChatColor.BLUE + "Globally clear chat.");
            player.sendMessage(ChatColor.GREEN + "/teleport - " + ChatColor.BLUE + "Teleport to another player.");
            player.sendMessage(ChatColor.GREEN + "/gamemode - " + ChatColor.BLUE + "Change you gamemode between Survival, Creative and Adventure.");
            player.sendMessage(ChatColor.GREEN + "/spawn - " + ChatColor.BLUE + "Sends you to spawn.");
            player.sendMessage(ChatColor.GREEN + "/setspawn - " + ChatColor.BLUE + "Set the spawn location.");
            player.sendMessage(ChatColor.GREEN + "/ci - " + ChatColor.BLUE + "Clears players inventory.");
            player.sendMessage(ChatColor.BLUE + "Page " + ChatColor.GREEN + "1 " + ChatColor.BLUE + "of " + ChatColor.GREEN + "4");
                if (args.length > 0){
                 if (args[0].equalsIgnoreCase("1")){
                    	// 19 lines
                     player.sendMessage(ChatColor.GREEN + "--------------[" + ChatColor.BLUE + "EssentialsPro Command List" + ChatColor.GREEN + "]--------------");
                        player.sendMessage("");
                        player.sendMessage(ChatColor.GREEN + "/heal - " + ChatColor.BLUE + "Heal yourself or another player.");
                        player.sendMessage(ChatColor.GREEN + "/feed - " + ChatColor.BLUE + "Feed yourself or another player.");
                        player.sendMessage(ChatColor.GREEN + "/clearchat - " + ChatColor.BLUE + "Globally clear chat.");
                        player.sendMessage(ChatColor.GREEN + "/teleport - " + ChatColor.BLUE + "Teleport to another player.");
                        player.sendMessage(ChatColor.GREEN + "/gamemode - " + ChatColor.BLUE + "Change you gamemode between Survival, Creative and Adventure.");
                        player.sendMessage(ChatColor.GREEN + "/spawn - " + ChatColor.BLUE + "Sends you to spawn.");
                        player.sendMessage(ChatColor.GREEN + "/setspawn - " + ChatColor.BLUE + "Set the spawn location.");
                        player.sendMessage(ChatColor.GREEN + "/ci - " + ChatColor.BLUE + "Clears players inventory.");
                        player.sendMessage(ChatColor.BLUE + "Page " + ChatColor.GREEN + "1 " + ChatColor.BLUE + "of " + ChatColor.GREEN + "4");
 
                    }
 
                    else if (args[0].equalsIgnoreCase("2")){
                    	// 17 LINES
                        player.sendMessage(ChatColor.GREEN + "--------------[" + ChatColor.BLUE + "EssentialsPro Command List" + ChatColor.GREEN + "]--------------");
                        player.sendMessage("");
                        player.sendMessage(ChatColor.GREEN + "/staffchat - " + ChatColor.BLUE + "Talk in a private chat with other staff.");
                        player.sendMessage(ChatColor.GREEN + "/kick - " + ChatColor.BLUE + "Kick a player.");
                        player.sendMessage(ChatColor.GREEN + "/ban - " + ChatColor.BLUE + "Ban a player.");
                        player.sendMessage(ChatColor.GREEN + "/unban - " + ChatColor.BLUE + "Unbans a player.");
                        player.sendMessage(ChatColor.GREEN + "/warp - " + ChatColor.BLUE + "Warp to a selcted location.");
                        player.sendMessage(ChatColor.GREEN + "/setwarp - " + ChatColor.BLUE + "Set a warp location.");
                        player.sendMessage(ChatColor.GREEN + "/delwarp - " + ChatColor.BLUE + "Removes the specified warp.");
                        player.sendMessage(ChatColor.GREEN + "/motd - " + ChatColor.BLUE + "Set the MOTD people see before joining.");
                    	player.sendMessage(ChatColor.BLUE + "Page " + ChatColor.GREEN + "2 " + ChatColor.BLUE + "of " + ChatColor.GREEN + "4");
                    }
                    else if (args[0].equalsIgnoreCase("3")){
                    	// 17 LINES
                        player.sendMessage(ChatColor.GREEN + "--------------[" + ChatColor.BLUE + "EssentialsPro Command List" + ChatColor.GREEN + "]--------------");
                        player.sendMessage("");
                        player.sendMessage(ChatColor.GREEN + "/time - " + ChatColor.BLUE + "Set the time of the world.");
                        player.sendMessage(ChatColor.GREEN + "/weather - " + ChatColor.BLUE + "Set the weather of the world.");
                        player.sendMessage(ChatColor.GREEN + "/fly - " + ChatColor.BLUE + "Allows a player to enable and disable flying.");
                        player.sendMessage(ChatColor.GREEN + "/mute - " + ChatColor.BLUE + "Prevents a player from talking and seeing chat.");
                        player.sendMessage(ChatColor.GREEN + "/unmute - " + ChatColor.BLUE + "Allows a player to talk and see chat again.");
                        player.sendMessage(ChatColor.GREEN + "/invsee - " + ChatColor.BLUE + "Look into a players inventory.");
                        player.sendMessage(ChatColor.GREEN + "/vanish - " + ChatColor.BLUE + "Hides you in plain sight.");
                        player.sendMessage(ChatColor.GREEN + "/sethome - " + ChatColor.BLUE + "Allows you to set a home.");
                    	player.sendMessage(ChatColor.BLUE + "Page " + ChatColor.GREEN + "3 " + ChatColor.BLUE + "of " + ChatColor.GREEN + "4");
                    }
                    else if (args[0].equalsIgnoreCase("4")){
                    	// 17 LINES
                        player.sendMessage(ChatColor.GREEN + "--------------[" + ChatColor.BLUE + "EssentialsPro Command List" + ChatColor.GREEN + "]--------------");
                        player.sendMessage("");
                        player.sendMessage(ChatColor.GREEN + "/home - " + ChatColor.BLUE + "Sends you to your home.");
                        player.sendMessage(ChatColor.GREEN + "/pm - " + ChatColor.BLUE + "Private message a player.");
                        player.sendMessage(ChatColor.GREEN + "/nickname - " + ChatColor.BLUE + "Set a new nickname.");
                        player.sendMessage(ChatColor.GREEN + "/nickname off - " + ChatColor.BLUE + "remove nickname.");
                    	player.sendMessage(ChatColor.BLUE + "Page " + ChatColor.GREEN + "4 " + ChatColor.BLUE + "of " + ChatColor.GREEN + "4");
                    }
            }
                
        }
		return true;
	}
}
