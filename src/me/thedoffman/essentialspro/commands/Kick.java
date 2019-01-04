package me.thedoffman.essentialspro.commands;

import me.thedoffman.essentialspro.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick
implements CommandExecutor {
    private static Main plugin = (Main)Main.getPlugin(Main.class);

    public Kick(Main plugin) {
        Bukkit.getPluginCommand((String)"kick").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Kick.plugin.prefix = Kick.plugin.prefix.replaceAll("&", "§");
        if (label.equalsIgnoreCase("kick")) {
            if (!sender.hasPermission("ep.kick")) {
                sender.sendMessage((Object)ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(Kick.plugin.prefix) + (Object)ChatColor.RED + "Please specify a player and reason!");
            } else if (args.length == 1) {
                sender.sendMessage(String.valueOf(Kick.plugin.prefix) + (Object)ChatColor.RED + "Please specify a reason!");
            } else {
                @SuppressWarnings("deprecation")
				Player target = Bukkit.getPlayer((String)args[0]);
                if (target == null) {
                    sender.sendMessage(String.valueOf(Kick.plugin.prefix) + (Object)ChatColor.RED + args[0] + " is not online!");
                    return true;
                }
                StringBuilder x = new StringBuilder();
                int i = 1;
                while (i < args.length) {
                    x.append(String.valueOf(args[i]) + " ");
                    ++i;
                }
                String kicker = "Server";
                if (sender instanceof Player) {
                    kicker = sender.getName();
                }
                target.kickPlayer(String.valueOf(Kick.plugin.prefix) + (Object)ChatColor.RED + "You have been kicked from the server!\nBy: " + kicker + "\nReason: " + x.toString().trim());
                sender.sendMessage(String.valueOf(Kick.plugin.prefix) + (Object)ChatColor.GREEN + "Successfully kicked: " + target.getName());
            }
        }
        return true;
    }
}

