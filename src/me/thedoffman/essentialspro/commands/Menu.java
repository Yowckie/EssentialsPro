package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Menu
implements CommandExecutor {
    public Menu(Main plugin) {
        Bukkit.getPluginCommand((String)"essentialspro").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("essentialspro")) {
            player.sendMessage((Object)ChatColor.GREEN + "--------------[" + (Object)ChatColor.BLUE + "EssentialsPro Command List" + (Object)ChatColor.GREEN + "]--------------");
            player.sendMessage("");
            player.sendMessage((Object)ChatColor.GREEN + "/heal - " + (Object)ChatColor.BLUE + "Heal yourself or another player.");
            player.sendMessage((Object)ChatColor.GREEN + "/feed - " + (Object)ChatColor.BLUE + "Feed yourself or another player.");
            player.sendMessage((Object)ChatColor.GREEN + "/clearchat - " + (Object)ChatColor.BLUE + "Globally clear chat.");
            player.sendMessage((Object)ChatColor.GREEN + "/teleport - " + (Object)ChatColor.BLUE + "Teleport to another player.");
            player.sendMessage((Object)ChatColor.GREEN + "/gamemode - " + (Object)ChatColor.BLUE + "Change you gamemode between Survival, Creative and Adventure.");
            player.sendMessage((Object)ChatColor.GREEN + "/spawn - " + (Object)ChatColor.BLUE + "Sends you to spawn.");
            player.sendMessage((Object)ChatColor.GREEN + "/setspawn - " + (Object)ChatColor.BLUE + "Set the spawn location.");
            player.sendMessage((Object)ChatColor.GREEN + "/ci - " + (Object)ChatColor.BLUE + "Clears players inventory.");
            player.sendMessage((Object)ChatColor.BLUE + "Page " + (Object)ChatColor.GREEN + "1 " + (Object)ChatColor.BLUE + "of " + (Object)ChatColor.GREEN + "4");
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("1")) {
                    player.sendMessage((Object)ChatColor.GREEN + "--------------[" + (Object)ChatColor.BLUE + "EssentialsPro Command List" + (Object)ChatColor.GREEN + "]--------------");
                    player.sendMessage("");
                    player.sendMessage((Object)ChatColor.GREEN + "/heal - " + (Object)ChatColor.BLUE + "Heal yourself or another player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/feed - " + (Object)ChatColor.BLUE + "Feed yourself or another player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/clearchat - " + (Object)ChatColor.BLUE + "Globally clear chat.");
                    player.sendMessage((Object)ChatColor.GREEN + "/teleport - " + (Object)ChatColor.BLUE + "Teleport to another player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/gamemode - " + (Object)ChatColor.BLUE + "Change you gamemode between Survival, Creative and Adventure.");
                    player.sendMessage((Object)ChatColor.GREEN + "/spawn - " + (Object)ChatColor.BLUE + "Sends you to spawn.");
                    player.sendMessage((Object)ChatColor.GREEN + "/setspawn - " + (Object)ChatColor.BLUE + "Set the spawn location.");
                    player.sendMessage((Object)ChatColor.GREEN + "/ci - " + (Object)ChatColor.BLUE + "Clears players inventory.");
                    player.sendMessage((Object)ChatColor.BLUE + "Page " + (Object)ChatColor.GREEN + "1 " + (Object)ChatColor.BLUE + "of " + (Object)ChatColor.GREEN + "4");
                } else if (args[0].equalsIgnoreCase("2")) {
                    player.sendMessage((Object)ChatColor.GREEN + "--------------[" + (Object)ChatColor.BLUE + "EssentialsPro Command List" + (Object)ChatColor.GREEN + "]--------------");
                    player.sendMessage("");
                    player.sendMessage((Object)ChatColor.GREEN + "/staffchat - " + (Object)ChatColor.BLUE + "Talk in a private chat with other staff.");
                    player.sendMessage((Object)ChatColor.GREEN + "/kick - " + (Object)ChatColor.BLUE + "Kick a player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/ban - " + (Object)ChatColor.BLUE + "Ban a player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/unban - " + (Object)ChatColor.BLUE + "Unbans a player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/warp - " + (Object)ChatColor.BLUE + "Warp to a selcted location.");
                    player.sendMessage((Object)ChatColor.GREEN + "/setwarp - " + (Object)ChatColor.BLUE + "Set a warp location.");
                    player.sendMessage((Object)ChatColor.GREEN + "/delwarp - " + (Object)ChatColor.BLUE + "Removes the specified warp.");
                    player.sendMessage((Object)ChatColor.GREEN + "/motd - " + (Object)ChatColor.BLUE + "Set the MOTD people see before joining.");
                    player.sendMessage((Object)ChatColor.BLUE + "Page " + (Object)ChatColor.GREEN + "2 " + (Object)ChatColor.BLUE + "of " + (Object)ChatColor.GREEN + "4");
                } else if (args[0].equalsIgnoreCase("3")) {
                    player.sendMessage((Object)ChatColor.GREEN + "--------------[" + (Object)ChatColor.BLUE + "EssentialsPro Command List" + (Object)ChatColor.GREEN + "]--------------");
                    player.sendMessage("");
                    player.sendMessage((Object)ChatColor.GREEN + "/time - " + (Object)ChatColor.BLUE + "Set the time of the world.");
                    player.sendMessage((Object)ChatColor.GREEN + "/weather - " + (Object)ChatColor.BLUE + "Set the weather of the world.");
                    player.sendMessage((Object)ChatColor.GREEN + "/fly - " + (Object)ChatColor.BLUE + "Allows a player to enable and disable flying.");
                    player.sendMessage((Object)ChatColor.GREEN + "/mute - " + (Object)ChatColor.BLUE + "Prevents a player from talking and seeing chat.");
                    player.sendMessage((Object)ChatColor.GREEN + "/unmute - " + (Object)ChatColor.BLUE + "Allows a player to talk and see chat again.");
                    player.sendMessage((Object)ChatColor.GREEN + "/invsee - " + (Object)ChatColor.BLUE + "Look into a players inventory.");
                    player.sendMessage((Object)ChatColor.GREEN + "/vanish - " + (Object)ChatColor.BLUE + "Hides you in plain sight.");
                    player.sendMessage((Object)ChatColor.GREEN + "/sethome - " + (Object)ChatColor.BLUE + "Allows you to set a home.");
                    player.sendMessage((Object)ChatColor.BLUE + "Page " + (Object)ChatColor.GREEN + "3 " + (Object)ChatColor.BLUE + "of " + (Object)ChatColor.GREEN + "4");
                } else if (args[0].equalsIgnoreCase("4")) {
                    player.sendMessage((Object)ChatColor.GREEN + "--------------[" + (Object)ChatColor.BLUE + "EssentialsPro Command List" + (Object)ChatColor.GREEN + "]--------------");
                    player.sendMessage("");
                    player.sendMessage((Object)ChatColor.GREEN + "/home - " + (Object)ChatColor.BLUE + "Sends you to your home.");
                    player.sendMessage((Object)ChatColor.GREEN + "/pm - " + (Object)ChatColor.BLUE + "Private message a player.");
                    player.sendMessage((Object)ChatColor.GREEN + "/nickname - " + (Object)ChatColor.BLUE + "Set a new nickname.");
                    player.sendMessage((Object)ChatColor.GREEN + "/nickname off - " + (Object)ChatColor.BLUE + "remove nickname.");
                    player.sendMessage((Object)ChatColor.BLUE + "Page " + (Object)ChatColor.GREEN + "4 " + (Object)ChatColor.BLUE + "of " + (Object)ChatColor.GREEN + "4");
                }
            }
        }
        return true;
    }
}

